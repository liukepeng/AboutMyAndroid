package com.company.section2;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Client {
	public static void main(String[] args) {
		//2���̵߳��̳߳�
		ThreadPoolExecutor es = (ThreadPoolExecutor)Executors.newFixedThreadPool(100);
		//���ִ���߳���
		for (int i = 0; i < 4; i++) {
			
			es.submit(new Runnable() {
				public void run() {
					System.out.println(Thread.currentThread().getName());
				}
			});
		}
		System.out.println(es.getPoolSize());
		System.out.println(es.getCorePoolSize());
		//�ر�ִ����
		es.shutdown();
	}
}
