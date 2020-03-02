package com.biyesheji.service.impl;

import com.biyesheji.dao.ShiwuMapper;
import com.biyesheji.dao.ZhaolingMapper;
import com.biyesheji.dto.MsDto;
import com.biyesheji.dto.SwmsDto;
import com.biyesheji.qo.SwQo;
import com.biyesheji.service.ShiwuService;
import com.biyesheji.service.ZhaolingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ShiwuServiceImpl implements ShiwuService {
    @Resource
    private ShiwuMapper shiwuMapper;
    @Override
    public List<SwmsDto> listswms() {

        return shiwuMapper.listswms();
    }

    @Override
    public int addsw(SwQo swQo) {
        return shiwuMapper.addsw(swQo);
    }
}
