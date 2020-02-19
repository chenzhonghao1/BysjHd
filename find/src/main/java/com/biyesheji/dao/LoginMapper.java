package com.biyesheji.dao;

import com.biyesheji.dto.UserDto;
import com.biyesheji.qo.UserQo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {
    //登录
    UserDto login(UserQo userQo);
}
