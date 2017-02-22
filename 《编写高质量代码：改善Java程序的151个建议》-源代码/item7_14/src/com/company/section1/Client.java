package com.company.section1;

import java.lang.reflect.Method;


public class Client {
	public static void main(String[] args) throws Exception{
	
	}
}
//���������ɫ
interface Subject {	
	//����һ������
	public void request();
}
//���������ɫ
class RealSubject implements Subject {	
	//ʵ�ַ���
	public void request() {
		//ҵ���߼�����
	}
}
//���������ɫ
class Proxy implements Subject {
	//Ҫ�����ĸ�ʵ����
	private Subject subject = null;	
	//Ĭ�ϱ�������
	public Proxy(){
		subject = new RealSubject();
	}
	//ͨ�����캯�����ݱ�������
	public Proxy(Subject _subject ){
		subject = _subject;
	}
	//ʵ�ֽӿ��ж���ķ���
	public void request() {
		before();
		subject.request();
		after();
	}
	//Ԥ����
	private void before(){
		//do something
	}
	//�ƺ���
	private void after(){
		//do something
	}
}
