package com.tgy.springboot2.xbook.springboot2xbookc10;

import com.alibaba.fastjson.JSON;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Part;
import java.util.*;

/**
 * @ClassName MyController
 */
@RestController
public class MyController {

    @PostMapping("/no/noAnnotation")
    public Object noAnnotation(@RequestParam("int_val")
                                       Integer intVal, Long longVal, String str
            , Vo vo) {
        Map<String, Object> retMap = new HashMap<>();
        retMap.put("intVal", intVal);
        retMap.put("longVal", longVal);
        retMap.put("str", str);
        return retMap;
    }

    @PostMapping("/no/json")
    public Object json(@RequestBody User user) {
        return user;
    }

    @GetMapping("/no/{id}")
    public Object get(@PathVariable("id") Long id) {
        return id;
    }

    @PostMapping("/no/format")
    public Object format(/*@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)*/Date date,
                                                                           @NumberFormat(pattern = "#,###.##") Double numer) {
        Map<String, Object> retMap = new HashMap<>();
        retMap.put("date", date);
        retMap.put("numer", numer);
        return JSON.toJSONString(retMap);
    }

    @PostMapping("/no/converter")
    public Object convert(User user) {
        System.out.println(user);
        return user;
    }

    @PostMapping("/no/list")
    public Object list(List<User> userList) {
        return userList;
    }

    @PostMapping("/no/person")
    public Object person(Person person) {
        return person;
    }

    @PostMapping("/no/bigPerson")
    public Object persons(@RequestBody BigPerson bigPerson) {
        return bigPerson;
    }

    @PostMapping("/upload/part")
    public Map<String, Object> uploadPart(Part part) {
        String fileName = part.getSubmittedFileName();
        try {
            part.write(fileName);
        } catch (Exception e) {
            return dealResultMap(false, "上传失败");
        }
        return dealResultMap(true, "上传成功");
    }

    @PostMapping("/interceptor/test")
    public Object interceptor() {
        System.out.println("执行处理器逻辑");
        System.out.println(1 / 0);
        return "执行处理器逻辑";
    }


    private Map<String, Object> dealResultMap(boolean b, String msg) {
        Map<String, Object> retMap = new HashMap<>();
        retMap.put("success", b);
        retMap.put("msg", msg);
        return retMap;
    }
}
