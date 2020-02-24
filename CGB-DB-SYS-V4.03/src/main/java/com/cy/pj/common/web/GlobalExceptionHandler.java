package com.cy.pj.common.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cy.pj.common.vo.JsonResult;

/**
 * 注解描述的类为Spring MVC提供一个
 * 全局异常处理类
 * 控制层出出现异常以后,可以由此类进行处理
 * 
 * */
@ControllerAdvice
public class GlobalExceptionHandler {
	//JDK中的自带的日志API
	//@ExceptionHandler 描述的方法为spring mvc中的异常处理方法
	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	public JsonResult doHandleRuntimeException(RuntimeException e) {
		e.printStackTrace();//也可以写日志
		return new JsonResult(e);//封装异常信息
	}
}
