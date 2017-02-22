package com.company.section10;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.collections.Factory;
import org.apache.commons.collections.list.LazyList;
import org.apache.commons.lang3.RandomStringUtils;

public class Client {
	public static void main(String[] args) {
		//��һ��List��װ��һ��Lazy����
		List<String> lazy = LazyList.decorate(new ArrayList(),
				new Factory() {
					public String create() {
						return RandomStringUtils.randomAlphabetic(20);
					}

				});
		//�����˵�4��Ԫ�أ���ʱ0��1��2Ԫ��Ϊnull
		String obj = lazy.get(3);
		//׷��һ��Ԫ��
		lazy.add("�����Ԫ��");
		//Ԫ������Ϊ5��
		System.out.println(lazy.size());
		System.out.println(lazy);

	}
}
