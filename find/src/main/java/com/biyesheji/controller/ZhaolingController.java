package com.biyesheji.controller;

import com.biyesheji.dto.MsDto;
import com.biyesheji.service.ZhaolingService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class ZhaolingController {

    @Resource
    private ZhaolingService zhaolingService;
    //查询出物品名称，相关描述，捡到时间（时间按最近到最久排序）
    @PostMapping(value = "api/listms")
    @ResponseBody
    @CrossOrigin
    public List<MsDto> listms(){
        return zhaolingService.listms();
    }
}
