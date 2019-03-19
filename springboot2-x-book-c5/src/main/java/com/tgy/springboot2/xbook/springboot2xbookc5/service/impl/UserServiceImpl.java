package com.tgy.springboot2.xbook.springboot2xbookc5.service.impl;

import com.tgy.springboot2.xbook.springboot2xbookc5.dao.MyBatisUserDao;
import com.tgy.springboot2.xbook.springboot2xbookc5.pojo.User;
import com.tgy.springboot2.xbook.springboot2xbookc5.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserServiceImpl
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private MyBatisUserDao myBatisUserDao;

    @Override
    public User getUser(Long id) {
        return myBatisUserDao.getUser(id);
    }
}
