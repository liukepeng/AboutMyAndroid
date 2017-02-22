package com.company.section1;

public class Client {
	public static void main(String[] args) {
		System.out.println(toChineseNum(0));
	}
	
	public static String toChineseNum(int num){
		//ÖĞÎÄÊı×Ö
		String[] cns = {"Áã","Ò¼","·¡","Èş","ËÁ","Îé","Â½","Æâ","°Æ","¾Á"};
		return cns[num];
	}
}
