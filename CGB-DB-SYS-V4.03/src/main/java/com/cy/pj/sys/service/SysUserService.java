package com.cy.pj.sys.service;

import java.util.Map;

import com.cy.pj.common.vo.PageObject;
import com.cy.pj.sys.entity.SysUser;
import com.cy.pj.sys.vo.SysUserDeptVo;

/**
 * 定义用户业务接口及方法，暴露外界对用户业务数据的访问
 * @author Administrator
 *
 */
public interface SysUserService {

	/**
	 * 分页查询操作
	 * 基于条件查询用户以及用户对应的部门信息
	 * 一行记录为一个对象
	 * @param username
	 * @param pageCurrent
	 * @return
	 */
	PageObject<SysUserDeptVo> findPageObjects(
			String username,Integer pageCurrent);
	
	/**
	 * 添加修改用户装填的方法
	 * @param id
	 * @param valid
	 * @param modifiedUser
	 * @return
	 */
	int validById(Integer id,Integer valid,String modifiedUser);
	
	/**
	 * 添加用于保存用户对象的方法
	 * @param entity
	 * @param roleIds
	 * @return
	 */
	int saveObject(SysUser entity,Integer[] roleIds);
	
	//添加基于id查询用户及相关信息的方法
	Map<String,Object> findObjectById(Integer userId);
	
	//添加用于更新角色对象的方法
	int updateObject(SysUser entity,Integer[] roleIds);
	
	//添加用于实现密码修改业务的方法
	int updatePassword(String password, String newPassword, String cfgPassword);
	
	
}
