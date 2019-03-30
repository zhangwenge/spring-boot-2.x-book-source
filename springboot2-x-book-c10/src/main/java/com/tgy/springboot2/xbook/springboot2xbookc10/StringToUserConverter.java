package com.tgy.springboot2.xbook.springboot2xbookc10;


import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @ClassName StringToUserConverter
 */
@Component
public class StringToUserConverter implements Converter<String, User> {

    @Override
    public User convert(String source) {

        String[] strs = source.split("-");
        String userName = strs[0];
        String note = strs[1];
        User user = new User(userName, note);
        return user;
    }
}
