package com.company.section2;


public class Client {
	public static void main(String[] args) throws Exception {
		String str = "����";
		//��ȡ�ֽ�
		byte[] b = str.getBytes("GB18030");
		//��������һ���µ��ַ���
		System.out.println(new String(b));
	}
}
