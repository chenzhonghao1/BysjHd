package com.biyesheji.find.controller;

import com.biyesheji.find.dto.UserDto;
import com.biyesheji.find.qo.UserQo;
import com.biyesheji.find.service.LoginService;
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
        String username = userQo.getUsername();
        username = HtmlUtils.htmlEscape(username);

        if (loginService.login(userQo)) {
            return new UserDto(200);
        } else {
            String message = "账号密码错误";
            return new UserDto(400);
        }
    }
}

