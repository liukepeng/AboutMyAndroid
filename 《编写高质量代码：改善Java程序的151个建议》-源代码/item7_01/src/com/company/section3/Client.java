package com.company.section3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Client {
	public static void main(String[] args) {
		//List<String>[] listArray = new List<String>[];
//		List<String> list = new ArrayList<String>();
//		System.out.println(list instanceof List<String>);
		List<String> list = new ArrayList<String>();
		List l = list;
		l.add(123);
	}
}
