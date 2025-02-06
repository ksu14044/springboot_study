package com.korit.springboot_study.exception;

import lombok.Getter;
import org.springframework.dao.DuplicateKeyException;

import java.util.Map;

@Getter
public class CustomNullPointException extends NullPointerException {

    private Map<String, String> errors;

    public CustomNullPointException(String msg) {
        super(msg);
    }

    public CustomNullPointException(String msg, Throwable cause) {
        super(msg);
    }

    public CustomNullPointException(String msg, Map<String, String> errors) {
        super(msg);
        this.errors = errors;
    }
}
