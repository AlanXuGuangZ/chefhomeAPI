package com.example.chefhome.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by v-xuyongbiao@meizu.com on 2020/3/27 上午10:29.
 * 统一处理Http请求日志
 */
@Aspect
@Component
public class HttpAspect {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);
    //匹配controller包下所有字类的共有方法
    @Pointcut("execution( * com.example.chefhome.controller.ChefController.*(..))")
    public void httpLog() {

    }
    //请求前处理http请求
    @Before("httpLog()")
    public void httpBeforeLog(JoinPoint joinPoint) {
        //获取http请求
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        logger.info("url={}",request.getRequestURI());
        logger.info("method={}",request.getMethod());
        logger.info("ip={}",request.getRemoteAddr());
        logger.info("class_method={}",joinPoint.getSignature().getDeclaringType() + "." + joinPoint
        .getSignature().getName());
        logger.info("args={}",joinPoint.getArgs());
        logger.info("统一处理Http请求-before");
    }

    @After("httpLog()")
    public void httpAfterLog() {
        logger.info("统一处理http请求日志-After");

    }
    //返回数据
    @AfterReturning(returning = "object",pointcut = "httpLog()")
    public void httpAfterReturning(Object object) {
        logger.info("response={}",object.toString());
    }
}
