package com.biyesheji.find.dao;

import com.biyesheji.find.qo.UserQo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {
    //登录
    boolean login(UserQo userQo);
}
