package com.korit.springboot_study.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigA {
    @Autowired
    private ClassA a;
    @Autowired
    private ClassB b;
    @Bean
    public void call() {
        System.out.println("ConfigA call");
        a.classCallA();
        b.classCallB();
        System.out.println(b.getC1());
        System.out.println(b.getC2());
    }
}
