package com.example.springboottest.util;

import com.example.springboottest.model.ResultInfo;

public class MessageUtil {

    /**
     * 成功方法
     * @param object
     * @return
     */
    public static ResultInfo success(Object object){
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setCode(200);
        resultInfo.setMsg("SUCCESS");
        if (object != null){
            resultInfo.setResult(object);
        }
        return resultInfo;
    }

    /**
     * 失败方法
     * @param code
     * @param message
     * @return
     */
    public static ResultInfo error(Integer code,String message){
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setCode(code);
        resultInfo.setMsg(message);
        return resultInfo;
    }
}
