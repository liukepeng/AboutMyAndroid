package com.company.section;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Client {
	public static void main(String[] args) {
		List<String> cities = new ArrayList<String>();
		cities.add("�Ϻ�");
		cities.add("����");
		cities.add("����");
		cities.add("����");
		cities.add("���");
		//indexOf����ȡ������ֵ
		int index1 = cities.indexOf("����");
		//binarySearch���ҵ�����ֵ
		int index2 = Collections.binarySearch(cities, "����");
		System.out.println("����ֵ(indexOf)��"+index1);
		System.out.println("����ֵ��binarySearch)��"+index2);
	}
}
	

