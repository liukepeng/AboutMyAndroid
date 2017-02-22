package com.company.section8;

import java.util.ArrayList;
import java.util.List;

import com.google.common.primitives.Ints;

public class Client {
	public static void main(String[] args) {
		int[] ints = { 10, 9, 20, 40, 80 };
		// 数组中取出最大值
		System.out.println(Ints.max(ints));
		List<Integer> integers = new ArrayList<Integer>();
		// 把包装类型的集合转为基本类型数组
		ints = Ints.toArray(integers);
	}
}
