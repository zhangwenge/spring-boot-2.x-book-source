package com.tgy.springboot2.xbook.springboot2xbookc11;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName TestMainObject
 */
public class TestMainObject {
    public static void main(String[] args) {
//        getUser(1L);
        User user = new User();
        user.setId(12L);
        user.setName("tgy");
        user.setAge(12);
//        getUser(user);
        addUser(user);
    }

    public static User getUser(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        User forObject = restTemplate.getForObject("http://localhost:8080/getUser/{id}", User.class, id);
        System.out.println(forObject);
        return forObject;
    }

    public static User getUser(User user) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<User> request = new HttpEntity<>(user, headers);
        RestTemplate tm = new RestTemplate();
        Map<String, Object> map = new HashMap<>();
        map.put("name", user.getName());
        map.put("age", user.getAge());
        map.put("id", user.getId());
        ResponseEntity<User> forEntity = tm.getForEntity("http://localhost:8080/getUser1", User.class, map);
        User body = forEntity.getBody();
        System.out.println(body);
        return body;
    }

    public static User addUser(User user) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PROBLEM_JSON_UTF8);
        HttpEntity<User> request = new HttpEntity<>(user, headers);
        RestTemplate tm = new RestTemplate();
        User user1 = tm.postForObject("http://localhost:8080/addUser", request, User.class);
        System.out.println(user1);
        return user1;
    }
}
