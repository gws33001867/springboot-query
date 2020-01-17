package com.example.springboottest.base;

import com.example.springboottest.model.ResultInfo;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by xlf on 2018/12/18.
 */
public class BaseController {



    public ResultInfo success(Integer code, String msg, Object result){
        ResultInfo info = new ResultInfo();
        info.setCode(code);
        info.setMsg(msg);
        info.setResult(result);
        return info;
    }

    public ResultInfo success(String msg, Object result){
        ResultInfo info = new ResultInfo();
        info.setMsg(msg);
        info.setResult(result);
        return info;
    }

    public ResultInfo success(Integer code, String msg){
        ResultInfo info = new ResultInfo();
        info.setCode(code);
        info.setMsg(msg);
        return info;
    }

    public ResultInfo success(String msg){
        ResultInfo info = new ResultInfo();
        info.setMsg(msg);
        return info;
    }

    public ResultInfo success(Integer code){
        ResultInfo info = new ResultInfo();
        info.setCode(code);
        return info;
    }


    @ModelAttribute
    public void preHandle(HttpServletRequest request){
        request.setAttribute("ctx", request.getContextPath());
    }
}
