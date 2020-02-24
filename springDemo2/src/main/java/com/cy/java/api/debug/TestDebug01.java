package com.cy.java.api.debug;

public class TestDebug01 {
	
	public static void doMethod02() {
		System.out.println("doMethod02");
	}
	public static void doMethod01() {
		System.out.println("doMethod01");
		doMethod02();
	}
	public static void main(String[] args) {
		System.out.println("hello everyone");
		System.out.println("hello world");
		System.out.println("hello cgb1911");
		doMethod01();
	}
}
