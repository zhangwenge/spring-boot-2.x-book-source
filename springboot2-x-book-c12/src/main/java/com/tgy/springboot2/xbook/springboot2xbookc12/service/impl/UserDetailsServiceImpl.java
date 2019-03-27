package com.tgy.springboot2.xbook.springboot2xbookc12.service.impl;

import com.tgy.springboot2.xbook.springboot2xbookc12.pojo.RolePo;
import com.tgy.springboot2.xbook.springboot2xbookc12.pojo.UserPo;
import com.tgy.springboot2.xbook.springboot2xbookc12.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName UserDetailsServiceImpl
 */
@Service("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRoleService userRoleService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserPo userPo = userRoleService.getUserByName(userName);
        List<RolePo> roles = userRoleService.findRolesByUserName(userName);
        return changeToUser(userPo,roles);
    }

    private UserDetails changeToUser(UserPo userPo, List<RolePo> roles) {
        //权限列表
        List<GrantedAuthority> authorities = new ArrayList<>();
        //查询角色
        for(RolePo role : roles){
            GrantedAuthority authority = new SimpleGrantedAuthority(role.getRoleName());
            authorities.add(authority);
        }
        UserDetails userDetails = new User(userPo.getUserName(), userPo.getPwd(),authorities);
        return userDetails;
    }
}
