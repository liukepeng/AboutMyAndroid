package com.company;

public class UtilsClass {
	private UtilsClass(){
		throw new Error("��Ҫʵ�����ң�");
	}
	
	public static void doSomethign(){
		System.out.println("aa");
	}
	public static void main(String[] args) {
		UtilsClass.doSomethign();
	}
}
