package com.cy.pj.common.vo;

import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 定义控制层对象(vo),目的是基于此对象封装控制层影响结果(此对象中主要是为业务层执行结果添加状态信息)
 * Spring MVC 框架在响应时可以调用相关API,将其对象转换为JSON格式字符串
 */
@NoArgsConstructor
@Data
public class JsonResult implements Serializable {
	private static final long serialVersionUID = 2080943344863436345L;
	/**状态码*/
	private int state = 1;//1表示SUCCESS,0表示ERROR
	/**状态信息*/
	private String message = "ok";
	/**正确数据*/
	private Object data;//此属性一般用于封装业务层返回给控制层的数据
	public JsonResult(String message) {
		this.message = message;
	}
	/**一般查询时调用，封装查询结果*/
	public JsonResult(Object data) {
		this.data = data;
	}
	/**出现异常时时调用*/
	public JsonResult(Throwable t) {
		this.state = 0;
		this.message = t.getMessage();
	}
	
}
