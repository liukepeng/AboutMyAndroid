package com.company.section1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Client {
	public static void main(String[] args) {
		try {
			doStuff();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void doStuff() throws Exception {
		InputStream is = new FileInputStream("��Ч�ļ�.txt");
		/*�ļ�����*/
	}
	
	public static void doStuff2() throws MyBussinessException{
		try {
			InputStream is = new FileInputStream("��Ч�ļ�.txt");
		} catch (FileNotFoundException e) {
			//Ϊ���㿪����ά����Ա�����õ��쳣��Ϣ
			e.printStackTrace();
			//�׳�ҵ���쳣
			throw new MyBussinessException(e);
		}
		/*�ļ�����*/
	}
}

class MyBussinessException extends Exception{
	public MyBussinessException(Throwable t){
		super(t);
	}
}

