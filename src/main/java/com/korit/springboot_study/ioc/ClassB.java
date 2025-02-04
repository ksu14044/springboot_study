package com.korit.springboot_study.ioc;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Component;

@Component
@Data
public class ClassB {
    @Qualifier(value = "c1")
    @Autowired
    private ClassC c1;
    @Qualifier(value = "c2")
    @Autowired
    private ClassC c2;

    public void classCallB() {
        System.out.println("ClassB 메소드 호출");

    }
}
