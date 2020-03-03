package com.biyesheji.service;

import com.biyesheji.dto.MsDto;
import com.biyesheji.dto.UserDto;
import com.biyesheji.qo.UserQo;
import com.biyesheji.qo.ZlQo;

import java.util.List;

public interface ZhaolingService {
    //查询出物品名称，相关描述，捡到时间（时间按最近到最久排序）
    List<MsDto> listms();
    //添加招领信息
    int addzl(ZlQo zlQo);
}
