package com.company.section1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
	public static void main(String[] args) throws Exception {
		//�������߳�ִ����
		ExecutorService es = Executors.newSingleThreadExecutor();
		//ִ��һ������
		Future<String> future = es.submit(new Callable<String>() {
			public String call() throws Exception {
				return "";
			}
		});
		//�������ִ�к�ķ���ֵ
		System.out.println("����ֵ��" + future.get());
		//�ر�ִ����
		es.shutdown();
	}
}
