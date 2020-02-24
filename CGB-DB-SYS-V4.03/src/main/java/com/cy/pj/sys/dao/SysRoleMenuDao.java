package com.cy.pj.sys.dao;

import java.util.List;

//import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SysRoleMenuDao {
	
	List<Integer> findMenuIdsByRoleId(Integer roleId);
	
	/**
	 * 保存角色和菜单的关系数据
	 * @param roleId
	 * @param menuIds
	 * @return
	 */
	int insertObjects(@Param("roleId")Integer roleId,
			@Param("menuIds")Integer[] menuIds);

	/**
	 * 定义基于角色id删除关系数据的方法
	 */
	int deleteObjectsByRoleId(Integer roleId);
	
//	@Delete("delete from sys_role_menus where menu_id = #{menuId}")
	int deleteObjectsByMenuId(Integer menuId);
}
