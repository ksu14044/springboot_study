package com.korit.springboot_study.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Pattern;

@Data
public class ReqFindBookDTO {
    @ApiModelProperty(value = "도서명", example = "도서", required = true)
    private String bookName;
}
