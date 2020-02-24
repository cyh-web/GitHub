package com.cy.java.thread;

public class TestThread01 {

	static void doMethod01() {
		while(true) {
			System.out.println("doMethod01");
		}
	}
	static void doMethod02() {
		while(true) {
			System.out.println("doMethod02");
		}
	}
	public static void main(String[] args) {
		//一个线程中的两个操作顺序执行
//		doMethod01();
//		doMethod02();
		
		//多线程异步执行
		new Thread() {
			@Override
			public void run() {
				doMethod01();
			}
		}.start();
		
		new Thread() {
			@Override
			public void run() {
				doMethod02();
			}
		}.start();
	}
}
