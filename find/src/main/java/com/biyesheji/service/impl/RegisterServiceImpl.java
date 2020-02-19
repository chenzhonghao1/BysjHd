package com.biyesheji.service.impl;

import com.biyesheji.dao.LoginMapper;
import com.biyesheji.dao.RegisterMapper;
import com.biyesheji.dto.MobileDto;
import com.biyesheji.dto.RegisterDto;
import com.biyesheji.dto.UserDto;
import com.biyesheji.dto.UsernameDto;
import com.biyesheji.qo.MobileQo;
import com.biyesheji.qo.RegisterQo;
import com.biyesheji.qo.UserQo;
import com.biyesheji.qo.UsernameQo;
import com.biyesheji.service.LoginService;
import com.biyesheji.service.RegisterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RegisterServiceImpl implements RegisterService {
    @Resource
    private RegisterMapper registerMapper;
    @Override
    public  MobileDto mobile(MobileQo mobileQo) {
        MobileDto mobileDto = registerMapper.mobile(mobileQo);
        return mobileDto;
    }

    @Override
    public UsernameDto username(UsernameQo usernameQo) {
        UsernameDto usernameDto = registerMapper.username(usernameQo);
        return usernameDto;
    }

    @Override
    public void register(RegisterQo registerQo) {
        registerMapper.register(registerQo);
    }
}
