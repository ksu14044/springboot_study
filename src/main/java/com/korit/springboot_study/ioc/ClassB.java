package com.korit.springboot_study.ioc;

import org.springframework.stereotype.Component;

@Component
public class ClassB {

    public void classCallB() {
        System.out.println("ClassB 메소드 호출");
    }
}
