package com.company.section4;

import java.util.ArrayList;
import java.util.List;

public class Client {
	public static void main(String[] args) {
		//����֧��Э��
		Number[] n = new Integer[10];
		//���벻ͨ�������Ͳ�֧��Э��
		//List<Number> ln = new ArrayList<Integer>(); 
		//Number�������Ͷ������Ƿ��Ͳ�������
		List<? extends Number> ln = new ArrayList<Integer>();
		//Integer�ĸ�����(����Integer)�������Ƿ��Ͳ�������
		List<? super Integer>  li = new ArrayList<Number>();
		//�������Ͷ������Ƿ��Ͳ�������
		List<?> l = new ArrayList<Integer>();
	}
}

class Base{
	public void doStuff(Integer i){	
	}
}

class Sub extends Base{
	public void doStuff(Number n){	
	}
}