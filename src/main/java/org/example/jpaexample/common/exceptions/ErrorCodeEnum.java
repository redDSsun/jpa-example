package org.example.jpaexample.common.exceptions;

public enum ErrorCodeEnum {

    DEFAULT_ERROR(500000, "default error"),
    INVALID_USER(400001, "invalid user");

    private int code;
    private String description;

    ErrorCodeEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
