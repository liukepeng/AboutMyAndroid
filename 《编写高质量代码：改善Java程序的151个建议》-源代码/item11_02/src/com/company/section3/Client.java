package com.company.section3;

import org.apache.commons.lang3.mutable.MutableInt;


public class Client {
	public static void main(String[] args) {
		//����һ���ɱ��int����
		MutableInt mi = new MutableInt(10);
		//mi��ֵΪ20
		mi.add(10);
		//�Լ�1�����Ϊ21
		mi.increment();
	}
}


