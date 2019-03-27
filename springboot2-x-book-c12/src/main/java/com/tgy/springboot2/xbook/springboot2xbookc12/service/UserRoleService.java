package com.tgy.springboot2.xbook.springboot2xbookc12.service;

import com.tgy.springboot2.xbook.springboot2xbookc12.pojo.RolePo;
import com.tgy.springboot2.xbook.springboot2xbookc12.pojo.UserPo;

import java.util.List;

/**
 * @ClassName UserService
 */
public interface UserRoleService {
    UserPo getUserByName(String name);
    List<RolePo> findRolesByUserName(String userName);
}
