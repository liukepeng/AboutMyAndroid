package com.company.section1;

public class Client {
	public static void main(String[] args) throws Exception{
		//��̬����
		Class.forName("com.company.section1.Utils");		
	}
}

class Utils{
	//��̬�����
	static{
		System.out.println("Do Something");
	}
	//��̬����
	public static void doStuff(){}
}
