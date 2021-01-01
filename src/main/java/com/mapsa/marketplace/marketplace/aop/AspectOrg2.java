package com.mapsa.marketplace.marketplace.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Aspect
public class AspectOrg2 {

    @AfterReturning(pointcut = "execution(* com.mapsa.marketplace.controller*.get*(..))", returning = "result")
    public void getResult(JoinPoint joinPoint, Object result) {

        log.info("result is here!");
        System.out.println(result);

    }
}