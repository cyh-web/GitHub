package com.cy.pj.common.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 定义切面对象
 */

@Component  //Spring框架的管理注解
@Aspect  //切面注解
public class SysCacheAspect {
	
	@Pointcut("@annotation(com.cy.pj.common.annotation.RequiredCache)") //锁定连接点,最终确定某一个目标方法
	public void doCache() {} //用于定义切入点的桥梁
	
	@Around("doCache") //通知,用于锁定切入点
	public Object around(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("Get data from cache");
		Object obj = jp.proceed(); // 用于执行的规则,先本类,再切面,再目标方法
		System.out.println("Put data to cache");
		return obj;
	}
}
