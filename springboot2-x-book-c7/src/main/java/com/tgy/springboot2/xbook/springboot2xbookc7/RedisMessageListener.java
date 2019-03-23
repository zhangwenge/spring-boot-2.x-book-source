package com.tgy.springboot2.xbook.springboot2xbookc7;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName RedisMessageListener
 */
@Component
public class RedisMessageListener implements MessageListener {

    @Override
    public void onMessage(Message message, byte[] bytes) {
        String body = new String(message.getBody());
        String topic = new String(bytes);
        System.out.println("body:" + body);
        System.out.println("topic: "+ topic);
    }
}
