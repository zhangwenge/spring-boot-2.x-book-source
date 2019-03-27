package com.tgy.springboot2.xbook.springboot2xbookc12.dao;

import com.tgy.springboot2.xbook.springboot2xbookc12.pojo.UserPo;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    UserPo getUserByName(@Param("name") String name);
}
