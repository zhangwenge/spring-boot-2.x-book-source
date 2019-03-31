package com.tgy.springboot2.xbook.springboot2xbookc15.service.impl;

import com.tgy.springboot2.xbook.springboot2xbookc15.dao.ProductMapper;
import com.tgy.springboot2.xbook.springboot2xbookc15.dao.PurchaseRecordMapper;
import com.tgy.springboot2.xbook.springboot2xbookc15.po.ProductPo;
import com.tgy.springboot2.xbook.springboot2xbookc15.po.PurchaseRecordPo;
import com.tgy.springboot2.xbook.springboot2xbookc15.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName PurchaseServiceImpl
 */
@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private PurchaseRecordMapper purchaseRecordMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean purchase(Long userId, Long productId, int quantity) {

        //限制100ms执行完的逻辑，100ms执行不完，放弃执行,此种方式的弊端就是：系统会随着自身的忙碌而大大减少重入的次数，因为平均每次超过100ms的请求会随着请求量的增加而增加
        /*long start = System.currentTimeMillis();
        while(true){
            long end = System.currentTimeMillis();
            if(end -start > 100){
                System.out.println("100 ms 都更新失败了，被抢占了。。。。。。。");
                return false;
            }
            // 获取产品
            ProductPo product = productMapper.getProduct(productId);
            //比较库存和购买数量
            if(product.getStock() < quantity){
                return false;
            }
            int result = productMapper.decreaseProduct(productId, quantity, product.getVersion());
            if(result == 0){
                continue;
            }
            PurchaseRecordPo pr = initPurchaseRecord(userId,product,quantity);
            purchaseRecordMapper.insertPruchaseRecord(pr);
            return true;
        }*/

        for(int i=0;i<5;i++){
            // 获取产品
            ProductPo product = productMapper.getProduct(productId);
            //比较库存和购买数量
            if(product.getStock() < quantity){
                return false;
            }
            int result = productMapper.decreaseProduct(productId, quantity, product.getVersion());
            if(result == 0){
                continue;
            }
            PurchaseRecordPo pr = initPurchaseRecord(userId,product,quantity);
            purchaseRecordMapper.insertPruchaseRecord(pr);
            return true;
        }
        return false;

    }

    private PurchaseRecordPo initPurchaseRecord(Long userId, ProductPo product, int quantity) {
        PurchaseRecordPo pr = new PurchaseRecordPo();
        pr.setNote("购买日志，时间：" + System.currentTimeMillis());
        pr.setPrice(product.getPrice());
        pr.setProductId(product.getId());
        pr.setQuantity(quantity);
        double sum = product.getPrice() * quantity;
        pr.setSum(sum);
        pr.setUserId(userId);
        return pr;
    }
}
