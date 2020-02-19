package com.biyesheji.controller;

import com.biyesheji.dto.MobileDto;
import com.biyesheji.dto.RegisterDto;
import com.biyesheji.dto.UsernameDto;
import com.biyesheji.qo.MobileQo;
import com.biyesheji.qo.RegisterQo;
import com.biyesheji.qo.UsernameQo;
import com.biyesheji.service.RegisterService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
public class RegisterController {

    //注册
    @Resource
    private RegisterService registerService;

    //验证手机号码是否存在
    @PostMapping(value = "api/mobile")
    @ResponseBody
    @CrossOrigin
    @Transactional
    public MobileDto mobile(@RequestBody MobileQo mobileQo){
        MobileDto mobileDto = registerService.mobile(mobileQo);
        if (mobileDto.getStatus()==1) {
            return new MobileDto(1,"该手机已注册");
        } else {
            return new MobileDto(0,"该手机可以注册");
        }
    }

    //验证用户是否存在
    @PostMapping(value = "api/username")
    @ResponseBody
    @CrossOrigin
    @Transactional
    public UsernameDto username(@RequestBody UsernameQo usernameQo){
        UsernameDto usernameDto = registerService.username(usernameQo);
        if (usernameDto.getStatus()==1) {
            return new UsernameDto(1,"该用户名已注册");
        } else {
            return new UsernameDto(0,"该用户名可以注册");
        }
    }

    //注册
    @PostMapping(value = "api/register")
    @ResponseBody
    @CrossOrigin
    @Transactional
    public void register(@RequestBody RegisterQo registerQo){
        registerService.register(registerQo);
    }
}

