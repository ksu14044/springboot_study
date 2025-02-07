package com.korit.springboot_study.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ReqSearchBookDto {
    @ApiModelProperty(value = "도서명", example = "소나기", required = false)
    private String keyword = "";
}
