package com.tgy.springboot2.xbook.springboot2xbookc5.dao;

import com.tgy.springboot2.xbook.springboot2xbookc5.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface MyBatisUserDao {
    User getUser(Long id);
}
