package com.company.section9;

import org.apache.commons.collections.BidiMap;
import org.apache.commons.collections.bidimap.TreeBidiMap;

public class Client {
	public static void main(String[] args) {
		// key��value���������ظ���Map
		BidiMap bidiMap = new TreeBidiMap();
		bidiMap.put(1, "Ҽ");
		// ����key��ȡvalue
		System.out.println(bidiMap.get(1));
		// ����value��ȡkey
		System.out.println(bidiMap.getKey("Ҽ"));
		// ����valueɾ����ֵ��
		bidiMap.removeValue("Ҽ");
		System.out.println(bidiMap.size());
	}
}
