package com.company.section1;

public class Client {
	public static void main(String[] args) {
		System.out.println(toChineseNum(0));
	}
	
	public static String toChineseNum(int num){
		//��������
		String[] cns = {"��","Ҽ","��","��","��","��","½","��","��","��"};
		return cns[num];
	}
}
