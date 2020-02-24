package com.cy.pj.sys.service;

import java.util.List;

import com.cy.pj.common.vo.CheckBox;
import com.cy.pj.common.vo.PageObject;
import com.cy.pj.sys.entity.SysRole;
import com.cy.pj.sys.vo.SysRoleMenuVo;

public interface SysRoleService {
	
	//用于查询角色id,name相关信息的业务方法
	List<CheckBox> findObjects();
	
	/**
	 * 添加用于更新角色对象的方法
	 * @param entity
	 * @param menuIds
	 * @return
	 */
	int updateObject(SysRole entity,Integer[] menuIds);
	
	/**
	 * 添加基于id查询对应角色及相关信息的方法
	 * @param id
	 * @return
	 */
	SysRoleMenuVo findObjectById(Integer id) ;

	/**
	 * 添加用于保存角色对象的方法
	 * @param entity
	 * @param menuIds
	 * @return
	 */
	int saveObject(SysRole entity,Integer[] menuIds);
	
	/**
	 * 添加基于id进行角色删除的方法
	 */
	int deleteObject(Integer id);

	 PageObject<SysRole> findPageObjects(
			 String name,Integer pageCurrent);

}
