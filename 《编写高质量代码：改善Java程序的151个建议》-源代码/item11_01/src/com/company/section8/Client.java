package com.company.section8;

import java.util.ArrayList;
import java.util.List;

import com.google.common.primitives.Ints;

public class Client {
	public static void main(String[] args) {
		int[] ints = { 10, 9, 20, 40, 80 };
		// ������ȡ�����ֵ
		System.out.println(Ints.max(ints));
		List<Integer> integers = new ArrayList<Integer>();
		// �Ѱ�װ���͵ļ���תΪ������������
		ints = Ints.toArray(integers);
	}
}
