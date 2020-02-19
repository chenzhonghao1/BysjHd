package com.biyesheji.controller;

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
        String sjhm = userQo.getSjhm();
        sjhm = HtmlUtils.htmlEscape(sjhm);
        UserDto userDto = loginService.login(userQo);
        if (userDto.getCode()==1) {
            return new UserDto(200,userDto.getFlag());
        } else {
            String message = "账号密码错误";
            return new UserDto(400,userDto.getFlag());
        }
    }
}

