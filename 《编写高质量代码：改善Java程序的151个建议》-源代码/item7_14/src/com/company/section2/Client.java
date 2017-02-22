package com.company.section2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Client {
	public static void main(String[] args) {
		//���������ɫ��Ҳ���Ǳ�������
		Subject subject = new RealSubject();
		//����ʵ���Ĵ���Handler
		InvocationHandler handler = new SubjectHandler(subject);
		//��ǰ������
		ClassLoader cl = subject.getClass().getClassLoader();
		//��̬����
		Subject proxy = (Subject) Proxy.newProxyInstance(cl, subject.getClass().getInterfaces(), handler);
		//ִ�о��������ɫ����
		proxy.request();	
	}
}

// ���������ɫ
interface Subject {
	// ����һ������
	public void request();
}
// ���������ɫ
class RealSubject implements Subject {
	// ʵ�ַ���
	public void request() {
		// ҵ���߼�����
	}
}
class SubjectHandler implements InvocationHandler {
	// ������Ķ���
	private Subject subject;
	
	public SubjectHandler(Subject _subject) {
		subject = _subject;
	}
	//ί�д�����
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		//Ԥ����
		System.out.println("Ԥ����");
		//ֱ�ӵ��ñ�������ķ���
		Object obj = method.invoke(subject, args);
		//����
		System.out.println("����");
		return obj;
	}
}