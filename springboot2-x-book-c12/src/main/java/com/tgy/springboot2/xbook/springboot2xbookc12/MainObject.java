package com.tgy.springboot2.xbook.springboot2xbookc12;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

/**
 * @ClassName MainObject
 */
public class MainObject {
    public static void main(String[] args) {
        PasswordEncoder passwordEncoder = new Pbkdf2PasswordEncoder("tgy130675");
        System.out.println(passwordEncoder.encode("tgy130675"));
        System.out.println(passwordEncoder.encode("lqh130675"));
    }
}
