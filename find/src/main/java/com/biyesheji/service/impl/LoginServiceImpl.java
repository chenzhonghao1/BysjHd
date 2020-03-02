package com.biyesheji.service.impl;

import com.biyesheji.dao.LoginMapper;
import com.biyesheji.dto.UserDto;
import com.biyesheji.qo.UserQo;
import com.biyesheji.service.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    private LoginMapper loginMapper;
    @Override
    public UserDto login(UserQo userQo) {
        UserDto userDto = new UserDto();
        userDto = loginMapper.login(userQo);
        return userDto;
    }
}
