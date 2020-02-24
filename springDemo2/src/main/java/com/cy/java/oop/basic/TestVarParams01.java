package com.cy.java.oop.basic;

/** 可变参数 */
public class TestVarParams01 {

	//可变参数调用的优先级小于直接参数的调用优先级
	
//	static void doMethod() {}
//	static void doMethod(int a) {}
//	static void doMethod(int a,int b) {}
//	static void doMethod(int a,int b,int c) {}
//	static void doMethod(int a,int b,int c,int d) {}
	
	static void doMethod(int...a) {
		System.out.println(a.length);
	}
	
	static void doMethod(String s1,Integer... args){}//可变参数一定要放在最后一个参数进行定义
	
	public static void main(String[] args) {
		doMethod();
		doMethod(10);
		doMethod(10,20);
		doMethod(10,20,30);
		doMethod(10,20,30,40);
	}
}
