package com.company.section1;


public class Client {
	public static void main(String[] args) throws Exception {
		String str = "����";
		//��ȡ�ֽ�
		byte[] b = str.getBytes("UTF-8");
		//��������һ���µ��ַ���
		System.out.println(new String(b,"UTF-8"));
	}

}
