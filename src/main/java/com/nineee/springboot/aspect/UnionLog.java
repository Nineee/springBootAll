package com.nineee.springboot.aspect;

import com.alibaba.fastjson.JSON;
import com.nineee.springboot.response.UnionExceptionHandler;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: ljj
 * @Date: 2019/6/18 14:48
 * @Desc
 */

@Aspect
@Component
public class UnionLog {
    private static final Logger logger = LoggerFactory.getLogger(UnionExceptionHandler.class);
    //配置切点
    @Pointcut("execution(public * com.nineee.springboot.web.*.*(..))")
    public void log() {
    }

    //前置通知
    @Before("log()")
    public void beforeExcution(JoinPoint joinPoint) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        logger.info("URL : " + request.getRequestURL().toString());
        logger.info("HTTP_METHOD : " + request.getMethod());
        logger.info("PARAMETER : " + JSON.toJSONString(request.getParameterMap()));
        logger.info("IP : " + request.getRemoteAddr());
        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
    }

    @AfterReturning(returning = "res", pointcut = "log()")  //后置返回
    public void doAfterReturning(Object res) throws Throwable {
        // 处理完请求，返回内容
        logger.info("RESPONSE : " + JSON.toJSONString(res));
    }

}
