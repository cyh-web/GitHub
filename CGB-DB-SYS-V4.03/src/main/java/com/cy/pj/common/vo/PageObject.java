package com.cy.pj.common.vo;

import java.io.Serializable;
import java.util.List;

//import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * VO:基于此对象封装数据成返回的数据和用于计算的分页信息
 * @NoArgsConstructor 无参构造
 * @AllArgsConstructor 全参构造
 * @Data get/set/queals/hashCode/toString/canEqual方法
 * @param <T> 
 */
@NoArgsConstructor 
//@AllArgsConstructor
@Data
public class PageObject<T> implements Serializable {
	//类泛型
	private static final long serialVersionUID = 6780580291247550747L;//1536631092048817285L;
	/**当前页的页码值*/
	private Integer pageCurrent=1;
	/**页面大小*/
	private Integer pageSize = 3;
	/**总行数(通过查询获得)*/
	private Integer rowCount = 0;
	/**总页数(通过计算获得)*/
	private Integer pageCount = 0;
	/**当前页记录*/
	private List<T> records;
	public PageObject(Integer pageCurrent, Integer pageSize, Integer rowCount,
			List<T> records) {
		super();
		this.pageCurrent = pageCurrent;
		this.pageSize = pageSize;
		this.rowCount = rowCount;
		this.records = records;
		//this.pageCurrent = rowCount/
		this.pageCount = ( rowCount-1 )/ pageSize + 1;
	}
	
	
}
