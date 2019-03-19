package com.tgy.springboot2.xbook.springboot2xbookc6.service;


import com.tgy.springboot2.xbook.springboot2xbookc6.po.User;

public interface UserService {
    User getUser(Long id);
    int insertUser(User user);
}
