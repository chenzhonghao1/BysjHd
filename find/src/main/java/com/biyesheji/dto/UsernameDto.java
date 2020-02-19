package com.biyesheji.dto;

import lombok.Data;

@Data
public class UsernameDto {
    private int status;
    private String msg = null;
    public UsernameDto(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }
}
