package com.biyesheji.service.impl;

import com.biyesheji.dao.GongyouMapper;
import com.biyesheji.dao.LoginMapper;
import com.biyesheji.dto.DdDto;
import com.biyesheji.dto.SslxDto;
import com.biyesheji.dto.UserDto;
import com.biyesheji.qo.UserQo;
import com.biyesheji.service.GongyouService;
import com.biyesheji.service.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GongyouServiceImpl implements GongyouService {
    @Resource
    private GongyouMapper gongyouMapper;
    @Override
    public List<DdDto> listdd() {
        return gongyouMapper.listdd();
    }

    @Override
    public List<SslxDto> listwpsslx() {
        return gongyouMapper.listwpsslx();
    }
}
