package com.cy.pj.common.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service  //要交给Spring管理,进而用来实现业务层面的功能的扩充
@Aspect   //定义的切面注解,用于底层实现业务层的连接接口或者实现类的对象
public class SysTimeAspect {

	@Pointcut("bean(sysUserServiceImpl)")  //切入点,用于锁定连接点,以致锁定目标对象
	public void doTime() {}
	
	@Before("doTime()")  //切入点,用于锁定连接点
	public void doBefore(JoinPoint jp) {
		System.out.println("time doBefore()");
	}
	
	@After("doTime()")  //切入点,用于锁定连接
	public void doAfter() {
		System.out.println("time doAfter()");
	}

	/**
	 * 一般对于包含After,AfterReturning和AfterThrowing等的注解中,
	 * 先执行After注解再执行After之后的注解
	 */	
	
	@AfterReturning("doTime()")  //切入点,用于锁定连接点
	public void doAfterReturning() {
		System.out.println("time doAfterReturn");
	}
	
	@AfterThrowing("doTime()")  //切入点,用于锁定连接点
	public void doAfterThrowing() {
		System.out.println("time doAfterThrowing");
	}
	
	@Around("doTime()")  //通知,用于锁定切入点
	public Object doAround(ProceedingJoinPoint jp) throws Throwable{
		System.out.println("doAround.before");
		Object obj = jp.proceed();  //定义调用目标方法执行步骤的标识,先本切面中调用,在下一个切面,之后再目标方法
		System.out.println("doAround.after");
		return obj;
	}
	
}
