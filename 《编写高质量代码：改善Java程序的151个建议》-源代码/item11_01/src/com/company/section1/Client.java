package com.company.section1;

import java.util.List;
import java.util.Map;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

public class Client {
	public static void main(String[] args) {
		//���ɱ伯��
		List<String> list = ImmutableList.of("A","B","C");
		//���ɱ�Map
		Map<Integer,String> map = ImmutableMap.of(1,"Ҽ",2,"��",3,"��");
	}
}
