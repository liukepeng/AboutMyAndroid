package com.company.section5;
/**
 * 注意变量位置
 *
 */
public class Client {
	//定义一个人的年龄

	//静态代码块
	static{
		age=100;
	}
	public static int age;
	
	public static void main(String[] args) {
		System.out.println("Your age is："+age);
	}	
}
