package com.tgy.springboot2.xbook.springboot2xbookc11;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName TestController
 */
@RestController
public class TestController {

    @GetMapping("/getUser/{id}")
    public Object getUser(@PathVariable Long id) {
        User user = new User();
        user.setId(id);
        user.setName("name_" + id);
        if (id != null) {
            user.setAge(id.intValue());
        }
        return user;
    }

    @GetMapping("/getUser1")
    public Object getUser(User user) {
        return user;
    }

    @PostMapping("/addUser")
    public Object addUser(@RequestBody User user) {
        return user;
    }


    @PostMapping("/deleteUser")
    public Object addUser(Long id) {
        User user = new User();
        user.setId(id);
        user.setName("delete_name_" + id);
        user.setAge(id.intValue());
        return user;
    }


}
