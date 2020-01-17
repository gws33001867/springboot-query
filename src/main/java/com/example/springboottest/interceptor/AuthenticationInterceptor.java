package com.example.springboottest.interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.example.springboottest.annotation.PassToken;
import com.example.springboottest.annotation.UserLoginToken;
import com.example.springboottest.util.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * token拦截器
 */
@Component
public class AuthenticationInterceptor implements HandlerInterceptor {

   // private String V_SECRET="mflexisveryhardmode";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String token = request.getHeader("mes-login-token");

        if(StringUtils.isEmpty(token)){
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED,"未登录");
            return false;
        }
        String [] arr = token.split("\\s+");
        System.out.println("token:"+arr[1]);
        if(StringUtils.isEmpty(token)){
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED,"未登录");
            return false;
        }
        //System.out.println();
        //如果不是映射到方法直接通过
//        if(!(handler instanceof HandlerMethod)){
//            return true;
//        }
    if(request.getMethod().equals("OPTIONS")){
        response.setStatus(HttpServletResponse.SC_OK);
        return false;
    }
        response.setCharacterEncoding("utf-8");

        if(token !=null){
            boolean result = TokenUtils.verify(arr[1]);

            if(result){
                System.out.println("通过拦截器");
                return true;
            }
        }

        System.out.println("认证失败");
        response.sendError(HttpServletResponse.SC_FORBIDDEN,"token验证失效，请重新登录");
        return false;

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
























