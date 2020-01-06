package com.biyesheji.find.service.impl;

import com.biyesheji.find.dao.LoginMapper;
import com.biyesheji.find.qo.UserQo;
import com.biyesheji.find.service.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    private LoginMapper loginMapper;
    @Override
    public boolean login(UserQo userQo) {
        if (loginMapper.login(userQo)) {
            return true;
        }
            return false;
    }
}
