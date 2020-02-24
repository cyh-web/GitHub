package com.cy.pj.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cy.pj.common.vo.JsonResult;
import com.cy.pj.sys.entity.SysMenu;
import com.cy.pj.sys.service.SysMenuService;

/** 定义Controller类，并将此类对象使用Spring框架中的@Controller注解进行标识，
 *  表示此类对象要交给Spring管理。然后基于@RequestMapping注解为此类定义根路径映射。 
 */
@RestController // @ResponseBody + @RestController
@RequestMapping("/menu/")
public class SysMenuController {
	//注入业务层接口
	@Autowired
	private SysMenuService sysMenuService;

	//添加菜单查询处理方法
	@RequestMapping("doFindObjects")
	//@ResponseBody
	public JsonResult doFindObjects() {
		return new  JsonResult(sysMenuService.findObjects());
	}

	@RequestMapping("doDeleteObject")
	//@ResponseBody
	public JsonResult doDeleteObject(Integer id){
		sysMenuService.deleteObject(id);
		return new JsonResult("delete ok");
	}

	//基于客户端请求,访问业务层对象方法,获取菜单节点对象,并封装返回
	@RequestMapping("doFindZtreeMenuNodes")
	public JsonResult doFindZtreeMenuNodes(){
		return new JsonResult(
		sysMenuService.findZtreeMenuNodes());
	}

	@RequestMapping("doSaveObject")
	//@ResponseBody
	public JsonResult doSaveObject(SysMenu entity) {
		sysMenuService.saveObject(entity);
		return new JsonResult("save ok");
	}

	@RequestMapping("doUpdateObject")
	//@ResponseBody
	public JsonResult doUdateObject(SysMenu entity) {
		sysMenuService.updateObject(entity);
		return new JsonResult("update ok");
	}
}
