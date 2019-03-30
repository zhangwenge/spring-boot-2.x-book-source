package com.tgy.springboot2.xbook.springboot2xbookc6.service.impl;

import com.tgy.springboot2.xbook.springboot2xbookc6.dao.UserMapper;
import com.tgy.springboot2.xbook.springboot2xbookc6.po.User;
import com.tgy.springboot2.xbook.springboot2xbookc6.service.UserBatchService;
import com.tgy.springboot2.xbook.springboot2xbookc6.service.UserService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 描述：用户批量执行
 *
 * @author tianGuiYin
 * @date：2019/3/22 0:27
 */
@Service
public class UserBatchServiceImpl implements UserBatchService {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public int insertUsers(List<User> users) {
        int count = 0;
        UserBatchService bean = applicationContext.getBean(UserBatchService.class);
        for (User user : users) {
            int i = bean.insertUser(user);
            count += i;
        }
        return count;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW)
    public int insertUser(User user) {
        return userMapper.insertUser(user);
    }


}
