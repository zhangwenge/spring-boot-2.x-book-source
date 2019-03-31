package com.tgy.springboot2.xbook.springboot2xbookc15.utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;
import org.apache.http.util.EntityUtils;
import org.springframework.util.Assert;

import javax.net.ssl.SSLContext;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 描述：http工具类
 *
 * @author tianGuiYin
 * @date：2018/11/23 16:43
 */
public class HttpClientUtils {
    private static final CloseableHttpClient httpClient;
    public static final String CHARSET = "UTF-8";


    // 采用静态代码块，初始化超时时间配置，再根据配置生成默认httpClient对象
    static {
        RequestConfig config = RequestConfig.custom().setConnectTimeout(60000).setSocketTimeout(15000).build();
        httpClient = HttpClientBuilder.create().setDefaultRequestConfig(config).build();
    }


    /**
     * 描述: 使用默认字符集（UTF-8）发送get请求
     *
     * @param url, params
     * @return java.lang.String
     * @throws
     * @author tianGuiYin
     * @Date 2018/11/26 9:49
     */
    public static String doGet(String url, Map<String, String> params) {
        return doGet(url, params, CHARSET);
    }

    /**
     * 描述: 使用默认字符集（UTF-8）发送get请求，不带参数
     *
     * @param url, params
     * @return java.lang.String
     * @throws
     * @author tianGuiYin
     * @Date 2018/11/26 9:49
     */
    public static String doGetOnlyUrl(String url) {
        return doGet(url, null, CHARSET);
    }

    public static String doGetSSL(String url, Map<String, String> params) {
        return doGetSSL(url, params, CHARSET);
    }


    /**
     * 描述: 使用默认字符集（utf-8）发送post请求
     *
     * @param url, params
     * @return java.lang.String
     * @throws
     * @author tianGuiYin
     * @Date 2018/11/26 9:50
     */
    public static String doPost(String url, Map<String, String> params) throws IOException {
        return doPost(url, params, CHARSET);
    }

