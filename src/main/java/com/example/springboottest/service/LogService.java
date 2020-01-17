package com.example.springboottest.service;

import com.example.springboottest.dto.logInfo;
import com.example.springboottest.mapper.smt.LogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogService {

    @Autowired
    LogMapper logMapper;

    public int writeLog(logInfo logInfo){
        return logMapper.writeLog(logInfo);
    }
}
