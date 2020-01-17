package com.example.springboottest.controller;

import com.example.springboottest.enums.MessageEnum;
import com.example.springboottest.exception.UserException;
import com.example.springboottest.model.ResultInfo;
import com.example.springboottest.po.User;
import com.example.springboottest.util.MessageUtil;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;

@RestController
@RequestMapping("login")
@ApiIgnore
public class Logintest {

    @RequestMapping(value = "/user/list/{exception}")
    public ResultInfo test01(@PathVariable("exception") Boolean exception) throws Exception{
        if(exception){
            return null;
        }
        throw new UserException(MessageEnum.NAME_EXCEEDED_CHARRACTER_LIMIT);
        //return MessageUtil.success(1/0);
    }

}





















