package com.biyesheji.controller;

import com.biyesheji.Util.TokenUtil;
import com.biyesheji.dto.UserDto;
import com.biyesheji.qo.UserQo;
import com.biyesheji.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    //登录
    @Resource
    private LoginService loginService;

    @PostMapping(value = "api/login")
    @ResponseBody
    @CrossOrigin
    public UserDto login(@RequestBody UserQo userQo){
// 对 html 标签进行转义，防止 XSS 攻击
        UserDto userDto = loginService.login(userQo);
        String token= TokenUtil.sign(userQo);
        if (userDto.getCode()==1) {
            return new UserDto(200,userDto.getFlag(),token);
        } else {
            String message = "账号密码错误";
            return new UserDto(400,userDto.getFlag(),token);
        }
    }
}

