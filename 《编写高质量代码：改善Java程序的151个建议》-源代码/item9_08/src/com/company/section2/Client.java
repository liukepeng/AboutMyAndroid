package com.company.section2;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Client {
	public static void main(String[] args) {
		//2个线程的线程池
		ThreadPoolExecutor es = (ThreadPoolExecutor)Executors.newFixedThreadPool(100);
		//多次执行线程体
		for (int i = 0; i < 4; i++) {
			
			es.submit(new Runnable() {
				public void run() {
					System.out.println(Thread.currentThread().getName());
				}
			});
		}
		System.out.println(es.getPoolSize());
		System.out.println(es.getCorePoolSize());
		//关闭执行器
		es.shutdown();
	}
}
