package com.cy.pj.common.vo;

import java.io.Serializable;

import lombok.Data;

@Data
public class Node implements Serializable {

	/**
	 * 定义值对象封装查询到的上级菜单id，name，parentId信息
	 */
	private static final long serialVersionUID = 4828985081977733366L;

	private Integer id;
	private String name;
	private Integer parentId;
	
}
