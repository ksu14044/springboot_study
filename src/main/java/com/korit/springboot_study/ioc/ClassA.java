package com.korit.springboot_study.ioc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Component;

@Component
public class ClassA {

    public void classCallA() {
        System.out.println("ClassA 메소드 호출");
    }
}
