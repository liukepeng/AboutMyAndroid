package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Client {
	public static void main(String[] args) {
		// ��ʼ��һ���̶����ȣ����ɱ��б�
		List<Integer> initData = Collections.nCopies(100, 0);
		// ת��Ϊ�ɱ��б�
		List<Integer> list = new ArrayList<Integer>(initData);
		// ������ɾ������������Ԫ��
//		for (int i = 0, size = list.size(); i < size; i++) {
//			System.out.println(list.get(i));
//			if (i >= 20 && i < 30) {
//				list.remove(i);
//			}
//		}

		for (int i = 20; i < 30; i++) {
			if(i<list.size()){
				list.remove(i);
			}
		}
	}
}
