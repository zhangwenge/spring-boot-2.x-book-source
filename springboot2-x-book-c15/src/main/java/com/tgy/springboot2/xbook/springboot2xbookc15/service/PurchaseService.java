package com.tgy.springboot2.xbook.springboot2xbookc15.service;

/**
 * @ClassName PurchaseService
 */
public interface PurchaseService {

    boolean purchase(Long userId,Long productId,int quantity);
}
