package com.cy.pj.sys.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
/**
 * 构建实体对象（POJO）封装从数据库查询到的记录，一行记录映射为内存中一个的这样的对象
 */
@Data
public class SysRole implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8094272493294939469L;

	private Integer id;
	private String name;
	private String note;
	private Date createdTime;
	private Date modifiedTime;
	private String createdUser;
	private String modifiedUser;

}
