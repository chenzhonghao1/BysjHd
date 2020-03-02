package com.biyesheji.controller;

import com.biyesheji.dto.MsDto;
import com.biyesheji.dto.SwmsDto;
import com.biyesheji.qo.SwQo;
import com.biyesheji.service.ShiwuService;
import com.biyesheji.service.ZhaolingService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class ShiwuController {

    @Resource
    private ShiwuService shiwuService;
    //查询出物品名称，相关描述，捡到时间（时间按最近到最久排序）
    @PostMapping(value = "api/listswms")
    @ResponseBody
    @CrossOrigin
    public List<SwmsDto> listswms(){
        return shiwuService.listswms();
    }

    //添加失物信息
    @PostMapping(value = "api/addsw")
    @ResponseBody
    @CrossOrigin
    public int  addsw(@RequestBody SwQo swQo){
        String dssj = swQo.getDssj();
        dssj = dssj.substring(0, 10);
        swQo.setDssj(dssj);
        return shiwuService.addsw(swQo);
    }


}
