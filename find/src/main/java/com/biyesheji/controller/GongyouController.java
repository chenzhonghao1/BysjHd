package com.biyesheji.controller;

import com.biyesheji.Util.ConstantsUtil;
import com.biyesheji.dto.DdDto;
import com.biyesheji.dto.MsDto;
import com.biyesheji.dto.SslxDto;
import com.biyesheji.interceptor.NoInterceptor;
import com.biyesheji.service.GongyouService;
import com.biyesheji.service.ZhaolingService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class GongyouController {


    private String uploadUrl="G:/photo";

    @Resource
    private GongyouService gongyouService;
    //选择框下拉的捡到（丢失）地点
    @PostMapping(value = "api/listdd")
    @ResponseBody
    @CrossOrigin
    public List<DdDto> listdd(){
        return gongyouService.listdd();
    }

    //选择框下拉的物品类型
    @PostMapping(value = "api/listwpsslx")
    @ResponseBody
    @CrossOrigin
    public List<SslxDto> listwpsslx(){
        return gongyouService.listwpsslx();
    }

    //上传图片
    @PostMapping("api/uploadfile")
    @ResponseBody
    @NoInterceptor
    @CrossOrigin
    public Map<String, Object> uploadFile(MultipartFile file, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        //倘若不存在文件夹，创建一个新的文件夹
        String path = this.uploadUrl;
        File filePath = new File(path);
        if (!filePath.exists()) {
            filePath.mkdirs();
        }
        //获取文件名字
        String fileName = file.getOriginalFilename();
        File dir = new File(path, fileName);
        if (!file.isEmpty()) {
            try {
                file.transferTo(dir);
                //项目url，这里可以使用常量或者去数据字典获取相应的url前缀；
                String fileUrl="http://localhost:8888";
                //文件获取路径
                fileUrl = fileUrl + request.getContextPath() + "/photo/" + fileName;
                map.put(ConstantsUtil.CODE, 200);
                map.put(ConstantsUtil.MSG, fileUrl);
            } catch (IOException e) {
                e.printStackTrace();
                map.put(ConstantsUtil.CODE, -1);
                map.put(ConstantsUtil.MSG, ConstantsUtil.EXECUTE_FAIL);
            }
        } else {
            map.put(ConstantsUtil.CODE, -1);
            map.put(ConstantsUtil.MSG, ConstantsUtil.EXECUTE_FAIL);
        }
        return map;
    }

}
