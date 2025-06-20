package com.wl.springsecurity_demo.confg.handler;

import com.alibaba.fastjson.JSON;
import com.wl.springsecurity_demo.utils.ResultCode;
import com.wl.springsecurity_demo.utils.ResultData;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author: lcj
 * @Date: 2020/10/27 10:10
 * @Description: 认证失败处理类
 * @Version: 0.0.1
 */
@Component
public class SecurityAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.write(JSON.toJSONString(ResultData.error(ResultCode.ERROR, "登录失败!")));
    }
}
