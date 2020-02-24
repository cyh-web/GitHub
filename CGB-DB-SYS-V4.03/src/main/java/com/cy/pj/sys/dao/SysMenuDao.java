package com.cy.pj.sys.dao;

import java.util.List;
import java.util.Map;

//import org.apache.ibatis.annotations.Delete;
//import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
//import org.apache.ibatis.annotations.Select;
//import org.apache.ibatis.annotations.Update;

import com.cy.pj.sys.entity.SysMenu;

import ch.qos.logback.core.pattern.parser.Node;

/**
 * 基于此dao操作菜单表:sys_menus
 * @author Administrator
 *
 */
@Mapper
public interface SysMenuDao {
	
	//添加数据更新方法
	/**
	 * 更新菜单语句
	 * @param entity
	 * @return
	 */
//	@Update(" update sys_menus\r\n" + 
//			"         set\r\n" + 
//			"           name=#{name},\r\n" + 
//			"           type=#{type},\r\n" + 
//			"           sort=#{sort},\r\n" + 
//			"           url=#{url},\r\n" + 
//			"           parentId=#{parentId},\r\n" + 
//			"           permission=#{permission},\r\n" + 
//			"           modifiedUser=#{modifiedUser},\r\n" + 
//			"           modifiedTime=now()\r\n" + 
//			"        where id=#{id}\r\n" + 
//			"")
	int updateObject(SysMenu entity);
	
	//添加数据 
	/**
	 * 将菜单对象持久化数据库  内存对象写到数据据库中,为持久化过程
	 * @param entity
	 * @return
	 */
//	@Insert("insert into sys_menus\r\n" + 
//			"          (name,url,type,sort,note,parentId,permission,\r\n" + 
//			"createdTime,modifiedTime,createdUser,modifiedUser)\r\n" + 
//			"          values\r\n" + 
//			"          (#{name},#{url},#{type},#{sort},#{note},#{parentId},\r\n" + 
//			"#{permission},now(),now(),#{createdUser},#{modifiedUser})\r\n" + 
//			"")
	int insertObject(SysMenu entity);
	/**
	 * 添加，用于查询上级菜单相关信息
	 */
//	@Select("select id,name,parentId from sys_menus ")
	List<Node> findZtreeMenuNodes();
	
	/**
	 * 
	 * @param id
	 * @return
	 */
//	@Select("select count(*) from sys_menus where parentId = #{id}")
	int getChildCount(Integer id);
	
//	@Delete("delete from sys_menus where id = #{id}")
	int deleteObject(Integer id);
	
	/**
	 * 查询所有菜单,以及对应的上级菜单名称
	 * 难点: 如何获取上级菜单的名称
	 */
	//方法和返回值 
	List<Map<String,Object>> findObjects();
}
