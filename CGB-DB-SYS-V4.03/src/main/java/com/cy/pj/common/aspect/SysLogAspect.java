package com.cy.pj.common.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
/**
 * 通过@Aspect注解描述的类型,为AOP中的一种切面类型,在这种切面类型中同城要定义两部分内容
 * 切入点(PointCut):在什么位置进行功能增强
 * 通知(Advice):功能增强
 */
@Aspect
@Component
@Slf4j
public class SysLogAspect {
	/**
	 * @Pointcut: 用于定义切入点
	 * bean(sysUserServiceImpl):切入点表达式 
	 * sysUserServiceImpl 为 spring 容器中某个bean的名字
	 * 在当前应用中,sysUserServiceImpl 代表的bean对象中所有方法的集合为切入点(这个切入点中的任意一个方法执行时,都要进行功能的扩展)
	 */
	 @Pointcut("bean(sysUserServiceImpl)")
	 public void logPointCut() {}//方法实现不需要写任何内容

	 /**
	  * @Around 注解用于描述通知 (Advice),切面中的方法除了切入点都是通知,通知中要实现的扩展的功能
	  * 		该注解描述的通知为Advice中的一种环绕通知,环绕通知中可以手动调用目标方法,可以在目标方法之前和目标方法之后进行额外业务实现
	  * @param jp 连接点 @Around 描述的方法中,参数类型要求为ProceedingJoinPoint
	  * @return 目标业务方法的返回值,对于@Around 描述的方法,其返回值类型要求为Object
	  * @throws Throwable 
	  */
	 @Around("logPointCut()") //注解用于描述切面中方法,其中logPointCut()注解中的内容(bean(sysUserServiceImpl))为切入点表达式
	 //@Around("bean(sysUserServiceImpl)")
	 public Object around(ProceedingJoinPoint jp)
	 throws Throwable{
		 try {
		   //log.info("start:"+System.currentTimeMillis());
		   log.info("method start {}",System.currentTimeMillis());
		   Object result=jp.proceed();//调用本类i中其他通知,或下一个切面,或目标方法
		   //log.info("after:"+System.currentTimeMillis());
		   log.info("method end {}",System.currentTimeMillis());
		   return result;
		 }catch(Throwable e) {
		   //log.error(e.getMessage());
		   log.error("method.error {}", System.currentTimeMillis());
		   throw e;
		 }
	 }
}
