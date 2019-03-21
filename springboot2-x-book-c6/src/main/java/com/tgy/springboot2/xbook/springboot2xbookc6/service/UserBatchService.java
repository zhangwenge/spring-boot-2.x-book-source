package com.tgy.springboot2.xbook.springboot2xbookc6.service;

import com.tgy.springboot2.xbook.springboot2xbookc6.po.User;

import java.util.List;

/**
 * 描述：用户批量执行
 * @author tianGuiYin      
 * @date：2019/3/22 0:27
 */
public interface UserBatchService {


    /**
     * 描述: 批量插入用户
     * @param users
     * @return int
     * @throws
     * @author tianGuiYin
     * @Date 2019/3/22 0:27
     */
    int insertUsers(List<User> users);

    int insertUser(User user);
}
