package com.korit.springboot_study.ioc;

import org.springframework.stereotype.Component;

@Component
public class ClassC2 implements ClassC{
    @Override
    public void classCallC() {
        System.out.println("ClassC2 호출");
    }
}
