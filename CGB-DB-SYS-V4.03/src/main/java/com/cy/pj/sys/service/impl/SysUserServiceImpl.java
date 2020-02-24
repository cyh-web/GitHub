package com.cy.pj.sys.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.aspectj.lang.annotation.Aspect;
//import org.mybatis.logging.LoggerFactory;
//import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import com.cy.pj.common.exception.ServiceException;
import com.cy.pj.common.vo.PageObject;
import com.cy.pj.sys.dao.SysUserDao;
import com.cy.pj.sys.dao.SysUserRoleDao;
import com.cy.pj.sys.entity.SysUser;
import com.cy.pj.sys.service.SysUserService;
import com.cy.pj.sys.vo.SysUserDeptVo;

import lombok.extern.slf4j.Slf4j;


@Aspect
@Slf4j //log的引入包
@Service
public class SysUserServiceImpl implements SysUserService {

	@Autowired
	private SysUserDao sysUserDao;

	@Autowired
	private SysUserRoleDao sysUserRoleDao;
	
	//private static final Logger log = (Logger) LoggerFactory.getLogger(SysUserServiceImpl.class);

	@Override
	public PageObject<SysUserDeptVo> findPageObjects(String username, Integer pageCurrent) {
		//1.对参数进行校验
		if(pageCurrent==null||pageCurrent<1)
			throw new IllegalArgumentException("当前页码值无效");
		//2.查询总记录数并进行校验
		int rowCount=sysUserDao.getRowCount(username);
		if(rowCount==0)
			throw new ServiceException("没有找到对应记录");
		//3.查询当前页记录
		int pageSize=2;
		int startIndex=(pageCurrent-1)*pageSize;
		List<SysUserDeptVo> records=
				sysUserDao.findPageObjects(username,
						startIndex, pageSize);
		//4.对查询结果进行封装并返回
		return new PageObject<>(pageCurrent, pageSize, rowCount, records);
	}

	/**
	 * 添加禁用，启用业务
	 */
	@Override
	public int validById(Integer id, Integer valid, String modifiedUser) {
		//1合法性检验
		if(id==null||id<=0) 
			throw new ServiceException("参数不合法,id="+id);
		if(valid!=1&&valid!=0) 
			throw new ServiceException("参数不合法,valid="+valid);
		if(StringUtils.isEmpty(modifiedUser)) 
			throw new ServiceException("修改用户不能为空");
		//2执行禁用或启用操作
		int rows = sysUserDao.validById(id, valid, modifiedUser);
		//3判定结果,并返回
		if(rows==0)
			throw new ServiceException("此纪录可能已经不存在");
		return rows;
	}

	@Override
	public int saveObject(SysUser entity, Integer[] roleIds) {
		long start=System.currentTimeMillis();
		log.info("start:"+start);
		//开启事务
		
		//1.参数校验
		if(entity==null)
			throw new ServiceException("保存对象不能为空");
		if(StringUtils.isEmpty(entity.getUsername()))
			throw new ServiceException("用户名不能为空");
		if(StringUtils.isEmpty(entity.getPassword()))
			throw new ServiceException("密码不能为空");
		if(roleIds==null || roleIds.length==0)
			throw new ServiceException("至少要为用户分配角色");
		//2.保存用户自身信息
		//2.1对密码进行加密
		String source=entity.getPassword();
		String salt=UUID.randomUUID().toString();//产生一个随机的字符串作为盐值
		//DigestUtils.md5DigestAsHex((entity.getPassword()+salt).)
		SimpleHash sh=new SimpleHash(//Shiro框架
				"MD5",//algorithmName 算法
				source,//原密码
				salt, //盐值
				1);//hashIterations表示加密次数
		entity.setSalt(salt);
		entity.setPassword(sh.toHex());
		//写到数据库
		int rows=sysUserDao.insertObject(entity);
		//3.保存用户角色关系数据
		sysUserRoleDao.insertObjects(entity.getId(), roleIds);
		long end=System.currentTimeMillis();
		log.info("end:"+end);
		log.info("total time :"+(end-start));
		//关闭事务
		
		//4.返回结果
		return rows;

	}

	/**
	 *	查询用户相关信息的方法
	 */
	@Override
	public Map<String, Object> findObjectById(Integer userId) {
		//1合法性验证
		if(userId == null || userId <= 0)
			throw new ServiceException("参数数据不合法,userId="+userId);
		//2业务查询
		SysUserDeptVo user = sysUserDao.findObjectById(userId);
		if(user == null)
			throw new ServiceException("此用户已经不存在");
		List<Integer> roleIds = sysUserRoleDao.findRoleIdsByUserId(userId);
		//3数据封装
		Map<String,Object> map = new HashMap<>();
		map.put("user", user);
		map.put("roleIds", roleIds);
		return map;
	}

	//实现用于更新角色对象的方法
	@Override
	public int updateObject(SysUser entity, Integer[] roleIds) {
		//1参数有效性检验
		if(entity == null)
			throw new IllegalArgumentException("保存对象不能为空");
		if(StringUtils.isEmpty(entity.getUsername()))
			throw new IllegalArgumentException("用户名不能为空");
		if(roleIds == null || roleIds.length==0)
			throw new IllegalArgumentException("必须为其指定角色");
		//2具体实现步骤
		//2.1更新用户自身信息
		int rows = sysUserDao.updateObject(entity);
		//2.2保存用户与角色关系数据
		sysUserRoleDao.deleteObjectsByUserId(entity.getId());
		sysUserRoleDao.insertObjects(entity.getId(), roleIds);
		//3返回结果
		return rows;
	}

	@Override
	public int updatePassword(String password, String newPassword, String cfgPassword) {
		//1参数有效性检验
		//1.1判断新密码与密码确认是否相同
		if(StringUtils.isEmpty(newPassword))
			throw new IllegalArgumentException("新密码不能为空");
		if(StringUtils.isEmpty(cfgPassword))
			throw new IllegalArgumentException("确认密码不能为空");
		if(!newPassword.equals(cfgPassword))
			throw new IllegalArgumentException("两次输入的密码不相等");
		//2具体实现步骤
		//2.1判断原密码是否正确
		if(StringUtils.isEmpty(password))
			throw new IllegalArgumentException("原密码不能为空");
		//2.2获取登录用户
		SysUser user = (SysUser)SecurityUtils.getSubject().getPrincipal();
		SimpleHash sh = new SimpleHash("MD5",password,user.getSalt(),1);
		if(!user.getPassword().equals(sh.toHex()))
			throw new IllegalArgumentException("原密码不正确");
		//2.3对新密码进行加密
		String salt = UUID.randomUUID().toString();
		sh = new SimpleHash(
				"MD5",   		  //算法名
				newPassword,     //源
				salt,            //盐
				1); 			  //哈希迭代
		//3返回结果(将新密码加密以后的结果更新到数据库)
		int rows = sysUserDao.updatePassword(sh.toHex(), salt, user.getId());
		if(rows == 0)
			throw new ServiceException("修改失败");
		return rows;
	}

}
