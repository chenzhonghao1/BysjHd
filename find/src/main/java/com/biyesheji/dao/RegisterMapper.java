package com.biyesheji.dao;

import com.biyesheji.dto.MobileDto;
import com.biyesheji.dto.RegisterDto;
import com.biyesheji.dto.UsernameDto;
import com.biyesheji.qo.MobileQo;
import com.biyesheji.qo.RegisterQo;
import com.biyesheji.qo.UsernameQo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RegisterMapper {
    //验证手机号码是否存在
    MobileDto mobile(MobileQo mobileQo);
    //验证用户是否存在
    UsernameDto username(UsernameQo usernameQo);
    //注册
    void register(RegisterQo registerQo);
}
