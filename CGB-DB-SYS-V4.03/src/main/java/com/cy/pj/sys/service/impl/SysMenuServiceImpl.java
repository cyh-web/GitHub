package com.cy.pj.sys.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.cy.pj.common.exception.ServiceException;
import com.cy.pj.sys.dao.SysMenuDao;
import com.cy.pj.sys.dao.SysRoleMenuDao;
import com.cy.pj.sys.entity.SysMenu;
import com.cy.pj.sys.service.SysMenuService;

import ch.qos.logback.core.pattern.parser.Node;
/**
 * 定义菜单业务接口实现类，并添加菜单业务数据对应的查询操作实现,
 */
@Service
public class SysMenuServiceImpl implements SysMenuService {

	@Autowired
	private SysMenuDao sysMenuDao;
	
	@Autowired
	private SysRoleMenuDao sysRoleMenuDao;

	@Override
	public List<Map<String, Object>> findObjects() {
		List<Map<String,Object>> list=
				sysMenuDao.findObjects();
			if(list==null||list.size()==0)
			throw new ServiceException("没有对应的菜单信息");
			return list;
	}

	@Override
	public int deleteObject(Integer id) {
		//1.验证数据的合法性
		if(id==null||id<=0)
		throw new IllegalArgumentException("请先选择");
		//2.基于id进行子元素查询
		int childCount=sysMenuDao.getChildCount(id);
		if(childCount>0)
		throw new ServiceException("请先删除子菜单");
		//3.删除角色,菜单关系数据
		sysRoleMenuDao.deleteObjectsByMenuId(id);
		//4.删除菜单元素
		int rows=sysMenuDao.deleteObject(id);
		if(rows==0)
		throw new ServiceException("此菜单可能已经不存在");
		//5.返回结果
		return rows;
	}

	/**
	 * 查询菜单信息方法的实现
	 */
	@Override
	public List<Node> findZtreeMenuNodes() {
		return sysMenuDao.findZtreeMenuNodes();
	}

	
	/**
	 * 实现菜单保存操作
	 */
	@Override
	public int saveObject(SysMenu entity) {
		//1合法验证(参数校验)
		if(entity==null)
			throw new ServiceException("保存对象不能为空");
//		    throw new IllegalArgumentException("保存对象不能为空");//两者都可
		if(StringUtils.isEmpty(entity.getName()))//验证null和空串
			throw new ServiceException("菜单名不能为空");
//	    throw new IllegalArgumentException("菜单名不能为空");//两者都可
		if(StringUtils.isEmpty(entity.getPermission()))
			throw new IllegalArgumentException("授权标识不能为空");//两者都可
		//2保存数据(保存菜单对象)
		int rows;
		try {
			rows = sysMenuDao.insertObject(entity);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("保存失败");
		}
		
		//3返回数据
		return rows;
	}

	@Override
	public int updateObject(SysMenu entity) {
		//1合法检验
		if(entity==null)
			throw new ServiceException("保存对象不能为空");
		if(StringUtils.isEmpty(entity.getName()))
			throw new ServiceException("菜单名不能为空");
		//2更新数据
		int rows = sysMenuDao.updateObject(entity);
		if(rows==0)
			throw new ServiceException("记录可能已经不存在");
		//3返回数据
		return rows;
	}

}
