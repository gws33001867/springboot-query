package com.example.springboottest.controller;

import com.example.springboottest.dto.UpdateBean;
import com.example.springboottest.model.ResultInfo;
import com.example.springboottest.service.UpdateService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/update")
@Api(value = "修改查询接口",tags = "接口Rest API")
@ApiIgnore
public class UpdateController {

    @Autowired
    UpdateService updateService;

    @RequestMapping("/updatequery")
    @CrossOrigin
    @ResponseBody
    public ResultInfo updateQuery(@RequestBody UpdateBean updateBean){

        ResultInfo resultInfo = new ResultInfo();
        //System.out.println(updateBean);
        int flag = updateService.updateQuery(updateBean);
        if(flag>0){
            resultInfo.setCode(200);
            resultInfo.setMsg("更新成功!");
            resultInfo.setResult(flag);
        }else{
            resultInfo.setCode(500);
            resultInfo.setMsg("更新失败!");
            resultInfo.setResult(flag);
        }
        return resultInfo;
    }
}
