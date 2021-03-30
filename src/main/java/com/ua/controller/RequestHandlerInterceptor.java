package com.ua.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class RequestHandlerInterceptor implements HandlerInterceptor {

    private final Logger LOG = LoggerFactory.getLogger(RequestHandlerInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        LOG.info("In preHandle method of requestHandlerInterceptor");
        response.sendRedirect("/");
        return false;
    }
}
