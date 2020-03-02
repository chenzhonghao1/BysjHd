package com.biyesheji.dao;

import com.biyesheji.dto.DdDto;
import com.biyesheji.dto.SslxDto;
import com.biyesheji.dto.UserDto;
import com.biyesheji.qo.UserQo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GongyouMapper {
    //选择框下拉的捡到（丢失）地点
    List<DdDto> listdd();
    //选择框下拉的物品类型
    List<SslxDto> listwpsslx();
}
