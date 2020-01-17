package com.example.springboottest.mapper.smt;

import com.example.springboottest.dto.logInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface LogMapper {

    int writeLog(logInfo logInfo);
}
