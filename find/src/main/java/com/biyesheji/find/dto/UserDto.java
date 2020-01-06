package com.biyesheji.find.dto;

import lombok.Data;

@Data
public class UserDto {
    private int code;
    public UserDto(int code) {
        this.code = code;
    }
}
