package com.biyesheji.service;

import com.biyesheji.dto.MobileDto;
import com.biyesheji.dto.RegisterDto;
import com.biyesheji.dto.UsernameDto;
import com.biyesheji.qo.MobileQo;
import com.biyesheji.qo.RegisterQo;
import com.biyesheji.qo.UsernameQo;

public interface RegisterService {
    //验证手机号码是否存在
    public MobileDto mobile(MobileQo mobileQo);
    //验证用户名是否存在
    public UsernameDto username(UsernameQo usernameQo);
    //注册
    public void register(RegisterQo registerQo);
}
