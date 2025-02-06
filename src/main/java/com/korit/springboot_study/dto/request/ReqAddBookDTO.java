package com.korit.springboot_study.dto.request;

import lombok.Data;

@Data
public class ReqAddBookDTO {
    private String bookName;
    private int authorId;
    private int publisherId;
}
