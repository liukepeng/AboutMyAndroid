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
		//把一个List包装成一个Lazy类型
		List<String> lazy = LazyList.decorate(new ArrayList(),
				new Factory() {
					public String create() {
						return RandomStringUtils.randomAlphabetic(20);
					}

				});
		//访问了第4个元素，此时0、1、2元素为null
		String obj = lazy.get(3);
		//追加一个元素
		lazy.add("第五个元素");
		//元素总数为5个
		System.out.println(lazy.size());
		System.out.println(lazy);

	}
}
