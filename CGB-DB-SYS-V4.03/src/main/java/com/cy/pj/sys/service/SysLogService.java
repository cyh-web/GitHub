package com.cy.pj.sys.service;

import com.cy.pj.common.vo.PageObject;
import com.cy.pj.sys.entity.SysLog;

/**
 * 定义日志接口及方法
 */
public interface SysLogService {
	/**
	 * 基于多个id进行删除
	 * @param ids
	 * @return
	 */
	int deleteObjects(Integer...ids);
	/**
	 * 基于用户请求,进行日志信息的分页查询,并对结果进行封装
	 * @param username 基于条件查询的参数名
	 * @param pageCurrent 当前的页码值
	 * @return 当前页面+分页信息
	 */
	PageObject<SysLog> findPageObjects(String username,Integer pageCurrent);
}
