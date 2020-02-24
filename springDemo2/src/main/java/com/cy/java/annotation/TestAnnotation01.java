package com.cy.java.annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
/** 自定义注解借助@interface定义 */
@Retention(RetentionPolicy.RUNTIME) //描述Delete注解何时有效
@Target(ElementType.METHOD) //描述Delete注解可以修饰哪些成员
@interface Delete{
	String value() default "";//属性
}
/** 商品数据层接口  */
interface GoodsDao{
	@Delete("delete from tb_goods")
	int deleteById();
}
/** 测试类  */
public class TestAnnotation01 {
	public static void main(String[] args) throws Exception {
		//业务:基于反射技术获取GoodsDao接口方法deleteById上的Delete注解的内容
		//思考:反射的入口对象是谁? 字节码对象
		//步骤:
		//step01:获取接口的字节码对象
		Class<?> c1 = GoodsDao.class;
		//step02:获取deleteById方法对象
		Method method = c1.getMethod("deleteById");
		//step03:获取方法上的delete注解对象
		Delete delete = method.getAnnotation(Delete.class);
		//step04:获取注解中的value属性值
		String value = delete.value();
		System.out.println(value);	
	}
}
