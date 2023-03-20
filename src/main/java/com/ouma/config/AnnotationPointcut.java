package com.ouma.config;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


//@EnableAspectJAutoProxy
@Aspect
public class AnnotationPointcut {

    @Before("execution(* com.ouma.service.BookServiceImpl.*(..))")
    public void before(){
        System.out.println("---------方法执行前---------");
    }
    @After("execution(* com.ouma.service.BookServiceImpl.*(..))")
    public void after(){
        System.out.println("---------方法执行后---------");
    }

}
