package com.example.springboottest.controller;

import com.example.springboottest.base.BaseController;
import com.example.springboottest.dto.AddQueryBean;
import com.example.springboottest.model.ResultInfo;
import com.example.springboottest.service.InsertService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/insert")
@Api(value = "添加查询，列表的相关接口",tags = "新增查询Rest API")
public class InsertController extends BaseController {

    @Autowired
    private InsertService insertService;

    @PostMapping("/insertQuery")
    @CrossOrigin
    @ResponseBody
    @ApiOperation(value = "添加查询",httpMethod = "POST")
    public ResultInfo insertQuery(@RequestBody AddQueryBean addQueryBean){




        Map<String,Object> param = new HashMap<>();
//        String s = addQueryBean.getSelectName().toString();

        String msg = null;
        int flag=0;
        try{
            flag = insertService.insertQuery(addQueryBean);
        }catch (Exception e){
            flag=-1;
            msg = "添加失败";
        }

        System.out.println(flag);
        ResultInfo resultInfo = new ResultInfo();
        if (flag>0){
            resultInfo.setCode(200);
        }else{
            resultInfo.setCode(500);
            resultInfo.setMsg(msg);
        }
        return resultInfo;
    }

    @RequestMapping("/insertConfigList")
    @CrossOrigin
    @ResponseBody
    @ApiOperation(value = "添加查询列表",httpMethod = "GET")
    public ResultInfo insertConfigList(String label,String envflag, HttpServletResponse response){


        //response.setHeader("Access-Control-Allow-Origin","*");
        // response.setHeader("Access-Control-Request-Method","GET,POST");

        Map<String,Object> param = new HashMap<>();
//        String s = addQueryBean.getSelectName().toString();

        int flag = insertService.insertConfigList(label,envflag);
        System.out.println(flag);
        ResultInfo resultInfo = new ResultInfo();
        if (flag>0){
            resultInfo.setCode(200);
        }else{
            resultInfo.setCode(500);
        }
        return resultInfo;
    }

    @RequestMapping("/insertConfigList_query")
    @CrossOrigin
    @ResponseBody
    @ApiOperation(value = "查询列表下挂查询",httpMethod = "GET")
    public ResultInfo insertConfigList_query(String configlistid, String userqueryid, HttpServletResponse response){


        response.setHeader("Access-Control-Allow-Origin","*");
        // response.setHeader("Access-Control-Request-Method","GET,POST");

        Map<String,Object> param = new HashMap<>();
//        String s = addQueryBean.getSelectName().toString();

        int flag = insertService.insertConfigList_query(configlistid, userqueryid);
      //  System.out.println(flag);
        ResultInfo resultInfo = new ResultInfo();
        if (flag>0){
            resultInfo.setCode(200);
        }else{
            resultInfo.setCode(500);
        }
        return resultInfo;
    }

}
