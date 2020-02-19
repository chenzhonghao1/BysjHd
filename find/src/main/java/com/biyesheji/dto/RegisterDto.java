package com.biyesheji.dto;

import lombok.Data;

@Data
public class RegisterDto {
    private int code;
    private String flag;
    public RegisterDto(int code, String flag) {
        this.code = code;
        this.flag = flag;
    }
}
