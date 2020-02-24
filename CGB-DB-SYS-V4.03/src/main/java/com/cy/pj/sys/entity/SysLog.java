package com.cy.pj.sys.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
/**
 * 封装数据库的数据,封装客户端数据,实现层与层之间数据的传递
 * (1)一行记录映射为一个对象
 * (2)通过此对象封装用户行为
 * 在当前应用中,我们将此对象理解为一个pojo对象(简称Java对象)
 * pojo在实际项目中又有许多分类
 * 1)PO 持久化对象:特点与表中对象有一一映射关系
 * 2)VO 普通的值对象( 用户进行值中的封装和传递,可以不与表中字段有一一一映射关系)
 * 
 * 在Java中所有用于存储数据的对象建议实现Serializable接口,并手动添加一个序列化id
 * 转化成字节为序列化,从字节转化回来为反序列化,其作用是在改变数据的时候保证数据的唯一
 */
@Data
public class SysLog implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	//用户名
	private String username;
	//用户操作
	private String operation;
	//请求方法
	private String method;
	//请求参数
	private String params;
	//执行时长
	private Long time;
	//IP地址
	private String ip;
	//创建时间
	private Date createdTime;
	
}
