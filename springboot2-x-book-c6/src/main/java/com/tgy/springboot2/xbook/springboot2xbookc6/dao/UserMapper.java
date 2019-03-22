package com.tgy.springboot2.xbook.springboot2xbookc6.dao;

import com.tgy.springboot2.xbook.springboot2xbookc6.po.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    User getUser(Long id);
    int insertUser(User user);
    List<User> getUsers();
}
