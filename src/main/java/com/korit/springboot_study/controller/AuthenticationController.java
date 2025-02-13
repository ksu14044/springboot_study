package com.korit.springboot_study.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "계정 API")
public class AuthenticationController {

    @PostMapping("/api/auth/signup")
    
    @PostMapping("/api/auth/signin")
}
