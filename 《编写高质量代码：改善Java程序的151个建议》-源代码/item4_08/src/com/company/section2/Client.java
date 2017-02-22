package com.company.section2;

import java.text.Collator;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;

public class Client {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		String[] strs = {"����(Z)","����(L)","����(W)"};
		//����һ������������
		Comparator c = Collator.getInstance(Locale.CHINA);
		//��������
		Arrays.sort(strs,c);
		int i=0;
		for(String str:strs){
			System.out.println((++i) + "��"+ str);
		}
	}

}
