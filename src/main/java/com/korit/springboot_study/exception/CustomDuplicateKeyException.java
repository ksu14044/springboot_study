package com.korit.springboot_study.exception;

import lombok.Getter;
import org.springframework.dao.DuplicateKeyException;

import java.util.Map;

@Getter
public class CustomDuplicateKeyException extends DuplicateKeyException {

    private Map<String, String> errors;

    public CustomDuplicateKeyException(String msg) {
        super(msg);
    }

    public CustomDuplicateKeyException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public CustomDuplicateKeyException(String msg, Map<String, String> errors) {
        super(msg);
        this.errors = errors;
    }
}
