package com.cy.java.api.basic;

public class TestIntegerCache01 {

	public static void main(String[] args) {
		String s1 = "ABC";//字符串对象
		String s2 = "ABC";//从字符串池中取,池中没有则创建,然后存储到字符串池
		System.out.println(s1 == s2);//true
		
		String s3 = new String("ABC");//new关键字表示新创建一个对象
		String s4 = new String("ABC");
		System.out.println(s3 == s4);//false
		
		Integer a1 = 100;//整数对象
		Integer a2 = 100;//整数对象,从池中取,池中没有会创建
		//a1和a2两个变量指向了池中的同一个对象
		System.out.println(a1 == a2);//true//Integer对象提供了一个整数池,池中存储了-128~+127
		
		Integer a3 = 200;//池中没有,会new Integer(100);
		Integer a4 = 200;//系统底层在运行时基于Integer.valueOf方法进行池中数据查找
		System.out.println(a3 == a4);//false
		
		//...
	}
}
