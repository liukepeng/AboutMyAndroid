package com.company.section7;

import com.google.common.base.Splitter;

public class Client {
	public static void main(String[] args) {
		String str = "��ã�Guava";
		// ��"��"���Ķ��ŷָ�
		for (String s : Splitter.on("��").split(str)) {
			System.out.println(s);
		}

		// ���չ̶����ȷָ�
		for (String s : Splitter.fixedLength(2).split(str)) {
			System.out.println(s);
		}
	}
}
