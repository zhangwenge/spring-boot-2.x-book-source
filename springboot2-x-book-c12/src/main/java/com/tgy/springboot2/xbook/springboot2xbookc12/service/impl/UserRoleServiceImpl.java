package com.tgy.springboot2.xbook.springboot2xbookc12.service.impl;

import com.tgy.springboot2.xbook.springboot2xbookc12.dao.RoleMapper;
import com.tgy.springboot2.xbook.springboot2xbookc12.dao.UserMapper;
import com.tgy.springboot2.xbook.springboot2xbookc12.pojo.RolePo;
import com.tgy.springboot2.xbook.springboot2xbookc12.pojo.UserPo;
import com.tgy.springboot2.xbook.springboot2xbookc12.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName UserRoleServiceImpl
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserPo getUserByName(String name) {
        UserPo uerPo = userMapper.getUserByName(name);
        return uerPo;
    }

    @Override
    public List<RolePo> findRolesByUserName(String userName) {
        List<RolePo> rolesByUserName = roleMapper.findRolesByUserName(userName);
        return rolesByUserName;

    }
}
