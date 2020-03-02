package com.biyesheji.service.impl;

import com.biyesheji.dao.LoginMapper;
import com.biyesheji.dao.ZhaolingMapper;
import com.biyesheji.dto.MsDto;
import com.biyesheji.dto.UserDto;
import com.biyesheji.qo.UserQo;
import com.biyesheji.service.LoginService;
import com.biyesheji.service.ZhaolingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ZhaolingServiceImpl implements ZhaolingService {
    @Resource
    private ZhaolingMapper zhaolingMapper;
    @Override
    public List<MsDto> listms() {

        return zhaolingMapper.listms();
    }
}
