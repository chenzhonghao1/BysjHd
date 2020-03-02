package com.biyesheji.dto;

import lombok.Data;

@Data
public class UserDto {
    private int code;
    private String flag;
    private String token;
    public UserDto(int code,String flag,String token) {
        this.code = code;
        this.flag = flag;
        this.token = token;
    }
    public UserDto(){};
}
