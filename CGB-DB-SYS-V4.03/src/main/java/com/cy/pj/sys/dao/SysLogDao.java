package com.cy.pj.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
//import org.apache.ibatis.annotations.Select;

import com.cy.pj.sys.entity.SysLog;

@Mapper
public interface SysLogDao {
	
	int deleteObjects(@Param("ids") Integer... ids);

	/**
	 * @Param 的作用是对于方法参数多于一个时注解标识,然后通过Mapper文件,通过#{}进行获取,
	 * 			或者进行动态SQL时,也是用此注解进行标识
	 * 基于条件查询总记录数
	 * @param username 查询条件
	 * @return 总记录数
	 * 使用注解进行修饰
	 */
	//把查询天条件写到数据层
	//@Select("select count(*) from sys_logs where username=#{username}")
	int getRowCount(@Param("username")String username);
	
	/**
	 * 基于条件分页查询日志信息
	 * @param username 查询条件	
	 * @param startIndex 当前页的起始位置
	 * @param pageSize 当前页面的大小
	 * @return 当前页的日志记录信息
	 * 数据库中每条日志记录信息封装到一个SysLog对象中
	 * limit start,count
	 */
	List<SysLog> findPageObjects(@Param("username")String username,
			@Param("startIndex")Integer startIndex,
			@Param("pageSize")Integer pageSize);
}
