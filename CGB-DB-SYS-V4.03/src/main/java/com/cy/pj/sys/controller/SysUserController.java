package com.cy.pj.sys.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cy.pj.common.vo.JsonResult;
import com.cy.pj.sys.entity.SysUser;
import com.cy.pj.sys.service.SysUserService;

@RestController
@RequestMapping("/user/")
public class SysUserController {
	
	@Autowired
	private SysUserService sysUserService;

	@RequestMapping("doFindPageObjects")
	public JsonResult doFindPageObjects(
				 String username,Integer pageCurrent) {
			 return new JsonResult(sysUserService.findPageObjects(username, pageCurrent));
		 }

	/**
	 * 添加用于执行删除业务的方法
	 * @param id
	 * @param valid
	 * @return
	 */
	@RequestMapping("doValidById")
	public JsonResult doValidById(Integer id,Integer valid) {
		sysUserService.validById(id, valid, "admin");//"admin"用户将来是登录用户,现在是假数据
		return new JsonResult("update ok");
	}
	
	/**
	 * 借助此方法处理保存用户数据的请求和响应逻辑
	 * @param entity
	 * @param roleIds
	 * @return
	 */
	@RequestMapping("doSaveObject")
	public JsonResult doSaveObject(SysUser entity, Integer[] roleIds) {
		sysUserService.saveObject(entity, roleIds);
		return new JsonResult("save ok");
	}
	
	//定义基于用户id查询的相关方法
	@RequestMapping("doFindObjectById")
	public JsonResult doFindObjectById(Integer id) {
		Map<String,Object> map = sysUserService.findObjectById(id);
		return new JsonResult(map);
	}
	
	//定义更新角色的方法
	@RequestMapping("doUpdateObject")
	public JsonResult doUpdateObject(SysUser entity, Integer[] roleIds) {
		sysUserService.updateObject(entity, roleIds);
		return new JsonResult("update ok");
	}
	
	//添加用于是溴铵密码修改的控制层方法
	@RequestMapping("doUpdatePassword")
	public JsonResult doUpdatePassword(String pwd,String newPwd,String cfgPwd) {
		sysUserService.updatePassword(pwd, newPwd, cfgPwd);
		return new JsonResult("update ok");
	}
}
