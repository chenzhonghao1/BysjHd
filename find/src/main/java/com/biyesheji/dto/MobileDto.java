package com.biyesheji.dto;

import lombok.Data;

@Data
public class MobileDto {
    private int status;
    private String msg = null;
    public MobileDto(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }
}
