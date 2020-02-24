package com.cy.pj.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cy.pj.common.vo.JsonResult;
import com.cy.pj.common.vo.PageObject;
import com.cy.pj.sys.entity.SysLog;
import com.cy.pj.sys.service.SysLogService;

/**
 * 定义Controller类,将此类对象使用Spring框架中的@Controller注解进行标识,标示此类对现象要交给spring管理
 * 然后基于@RequestMapping注解为此类定义根路径映射
 *
 */
@Controller
@RequestMapping("/log/")
public class SysLogController {
	@Autowired
	private SysLogService sysLogService;
	
	@RequestMapping("doDeleteObjects")
	@ResponseBody
	public JsonResult doDeleteObjects(Integer...ids) {
		sysLogService.deleteObjects(ids);
		return new JsonResult("delete ok");
	}
	
	
	/**
	 * 分页请求处理方法
	 * @param username
	 * @param pageCurrent
	 * @return
	 */
	@RequestMapping("doFindPageObjects")
	@ResponseBody
	public JsonResult doFindPageObjects(String username,Integer pageCurrent) {
		PageObject<SysLog> pageObject = sysLogService.findPageObjects(username, pageCurrent);
		System.out.println("pageObject="+pageObject);
		return new JsonResult(pageObject);
	}
}
