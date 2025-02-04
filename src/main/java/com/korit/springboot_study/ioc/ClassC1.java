package com.korit.springboot_study.ioc;

import org.springframework.stereotype.Component;

@Component
public class ClassC1 implements ClassC {
    @Override
    public void classCallC() {
        System.out.println("ClassC1 호출");
    }
}
