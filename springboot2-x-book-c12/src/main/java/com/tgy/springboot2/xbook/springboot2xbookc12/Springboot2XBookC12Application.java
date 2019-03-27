package com.tgy.springboot2.xbook.springboot2xbookc12;

import org.apache.commons.dbcp2.BasicDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.Map;

@SpringBootApplication
@MapperScan("com.tgy.springboot2.xbook.springboot2xbookc12.dao")
public class Springboot2XBookC12Application extends WebSecurityConfigurerAdapter  {

    public static void main(String[] args) {
        SpringApplication.run(Springboot2XBookC12Application.class, args);
    }

    @Value("${secureity.key}")
    private String key;

    @Autowired
    @Qualifier("userDetailsServiceImpl")
    private UserDetailsService userDetailsService;

    @Autowired
    private BasicDataSource dataSource;

    String pwdQuery = "select user_name,pwd,available from t_user where user_name = ?";
    String roleQuery = "select u.user_name,r.role_name " +
            "from t_user u,t_user_role ur,t_role r " +
            "where u.id = ur.user_id and r.id = ur.role_id " +
            "and u.user_name = ?";



    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        zidingyi(auth);
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
    }

    /**
     * 描述: db验证,带key的那种
     * @param auth
     * @return void
     * @throws
     * @author tianGuiYin
     * @Date 2019/3/27 23:20
     */
    private void zidingyi(AuthenticationManagerBuilder auth) throws Exception{
        PasswordEncoder passwordEncoder = new Pbkdf2PasswordEncoder(key);
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder);
    }

    /**
     * 描述: db验证
     * @param auth
     * @return void
     * @throws
     * @author tianGuiYin
     * @Date 2019/3/27 23:20
     */
    private void db1(AuthenticationManagerBuilder auth) throws Exception{
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        auth.jdbcAuthentication()
                .passwordEncoder(passwordEncoder)
                .dataSource(dataSource)
                .usersByUsernameQuery(pwdQuery)
                .authoritiesByUsernameQuery(roleQuery);
    }

    /**
     * 描述: db验证,带key的那种
     * @param auth
     * @return void
     * @throws
     * @author tianGuiYin
     * @Date 2019/3/27 23:20
     */
    private void db2(AuthenticationManagerBuilder auth) throws Exception{
        PasswordEncoder passwordEncoder = new Pbkdf2PasswordEncoder(key);
        auth.jdbcAuthentication()
                .passwordEncoder(passwordEncoder)
                .dataSource(dataSource)
                .usersByUsernameQuery(pwdQuery)
                .authoritiesByUsernameQuery(roleQuery);
    }



    /**
     * 描述: 内存1
     * @param auth
     * @return void
     * @throws
     * @author tianGuiYin
     * @Date 2019/3/27 23:04
     */
    private void m1(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String abc = passwordEncoder.encode("abc");
        auth.inMemoryAuthentication()
                .passwordEncoder(passwordEncoder)
                .withUser("admin")
                .password(abc)
                .roles("USER","ADMIN")
                .and()
                .withUser("myuser")
                .password(abc)
                .roles("USER");
    }

    /**
     * 描述: 内存2
     * @param auth
     * @return void
     * @throws
     * @author tianGuiYin
     * @Date 2019/3/27 23:04
     */
    private void m2(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String abc = passwordEncoder.encode("abc");
        InMemoryUserDetailsManagerConfigurer<AuthenticationManagerBuilder> userConfig
                = auth.inMemoryAuthentication().passwordEncoder(passwordEncoder);
        userConfig.withUser("admin")
                .password(abc)
                .authorities("ROLE_USER","ROLE_ADMIN");
        userConfig.withUser("myuser")
                .password(passwordEncoder.encode("123456"))
                .authorities("ROLE_USER");
    }


}
