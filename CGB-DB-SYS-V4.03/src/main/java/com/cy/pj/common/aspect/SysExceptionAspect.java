package com.cy.pj.common.aspect;

import org.aspectj.lang.reflect.MethodSignature;  //导入反射包
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * 切面的异常监控类,对目标方法进行异常监控,并以日志形式输出异常信息
 */
@Component  //Spring框架注解,用于把该类交给Spring管理
@Aspect  //切面注解, 用于实现切面对应功能
@Slf4j  //日志注解,用来实现打印实例方法
public class SysExceptionAspect {

	//新建引用的快捷方式(new对象中):alt+shift+l:
	
	@AfterThrowing(pointcut="bean(*ServiceImpl)",throwing = "e")
	public void doHandleException(JoinPoint jp,Exception e) {
		MethodSignature ms = (MethodSignature)jp.getSignature();
		log.error("{} expection msg is {}",ms.getName(),e.getMessage());
	}
}
