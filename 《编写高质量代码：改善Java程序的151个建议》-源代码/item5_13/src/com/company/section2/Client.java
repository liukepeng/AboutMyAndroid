package com.company.section2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Client {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		
		List<String> subList = list.subList(0, 2);
		list = Collections.unmodifiableList(list);
		//ԭ�ַ�������һ��Ԫ��
		subList.add("D");
		System.out.println("ԭ�б��ȣ�" + list.size());
		System.out.println("���б��ȣ�" + subList.size());
	}
}
