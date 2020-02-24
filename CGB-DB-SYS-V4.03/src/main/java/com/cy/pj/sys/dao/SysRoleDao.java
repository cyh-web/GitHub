package com.cy.pj.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
//import org.apache.ibatis.annotations.Select;

import com.cy.pj.common.vo.CheckBox;
import com.cy.pj.sys.entity.SysRole;
import com.cy.pj.sys.vo.SysRoleMenuVo;
/**
 * 定义角色数据层接口对象，通过将此对象保证给业务层以提供角色数据操作。
 */
@Mapper
public interface SysRoleDao {
	
	/**
	 * 添加数据的更新方法
	 * @param entity
	 * @return
	 */
	int updateObject(SysRole entity);
	
	/**
	 * 定义数据持久化方法
	 * @param id
	 * @return
	 */
	SysRoleMenuVo findObjectById(Integer id);
	
	/**
	 * 基于id删除角色菜单关系数据
	 * @param entity
	 * @return
	 */
	int insertObject(SysRole entity);
	
	/**
	 * 添加基于菜单id删除角色记录的方法
	 */
	int deleteObject(Integer id);

	/**
	 * 基于条件查询总记录数
	 * @param name 查询条件
	 * @return 总记录数(基于这个结果可以计算总页数)
	 * 说明：假如如下方法没有使用注解修饰，在基于名字进行查询
	 * 时候会出现There is no getter for property named
	 * 'username' in 'class java.lang.String'
	 */
	int getRowCount(@Param("name") String name);

	
	/**
	 * 基于条件分页查询角色信息
	 * @param name  查询条件
	 * @param startIndex 当前页的起始位置
	 * @param pageSize 当前页的页面大小
	 * @return 当前页的角色记录信息
	 * 数据库中每条角色信息封装到一个SysLog对象中
	 */
	List<SysRole> findPageObjects(
			      @Param("name")String  name,
			      @Param("startIndex")Integer startIndex,
			      @Param("pageSize")Integer pageSize);

	
	//在SysRole添加查询角色id，name的相关方法
	//@Select("select id,name from sys_roles")
	 List<CheckBox> findObjects();
}
