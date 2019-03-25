package com.tgy.springboot2.xbook.springboot2xbookc10;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName MainObject
 */
public class MainObject {
    public static void main(String[] args) {
        BigPerson bigPerson = new BigPerson();
        List<Person> persons = new ArrayList<>();
        Person person = new Person();
        person.setName("tgy");
        person.setAge(12);
        persons.add(person);
        bigPerson.setPersons(persons);
        System.out.println(JSON.toJSONString(bigPerson));
    }
}
