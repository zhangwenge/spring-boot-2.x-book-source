package com.tgy.springboot2.xbook.springboot2xbookc10;

import com.alibaba.fastjson.JSON;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @ClassName StringToPersonConverter
 */
@Component
public class StringToPersonConverter implements Converter<String, BigPerson> {

    @Override
    public BigPerson convert(String source) {
        System.out.println(source);
        BigPerson baseObject = JSON.parseObject(source, BigPerson.class);
        return baseObject;
    }
}
