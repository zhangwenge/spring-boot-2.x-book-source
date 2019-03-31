package com.tgy.springboot2.xbook.springboot2xbookc15.dao;

import com.tgy.springboot2.xbook.springboot2xbookc15.po.ProductPo;
import org.apache.ibatis.annotations.Param;

public interface ProductMapper {
    ProductPo getProduct(long id);

    int decreaseProduct(@Param("id") Long id, @Param("quantity") int quantity,@Param("version") int version);
}
