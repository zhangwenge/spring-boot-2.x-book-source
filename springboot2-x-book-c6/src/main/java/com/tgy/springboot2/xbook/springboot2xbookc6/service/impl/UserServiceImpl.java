package com.tgy.springboot2.xbook.springboot2xbookc6.service.impl;

import com.tgy.springboot2.xbook.springboot2xbookc6.SexEnum;
import com.tgy.springboot2.xbook.springboot2xbookc6.dao.UserMapper;
import com.tgy.springboot2.xbook.springboot2xbookc6.po.User;
import com.tgy.springboot2.xbook.springboot2xbookc6.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName UserServiceImpl
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUser(Long id) {
        return userMapper.getUser(id);
    }

    @Override
    @Transactional(noRollbackFor = NullPointerException.class,rollbackFor = RuntimeException.class,isolation = Isolation.READ_COMMITTED)
    public int insertUser(User user) {
        String s = null;
        if(user.getId() != null){
            System.out.println("user id 不为空，手动设置为空");
            user.setId(null);
        }
        if(user.getSex() == null){
            user.setSex(SexEnum.FEMALE);
        }
        int i = userMapper.insertUser(user);
//        System.out.println(s.toUpperCase());
//        System.out.println(1/0);
        System.out.println("插入的id为：" + user.getId());
        return (int)user.getId().longValue();
    }
}
