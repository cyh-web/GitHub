package com.cy.pj.sys.dao;

import java.util.List;
import java.util.Map;

//import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SysMenuDaoTests {

	@Autowired
	private SysMenuDao sysMenuDao;
	
	@Test
	public void  testfindObjects() {
		List<Map<String,Object>> list = sysMenuDao.findObjects();
//		List<Map<String,Object>> list = sysMenuDao.findObjects();
//		Assertions.assertNotEquals(null, list);//断言测试法
		System.out.println("list.size="+list.size());
		
		for (Map<String, Object> map : list) {
			System.out.println(map);
		}
//		//JDK8 lambda 表达式  匿名内部类
//		list.forEach((map)->System.out.println(map));
	}
	
}
