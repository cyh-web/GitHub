package com.cy.pj.common.vo;

import java.io.Serializable;
import lombok.Data;

/**
 * 此类对象封装角色id，角色名信息
 */
@Data
public class CheckBox implements Serializable {

	private static final long serialVersionUID = 4726362356109662723L;

	private Integer id;
	private String name;
}
