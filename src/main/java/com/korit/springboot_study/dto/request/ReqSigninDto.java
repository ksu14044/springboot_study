package com.korit.springboot_study.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Pattern;

@Data
public class ReqSigninDto {

    @ApiModelProperty(value = "사용자 이름", example = "user1234", required = true)
    @Pattern(regexp = "^[a-zA-Z][a-zA-Z0-9]{0,14}$", message = "(3~15자, 알파벳과 숫자만 사용 가능)")
    private String username;

    @ApiModelProperty(value = "비밀번호", example = "User12345678!", required = true)
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!])[A-Za-z\\d@#$%^&+=!]{8,}$", message = "(최소 8자 이상, 대소문자, 숫자, 특수문자 포함)")
    private String password;

}
