package com.company.section2;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class Client {
	public static void main(String[] args) {
		//��ֵMap
		Multimap<String,String> phoneBook = ArrayListMultimap.create();
		phoneBook.put("����", "110");
		phoneBook.put("����", "119");
		System.out.println(phoneBook.get("����"));
	}
}
