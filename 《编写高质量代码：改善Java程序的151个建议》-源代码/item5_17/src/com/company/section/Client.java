package com.company.section;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.builder.CompareToBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

public class Client {
	public static void main(String[] args) {
		List<String> list1 = new ArrayList<String>();
		list1.add("A");
		list1.add("B");
		List<String> list2 = new ArrayList<String>();
		list2.add("C");
		list2.add("B");
		
		//����
		 //list1.addAll(list2);

		//����
//		 list1.retainAll(list2);
//		 for(String str:list1){
//			 System.out.println(str);
//		 }
//		 
		 //����
		list1.removeAll(list2);
		 for(String str:list1){
			 System.out.println(str);
		 }
		
		//���ظ�����
//		list2.removeAll(list1);
//		list1.addAll(list2);
//		for(String str:list1){
//			System.out.println(str);
//		}
		
	}
}

