package com.company.section1;

import java.util.Arrays;

import org.apache.commons.lang.CharUtils;

public class Client {
	public static void main(String[] args){
		String[] strs = {"����(Z)","����(L)","����(W)"};
		//����Ĭ��������
		Arrays.sort(strs);
		int i=0;
		for(String str:strs){			
			System.out.println((++i) + "��"+ str);
		}
	
		System.out.println(Integer.toHexString('��'));
//		System.out.println((short)"��".charAt(0));
		//CharUtils.toIntValue('��');

		
	}

}
