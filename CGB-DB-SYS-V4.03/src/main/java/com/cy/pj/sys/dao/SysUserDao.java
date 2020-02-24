package com.cy.pj.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cy.pj.sys.entity.SysUser;
import com.cy.pj.sys.vo.SysUserDeptVo;

@Mapper
public interface SysUserDao {

	/**
	 * 添加getRowCount方法用于按条件统计记录总数
	 */
	int getRowCount(@Param("username") String username);
	
	/**
	 * 基于条件参训当前用户信息以及用户对应的部门信息
	 * 1)方案一:业务层 向数据层发起多次查询请求,然后进行数据封装
	 * 2)方案二:数据层通过嵌套查询(先查询一张表,可以基于结果再次查询其他表)
	 * 3)方案三:通过多表查询,查询这些信息
	 * @param username
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	List<SysUserDeptVo> findPageObjects(
		      @Param("username")String  username,
		      @Param("startIndex")Integer startIndex,
		      @Param("pageSize")Integer pageSize);

	/**
	 * 添加修改用户状态信息的方法
	 * @param id
	 * @param valid
	 * @param modifiedUser
	 * @return
	 */
	int validById(
			@Param("id")Integer id,
			@Param("valid")Integer valid,
			@Param("modifiedUser")String modifiedUser);

	//负责将用户提交的用户基本信息持久化到数据库
	int insertObject(SysUser entity);

	//定义基于用户id查询相关信息的方法
	SysUserDeptVo findObjectById(Integer id);
	
	//更新用户基本数据:自身信息,用户和角色的关系数据
	int updateObject(SysUser entity);
	
	//添加修改用户密码信息的方法
	int updatePassword(String password,String salt,Integer id);
	
	//添加根据用户名获取用户对象的方法
	SysUser findUserByUserName(String username);
	
}
