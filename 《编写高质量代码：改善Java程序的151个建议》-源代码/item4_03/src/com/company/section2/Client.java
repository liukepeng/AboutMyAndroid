package com.company.section2;

public class Client {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("a");
		sb.append("b");
		
		String s = "a";
		s = s + "b";
		System.out.println(s);
	}
}
