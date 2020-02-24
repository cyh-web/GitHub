package com.cy.pj.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * 自定义注解,一个特殊的类,所有注解都默认继承Annotation接口
 */
@Retention(RetentionPolicy.RUNTIME)  //注解在运行时执行
@Target(ElementType.METHOD)   //标记注解的元素类型作为方法

/**
 * 此注解用于匹配该注解所特有的方法
 */
public @interface RequiredCache {
   //...
}
 