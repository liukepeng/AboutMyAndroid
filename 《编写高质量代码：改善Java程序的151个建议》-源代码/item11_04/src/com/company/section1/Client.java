package com.company.section1;

import it.unimi.dsi.fastutil.BigList;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.objects.ObjectBigArrayBigList;

public class Client {
	public static void main(String[] args) {
		// ����������List��ע�����JVM��Heap�ڴ�
		BigList<Integer> bigList = new ObjectBigArrayBigList<Integer>(
				1L + Integer.MAX_VALUE);
		// �������͵ļ���,����ʹ�ð�װ����
		IntArrayList arrayList = new IntArrayList();
		// ��ȷ�����͵�Map
		Int2ObjectMap<String> map = new Int2ObjectOpenHashMap<String>();
		map.put(100, "A");
		System.out.println(map.get(100));
	}
}
