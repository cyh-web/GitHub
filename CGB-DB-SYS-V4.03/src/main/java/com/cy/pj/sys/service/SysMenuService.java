package com.cy.pj.sys.service;

import java.util.List;
import java.util.Map;

import com.cy.pj.sys.entity.SysMenu;

import ch.qos.logback.core.pattern.parser.Node;


/**
 * 定义菜单业务接口及方法，暴露外界对菜单业务数据的访问
 */
public interface SysMenuService {
	
	 List<Map<String,Object>> findObjects();
	 
	 int deleteObject(Integer id);
	 
	 /**
	  * 添加查询菜单信息的方法
	  */
	 List<Node> findZtreeMenuNodes();
	 
	 /**
	  * 添加用于保存菜单对象的方法
	  */
	 int saveObject(SysMenu entity);
	 
	 /**
	  * 添加更新菜单对象的方法
	  */
	 int updateObject(SysMenu entity);
}
