package com.company.section1;

import java.lang.reflect.Method;

public class Client {
	public static void main(String[] args) throws Exception {
		//�����ȡ����
		Method m1 = Foo.class.getMethod("doStuff");
		//��ӡ���Ƿ�ɷ���
		System.out.println("Accessible = "+m1.isAccessible());
		//ִ�з���
		m1.invoke(new Foo());
	}
}