    /**
     * HTTP Get 获取内容
     *
     * @param params  请求的参数
     * @param url     请求的url地址 ?之前的地址
     * @param charset 编码格式
     * @return 页面内容
     */
    public static String doGet(String url, Map<String, String> params, String charset) {
        Assert.notNull(url, HttpClientUtils.class.getSimpleName() + "：请求url不能为空");
        //请求url必须是http或https打头的地址
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            throw new IllegalArgumentException("http请求地址必须是http或者https开头");
        }
        try {
            url = sortGetUrl(url, params, charset);
            HttpGet httpGet = new HttpGet(url);
            CloseableHttpResponse response = httpClient.execute(httpGet);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == HttpStatus.SC_OK) {
                HttpEntity entity = response.getEntity();
                String result = null;
                if (entity != null) {
                    result = EntityUtils.toString(entity, charset);
                }
                EntityUtils.consume(entity);
                response.close();
                return result;
            } else {
                httpGet.abort();
                throw new RuntimeException("HttpClient,error status code :" + statusCode);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * HTTP Post 获取内容
     *
     * @param params  请求的参数
     * @param url     请求的url地址 ?之前的地址
     * @param charset 编码格式
     * @return 页面内容
     * @throws IOException
     */
    public static String doPost(String url, Map<String, String> params, String charset)
            throws IOException {
        Assert.notNull(url, HttpClientUtils.class.getSimpleName() + "：请求url不能为空");
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            throw new IllegalArgumentException("http请求地址必须是http或者https开头");
        }
        List<NameValuePair> pairs = new ArrayList<NameValuePair>();
        if (params != null && !params.isEmpty()) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                String value = entry.getValue();
                if (value != null) {
                    pairs.add(new BasicNameValuePair(entry.getKey(), value));
                }
            }
        }
        HttpPost httpPost = new HttpPost(url);
        if (!pairs.isEmpty()) {
            httpPost.setEntity(new UrlEncodedFormEntity(pairs, charset));
        }
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpPost);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == HttpStatus.SC_OK) {
                HttpEntity entity = response.getEntity();
                String result = null;
                if (entity != null) {
                    result = EntityUtils.toString(entity, charset);
                }
                EntityUtils.consume(entity);
                return result;
            } else {
                httpPost.abort();
                throw new RuntimeException("HttpClient,error status code :" + statusCode);
            }

        } catch (ParseException e) {
            throw e;
        } finally {
            if (response != null) {
                response.close();
            }
        }
    }

    /**
     * HTTPS Get 获取内容
     *
     * @param params  请求的参数
     * @param charset 编码格式
     * @param url     请求的url地址 ?之前的地址
     * @param charset 编码格式
     * @return 页面内容
     */
    public static String doGetSSL(String url, Map<String, String> params, String charset) {
        Assert.notNull(url, HttpClientUtils.class.getSimpleName() + "：请求url不能为空");
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            throw new IllegalArgumentException("http请求地址必须是http或者https开头");
        }
        try {
            url = sortGetUrl(url, params, charset);
            HttpGet httpGet = new HttpGet(url);

            // https  注意这里获取https内容，使用了忽略证书的方式，当然还有其他的方式来获取https内容
            CloseableHttpClient httpsClient = createSSLClientDefault();
            CloseableHttpResponse response = httpsClient.execute(httpGet);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK) {
                httpGet.abort();
                throw new RuntimeException("HttpClient,error status code :" + statusCode);
            }
            HttpEntity entity = response.getEntity();
            String result = null;
            if (entity != null) {
                result = EntityUtils.toString(entity, charset);
            }
            EntityUtils.consume(entity);
            response.close();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 描述:根据入参map和字符集，整理get请求的url
     *
     * @param url, params, charset
     * @return java.lang.String
     * @throws
     * @author tianGuiYin
     * @Date 2018/11/26 9:43
     */
    private static String sortGetUrl(String url, Map<String, String> params, String charset) throws IOException {
        if (params != null && !params.isEmpty()) {
            List<NameValuePair> pairs = new ArrayList<NameValuePair>(params.size());
            for (Map.Entry<String, String> entry : params.entrySet()) {
                String value = entry.getValue();
                if (value != null) {
                    pairs.add(new BasicNameValuePair(entry.getKey(), value));
                }
            }
            url += "?" + EntityUtils.toString(new UrlEncodedFormEntity(pairs, charset));
        }
        return url;
    }

    /**
     * 这里创建了忽略整数验证的CloseableHttpClient对象
     *
     * @return
     */
    public static CloseableHttpClient createSSLClientDefault() {
        try {
            SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
                // 信任所有
                @Override
                public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                    return true;
                }
            }).build();
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext);
            return HttpClients.custom().setSSLSocketFactory(sslsf).build();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        }
        return HttpClients.createDefault();
    }

    /**
     * 描述:通过get方式，从指定url下载文件到指定文件路径里面
     *
     * @param downloadUrl, filePath
     * @return java.lang.String 文件路径
     * @throws
     * @author tianGuiYin
     * @Date 2018/12/7 10:05
     */
    public static String downloadFileWithGet(String downloadUrl, String filePath) throws IOException {
        return download(downloadUrl, filePath, "GET");
    }

    /**
     * 描述:通过post方式，从指定url下载文件到指定文件路径里面
     *
     * @param downloadUrl, filePath
     * @return java.lang.String 文件路径
     * @throws
     * @author tianGuiYin
     * @Date 2018/12/7 10:05
     */
    public static String downloadFileWithPost(String downloadUrl, String filePath) throws IOException {
        return download(downloadUrl, filePath, "POST");
    }

    /**
     * 描述:从指定地址下载文件到指定文件里面
     *
     * @param downloadUrl, filePath, method
     * @return java.lang.String 返回文件路径
     * @throws
     * @author tianGuiYin
     * @Date 2018/12/7 10:03
     */
    private static String download(String downloadUrl, String filePath, String method) throws IOException {
        try {
            URL url = new URL(downloadUrl);
            HttpURLConnection httpUrlConnection = (HttpURLConnection) url.openConnection();
            httpUrlConnection.setConnectTimeout(5 * 1000);
            httpUrlConnection.setDoInput(true);
            httpUrlConnection.setDoOutput(true);
            httpUrlConnection.setUseCaches(false);
            httpUrlConnection.setRequestMethod(method);
            httpUrlConnection.setRequestProperty("CHARSET", CHARSET);
            httpUrlConnection.connect();
            InputStream fileInputStream = httpUrlConnection.getInputStream();
            File file = new File(filePath);
            //如果文件所在目录不存在，创建之
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            //如果文件存在，删除
            if (file.exists()) {
                file.deleteOnExit();
            }
            file.createNewFile();
            byte[] buffer = new byte[1024];
            FileOutputStream out = new FileOutputStream(file);
            int byteRead = -1;
            while ((byteRead = fileInputStream.read(buffer)) != -1) {
                out.write(buffer, 0, byteRead);
            }

            fileInputStream.close();
            out.close();
            httpUrlConnection.disconnect();
        } catch (Exception e) {
            throw e;
        }
        return filePath;
    }
}
