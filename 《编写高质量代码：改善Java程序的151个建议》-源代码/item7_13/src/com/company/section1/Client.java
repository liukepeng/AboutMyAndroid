package com.company.section1;

import java.lang.reflect.Array;

public class Client {
	public static void main(String[] args) throws Exception{
//		Integer[] strs = new Integer[10];
//		long[] bytes = new long[100];
//		System.out.println(strs.getClass());
//		//����һ��String����
		Class.forName("[Ljava.lang.String;");
		//����һ��long����
		Class.forName("[J");
		//���鷴����
		String[] strs = (String[]) Array.newInstance(String.class, 8);
		//����һ����ά����
		int[][] ints = (int[][]) Array.newInstance(int.class,2,3);
	}
}
