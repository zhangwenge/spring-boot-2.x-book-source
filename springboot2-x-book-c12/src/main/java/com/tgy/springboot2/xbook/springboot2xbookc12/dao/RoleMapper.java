package com.tgy.springboot2.xbook.springboot2xbookc12.dao;

import com.tgy.springboot2.xbook.springboot2xbookc12.pojo.RolePo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
    List<RolePo> findRolesByUserName(@Param("name") String userName);
}
