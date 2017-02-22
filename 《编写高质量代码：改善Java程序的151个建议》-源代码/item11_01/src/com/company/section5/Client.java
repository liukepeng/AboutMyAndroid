package com.company.section5;

import java.util.HashMap;
import java.util.Map;

import com.google.common.base.Predicate;
import com.google.common.collect.Maps;

public class Client {
	public static void main(String[] args) {
		// �����������
		Map<String, Integer> user = new HashMap<String, Integer>();
		user.put("����", 20);
		user.put("����", 22);
		user.put("����", 25);
		// �����������20�����Ա
		Map<String, Integer> filtedMap = Maps.filterValues(user,
				new Predicate<Integer>() {
					public boolean apply(Integer value) {
						return value > 20;
					}
				});
		System.out.println(filtedMap);
	}
}
