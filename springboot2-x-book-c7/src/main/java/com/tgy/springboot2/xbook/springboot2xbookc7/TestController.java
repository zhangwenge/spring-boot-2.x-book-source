package com.tgy.springboot2.xbook.springboot2xbookc7;

import jdk.nashorn.internal.scripts.JD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName TestController
 */
@RestController
public class TestController {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping("/stringAndHash")
    public Map<String, Object> test() {
        Map<String, Object> retMap = new HashMap<>();
//        redisTemplate.opsForValue().set("key1","value1");
//        stringRedisTemplate.opsForValue().set("int","1");
//        stringRedisTemplate.opsForValue().increment("int",1);
//        Jedis jedis = (Jedis)stringRedisTemplate.getConnectionFactory().getConnection().getNativeConnection();
//        jedis.decr("int");
        /*Map<String,String> hash = new HashMap<>();
        hash.put("f1","v1");
        hash.put("f2","v2");
        stringRedisTemplate.opsForHash().putAll("hash",hash);*/

//        stringRedisTemplate.opsForHash().put("hash","f3","v3");

        BoundHashOperations<String, Object, Object> hash = stringRedisTemplate.boundHashOps("hash");
        hash.delete("f1", "f2");
        hash.put("f4", "v4");

        return retMap;
    }
}
