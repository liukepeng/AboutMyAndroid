package com.company;

import java.io.Serializable;

public class Person implements Serializable{	
	private static final long serialVersionUID = 91282334L;
	//ͨ����������ֵΪfinal������ֵ
	public  final String name=initName();	
	//��ʼ��������
	public String initName(){
		return "����ʹ";
	}
}
