package com.cy.pj.sys.service;



import java.util.List;
import java.util.Map;

//import org.apache.ibatis.scripting.xmltags.ForEachSqlNode;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//import com.cy.pj.common.vo.PageObject;
//import com.cy.pj.sys.entity.SysLog;

@SpringBootTest
public class SysMenuServiceTests {

	@Autowired
	private SysMenuService sysMenuService;
	
	@Test
	public void testfindObjects() {
		List<Map<String, Object>> findObjects = sysMenuService.findObjects();
		System.out.println("findObjects.size="+findObjects.size());
		
//		for (Map<String, Object> map : findObjects) {
//			System.out.println(map);
//		}
		
		findObjects.forEach((map)->System.out.println(map));
	}
}
