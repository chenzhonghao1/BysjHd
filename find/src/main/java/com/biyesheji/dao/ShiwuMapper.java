package com.biyesheji.dao;

import com.biyesheji.dto.MsDto;
import com.biyesheji.dto.SwmsDto;
import com.biyesheji.qo.SwQo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShiwuMapper {
    //查询出物品名称，相关描述，捡到时间（时间按最近到最久排序）
    List<SwmsDto> listswms();
    //添加失物信息
    int addsw(SwQo swQo);
}
