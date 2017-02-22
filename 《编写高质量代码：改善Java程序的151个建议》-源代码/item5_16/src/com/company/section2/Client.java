package com.company.section2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Client {
	public static void main(String[] args) {
		int max =1200000;
		List<String> cities = new ArrayList<String>();
		for(int i=0;i<max;i++){
			cities.add(i+"");
		}
		//indexOf����ȡ������ֵ
		long start = System.nanoTime();
		int index1 = cities.indexOf((max-5)+"");
		long mid = System.nanoTime();
		System.out.println(mid - start);
		//binarySearch���ҵ�����ֵ
		int index2 = Collections.binarySearch(cities, (max-5)+"");
		long end = System.nanoTime();
		System.out.println(end - mid);
		System.out.println("����ֵ(indexOf)��"+index1);
		System.out.println("����ֵ��binarySearch)��"+index2);
	}
}
	

