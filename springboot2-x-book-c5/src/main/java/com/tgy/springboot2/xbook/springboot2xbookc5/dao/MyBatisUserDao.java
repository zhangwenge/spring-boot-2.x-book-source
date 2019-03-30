package com.tgy.springboot2.xbook.springboot2xbookc5.dao;

import com.tgy.springboot2.xbook.springboot2xbookc5.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyBatisUserDao {
    User getUser(Long id);

    List<User> getUsersByName(String name);
}
