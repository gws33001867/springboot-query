package com.example.springboottest.exception;

import com.example.springboottest.enums.MessageEnum;

public class UserException extends RuntimeException {
    private Integer code;

    public UserException(MessageEnum messageEnum){
        super(messageEnum.getMessage());
        this.code = messageEnum.getCode();
    }

    public Integer getCode(){
        return code;
    }

    public void setCode(Integer code){
        this.code = code;
    }
}
