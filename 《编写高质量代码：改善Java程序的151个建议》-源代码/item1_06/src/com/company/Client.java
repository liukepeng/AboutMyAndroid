package com.company;

/**
 * ��д�䳤����Ҳѭ�浸��
 *
 */

public class Client {
	public static void main(String[] args) {
		//����ת��
		Base  base = new Sub();
		base.fun(100, 50);
		//��ת��
		Sub sub = new Sub();
		//sub.fun(100, 50);
	}
}
//����
class Base{
	void fun(int price,int... discounts){
		System.out.println("Base����fun");
	}	
}

//���࣬��д���෽��
class Sub extends Base{
	@Override
	void fun(int price,int[] discounts){
		System.out.println("Sub����fun");
	}
}
