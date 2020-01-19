package com.example.springboottest.aop;


import com.example.springboottest.dto.logInfo;
import com.example.springboottest.service.LogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.core.ParameterNameDiscoverer;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
public class WebLogAspect {

    private static final Logger LOG = LoggerFactory.getLogger(WebLogAspect.class);

    @Autowired
    LogService logService;

    logInfo logInfo = new logInfo();

    @Pointcut("execution(public * com.example.springboottest.controller.QueryController.*(..))")//两个..代表所有子目录，最后括号里的两个..代表所有参数
    public void logPointCut(){

    }

    @Before("logPointCut()")
    public void doBefore(JoinPoint joinPoint) throws  Throwable{
        //接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        HttpServletRequest request = attributes.getRequest();
        //记录下请求内容
//        LOG.info("请求地址:" + request.getRequestURL().toString());
//        LOG.info("HTTP METHOD:" + request.getMethod());
//        LOG.info("IP:" + request.getRemoteAddr());
//        LOG.info("主机:" + request.getRemoteHost());
//        LOG.info("参数："+ Arrays.toString(joinPoint.getArgs()));

        logInfo.setIp(request.getRemoteAddr());
        logInfo.setParams(Arrays.toString(joinPoint.getArgs()));
        logInfo.setNotes("请求地址:" + request.getRequestURL().toString());

    }

    @AfterReturning(returning = "ret",pointcut = "logPointCut()")
    public void doAfterReturning(Object ret) throws Throwable{
        //处理完请求，返回内容
//        LOG.info("返回值："+ret);
    }

    @Around("logPointCut()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable{
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long startTime = System.currentTimeMillis();
        Object ob = pjp.proceed();
//        LOG.info("耗时："+(System.currentTimeMillis()-startTime));
        logInfo.setRequesttime(df.format(new Date()));
        logInfo.setRequestproject("BI Report");
        logInfo.setUsername("BI Report");
        logInfo.setTimeconsume(String.valueOf((System.currentTimeMillis()-startTime)));

        logService.writeLog(logInfo);
        return ob;
    }
}
















