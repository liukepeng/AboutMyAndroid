package com.company.section1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Client {
	public static void main(String[] args) {
		//��ʼ��һ���̶����ȣ����ɱ��б�
		List<Integer> initData= Collections.nCopies(100, 0);
		//ת��Ϊ�ɱ��б�
		ArrayList<Integer> list = new ArrayList<Integer>(initData);
		//ɾ��ָ����Χ��Ԫ��
		list.subList(20, 30).clear();
	}
}
