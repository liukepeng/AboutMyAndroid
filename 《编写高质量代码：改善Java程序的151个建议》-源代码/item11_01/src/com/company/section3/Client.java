package com.company.section3;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public class Client {
	public static void main(String[] args) {
		Table<Double,Double,String> l = HashBasedTable.create();
		//��������㳡�ľ�γ������
		l.put(31.23, 121.48, "����㳡");	
		System.out.println(l.get(31.23,121.48));
	}
}
