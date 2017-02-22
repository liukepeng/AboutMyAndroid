package com.company;

import java.io.Serializable;

public class Person implements Serializable{	
	private static final long serialVersionUID = 91282334L;
	//通过方法返回值为final变量赋值
	public  final String name=initName();	
	//初始化方法名
	public String initName(){
		return "德天使";
	}
}
