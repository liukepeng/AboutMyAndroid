package com.company.section4;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public class Client {
	public static void main(String[] args) {
		//Table����ȫ�������ݿ��
		Table<Integer,Integer,String> user = HashBasedTable.create();
		//��һ�У���һ�е�ֵ������
		user.put(1, 1, "����");
		//��һ�У��ڶ��е�ֵ������
		user.put(1,2,"����");
		System.out.println(user.get(1,1));
	}
}
