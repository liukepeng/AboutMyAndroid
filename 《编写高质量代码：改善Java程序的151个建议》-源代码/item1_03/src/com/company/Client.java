package com.company;
/**
 * ��Ԫ���������������������ͱ���һ��
 *
 */
public class Client {
	public static void main(String[] args) {
		int i = 80;
		String s = String.valueOf(i<100?90:100);
		String s1 = String.valueOf(i<100?90:100.0);
		System.out.println("�����Ƿ����:"+s.equals(s1));
	}
}
