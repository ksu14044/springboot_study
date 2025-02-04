package com.korit.springboot_study.ioc;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component(value = "c2")
@Data
public class ClassC2 implements ClassC{

    private int id =3;
    private String name = "c2";

    @Override
    public void classCallC() {
        System.out.println("ClassC2 호출");
    }
}
