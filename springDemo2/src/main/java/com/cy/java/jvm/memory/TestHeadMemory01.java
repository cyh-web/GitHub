package com.cy.java.jvm.memory;

/**
 * 
 * 堆内存运行参数配置:
 * 1)-Xms 最小值
 * 2)-Xmx 最大值
 * 
 *  -Xmx5m -Xms5m
 */
public class TestHeadMemory01 {
	public static void main(String[] args) {
		byte[] a1 = new byte[1024*1024];//1M
		//a1 = null;
		byte[] a2 = new byte[1024*1024];//1M
		//a2 = null;
		byte[] a3 = new byte[1024*1024];//1M
		//a3 = null;
		byte[] a4 = new byte[1024*1024];//1M
		//a4 = null;
		byte[] a5 = new byte[1024*1024];//1M
		//a5 = null;
	}
}
