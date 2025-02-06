package com.korit.springboot_study.dto.request.study;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;

import javax.validation.constraints.Pattern;

@Data
public class ReqUpdateMajorDto {
    @ApiModelProperty(value = "학과명", example = "컴퓨터공학과", required = true)
    @Pattern(regexp = "^[가-힣]+$", message = "학과명은 반드시 한글로만 이루어져야 하며, 공백이나 빈 값은 허용되지 않습니다.")
    private String majorName;
}
