package com.company.section8;

import java.util.Arrays;

import org.apache.commons.collections.Bag;
import org.apache.commons.collections.bag.HashBag;

public class Client {
	public static void main(String[] args) {
		//һ��������װ��4����
		Bag box =new HashBag(Arrays.asList("red","blue","black","blue"));
		//��������3����ɫ��
		box.add("blue", 3);
		//�������Ϊ7
		System.out.println(box.size());
		//��ɫ������Ϊ5
		System.out.println(box.getCount("blue"));
	}
}
