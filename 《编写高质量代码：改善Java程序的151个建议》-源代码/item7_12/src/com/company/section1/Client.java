package com.company.section1;

public class Client {
	public static void main(String[] args) throws Exception{
		//动态加载
		Class.forName("com.company.section1.Utils");		
	}
}

class Utils{
	//静态代码块
	static{
		System.out.println("Do Something");
	}
	//静态方法
	public static void doStuff(){}
}
