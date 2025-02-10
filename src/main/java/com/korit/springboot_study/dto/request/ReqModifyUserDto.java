package com.korit.springboot_study.dto.request;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
public class ReqModifyUserDto {
    @NotNull(message = "이메일 주소를 입력해 주세요.")
    @Email(message = "이메일 주소 형식으로 입력하세요.")
    private String email;
}
