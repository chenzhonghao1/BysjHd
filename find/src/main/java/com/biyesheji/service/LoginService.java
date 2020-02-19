package com.biyesheji.service;

import com.biyesheji.dto.UserDto;
import com.biyesheji.qo.UserQo;

public interface LoginService {
    //登录
    UserDto login(UserQo userQo);
}
