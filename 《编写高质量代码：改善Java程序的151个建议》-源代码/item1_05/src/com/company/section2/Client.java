package com.company.section2;

/**
 * ���б䳤�����ķ������أ��ڵ���ʱʧ�ܡ�
 *
 */

public class Client {
	public void methodA(String str,Integer... is){		
		System.out.println("Integer");
	}
	
	public void methodA(String str,String... strs){		
		System.out.println("String");
	}
	
	public static void main(String[] args) {
		Client client = new Client();
		String[] strs = null;
		client.methodA("China",strs);
	}
}
