package com.biyesheji.dto;

import lombok.Data;

@Data
public class UserDto {
    private int code;
    private String flag;
    public UserDto(int code,String flag) {
        this.code = code;
        this.flag = flag;
    }
}
