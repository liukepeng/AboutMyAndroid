package com.company;


public class Client {
	{
		//构造代码块
		System.out.println("执行构造代码块");
	}
	
	public Client(){
		System.out.println("执行构造代码块");
		System.out.println("执行无参构造");
	}
	
	public Client(String _str){
		System.out.println("执行构造代码块");
		System.out.println("执行有参构造");
	}
}
