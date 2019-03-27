package com.tgy.springboot2.xbook.springboot2xbookc12;

import com.tgy.springboot2.xbook.springboot2xbookc12.pojo.RolePo;
import com.tgy.springboot2.xbook.springboot2xbookc12.pojo.UserPo;
import com.tgy.springboot2.xbook.springboot2xbookc12.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName TestController
 */
@Controller
public class TestController {

    @GetMapping("/user")
    @ResponseBody
    public Object user(User user, HttpSession session) {
        System.out.println(session.getId());
        return user;
    }

    @Autowired
    private UserRoleService userRoleService;

    @GetMapping("/role")
    @ResponseBody
    public Object role(String userName){
        if(StringUtils.isEmpty(userName)){
            userName = "tgy";
        }
        UserPo userByName = userRoleService.getUserByName(userName);
        List<RolePo> rolesByUserName = userRoleService.findRolesByUserName(userName);
        Map<String,Object> retMap = new HashMap<>();
        retMap.put("role",rolesByUserName);
        retMap.put("user",userByName);
        return retMap;


    }

}
