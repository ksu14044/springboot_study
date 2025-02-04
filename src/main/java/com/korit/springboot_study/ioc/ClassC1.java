package com.korit.springboot_study.ioc;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "c1")
@Data
public class ClassC1 implements ClassC {

    private int id = 2;
    private String name = "c1";

    @Override
    public void classCallC() {
        System.out.println("ClassC1 호출");
    }

}
