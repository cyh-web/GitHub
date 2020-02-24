package com.cy.pj.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 此Controller主要负责响应一些页面
 *
 */
@Controller
@RequestMapping("/")
public class PageController {
	//在PageController中定义返回菜单列表的方法
//	@RequestMapping("menu/menu_list")
//	public String doMenuUI() {
//		return "sys/menu_list";
//	}
	
	/**返回日志列表页面-服务端的实现*/
//	@RequestMapping("log/log_list")
//	public String doLogUI() {
//		return "sys/log_list";
//	}
	
	//在PageController中优化返回UI页面的方法。找出共性进行提取
	@RequestMapping("{module}/{moduleUI}")
	public String doModuleUI(@PathVariable String moduleUI) {
			return "sys/"+moduleUI;
	}
	
	@RequestMapping("doIndexUI")
	public String doIndexUI() {
		return "starter";
	}

	
	@RequestMapping("doPageUI")
	public String doPageUI() {
		return "common/page";
	}
}
