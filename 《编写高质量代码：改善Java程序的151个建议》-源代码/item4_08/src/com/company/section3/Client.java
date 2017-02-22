package com.company.section3;

import java.text.Collator;
import java.util.Arrays;
import java.util.Locale;

public class Client {
	public static void main(String[] args) throws Exception {
		String[] strs = {" Ä(B)","öÎ(X)"};
		Arrays.sort(strs,Collator.getInstance(Locale.CHINA));
		int i=0;
		for(String str:strs){
			System.out.println((++i) + "¡¢"+ str);
		}

	}

}
