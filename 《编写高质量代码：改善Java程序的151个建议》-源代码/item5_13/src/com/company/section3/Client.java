package com.company.section3;

import java.util.ArrayList;
import java.util.List;

public class Client {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		
		List<String> subList = list.subList(0, 2);
		List<String> subList2 = list.subList(1,2);
		//ԭ�ַ�������һ��Ԫ��
		//list.add("D");
		subList2.add("D");

		System.out.println("ԭ�б��ȣ�" + list.size());
		System.out.println("���б��ȣ�" + subList.size());
	}
}
