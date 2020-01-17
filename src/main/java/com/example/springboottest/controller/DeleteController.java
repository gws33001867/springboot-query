package com.example.springboottest.controller;

import com.example.springboottest.dto.AddQueryBean;
import com.example.springboottest.dto.DeleteConfigList_query;
import com.example.springboottest.model.ResultInfo;
import com.example.springboottest.service.DeleteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Api(value = "删除查询，列表的相关接口",tags = "删除查询Rest API")
@RestController
@RequestMapping("/delete")
public class DeleteController {

    @Autowired
    DeleteService deleteService;

    @RequestMapping("/deleteConfigList")
    @CrossOrigin
    @ResponseBody
    @ApiOperation(value = "删除查询列表",httpMethod = "GET")
    public ResultInfo deleteConfigList(String configlistid){

        ResultInfo result = new ResultInfo();

        int flag = deleteService.deleteConfigList(configlistid);

        if(flag>0){
            result.setCode(200);
        }else{
            result.setCode(500);
        }
        return result;
    }

    @RequestMapping("/deleteConfigList_query")
    @CrossOrigin
    @ResponseBody
    @ApiOperation(value = "删除查询列表下挂查询",httpMethod = "POST")
    public ResultInfo deleteConfigList_query(@RequestBody List<DeleteConfigList_query> list, HttpServletResponse response){

        ResultInfo result = new ResultInfo();

        int flag = deleteService.deleteConfigList_query(list);

        System.out.println(list);
        if(flag>0){
            result.setCode(200);
        }else{
            result.setCode(500);
        }
        return result;
    }

    @RequestMapping("/deletequery")
    @CrossOrigin
    @ResponseBody
    @ApiOperation(value = "删除查询",httpMethod = "GET")
    public ResultInfo deletequery(String userqueryid){

        ResultInfo result = new ResultInfo();

        int flag = deleteService.deletequery(userqueryid);

        System.out.println(userqueryid);
        if(flag>0){
            result.setCode(200);
        }else{
            result.setCode(500);
        }
        return result;
    }
}
