package com.tgy.springboot2.xbook.springboot2xbookc6.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tgy.springboot2.xbook.springboot2xbookc6.common.vo.BaseRspBo;
import com.tgy.springboot2.xbook.springboot2xbookc6.common.vo.RspConstants;
import com.tgy.springboot2.xbook.springboot2xbookc6.controller.vo.UserBatchVo;
import com.tgy.springboot2.xbook.springboot2xbookc6.controller.vo.UserInsertBatchRspBo;
import com.tgy.springboot2.xbook.springboot2xbookc6.dao.UserMapper;
import com.tgy.springboot2.xbook.springboot2xbookc6.po.User;
import com.tgy.springboot2.xbook.springboot2xbookc6.service.UserBatchService;
import com.tgy.springboot2.xbook.springboot2xbookc6.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName UserController
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserBatchService userBatchService;

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/user")
    public Object getUser(User user) {
        User userR = userService.getUser(user.getId());
        return userR;
    }

    @RequestMapping("/page")
    public Object page() {
        PageHelper.startPage(2, 3);
        List<User> users = userMapper.getUsers();
        PageInfo page = new PageInfo(users);
        return users;
    }

    @RequestMapping("/insertUser")
    public Object insertUser(User user) {
        int i = userService.insertUser(user);
        return i;
    }

    @RequestMapping("/insertUsers")
    public UserInsertBatchRspBo insertUsers(UserBatchVo vo) {
        UserInsertBatchRspBo retBo = new UserInsertBatchRspBo();
        if (vo.getNames().size() != vo.getNotes().size()) {
            retBo.setRespCode(RspConstants.RESP_CODE_FAILED);
            retBo.setRespDesc("两个size必须一样");
            return retBo;
        }
        List<User> users = new ArrayList<>(21);
        List<String> notes = vo.getNotes();
        List<String> names = vo.getNames();
        for (int i = 0; i < notes.size(); i++) {
            User user = new User(names.get(i),notes.get(i));
            users.add(user);
        }
        int i = userBatchService.insertUsers(users);
        retBo.setRespCode(RspConstants.RESP_CODE_SUCCESS);
        retBo.setRespDesc(RspConstants.RESP_DESC_SUCCESS);
        retBo.setSuccess( i> 0);
        retBo.setUsers(users);
        return retBo;
    }


}
