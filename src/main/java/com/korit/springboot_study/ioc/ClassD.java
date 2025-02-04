package com.korit.springboot_study.ioc;

import org.springframework.context.annotation.Bean;

public class ClassD {

    @Bean
    public void classDCall() {
        System.out.println("ClassD 메소드 호출");
    }
}
