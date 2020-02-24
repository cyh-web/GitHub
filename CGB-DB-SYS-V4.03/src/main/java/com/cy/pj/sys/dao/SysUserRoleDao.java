package com.cy.pj.sys.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


/**
 * 定义基于角色id删除关系数据的方法
 */
@Mapper
public interface SysUserRoleDao {
	
	int deleteObjectsByRoleId(Integer roleId);

	//提交用户基本信息到数据库
	int insertObjects(
			@Param("userId")Integer userId,
			@Param("roleIds")Integer[] roleIds);
	
	//定义基于用户id查询角色id信息的方法
	List<Integer> findRoleIdsByUserId(Integer id);
	
	//删除信息:添加基于用户id删除关系数据的方法
	int deleteObjectsByUserId(Integer userId);

}
