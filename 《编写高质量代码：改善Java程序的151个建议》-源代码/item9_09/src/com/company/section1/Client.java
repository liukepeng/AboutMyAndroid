package com.company.section1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
	public static void main(String[] args) throws Exception {
		//创建单线程执行器
		ExecutorService es = Executors.newSingleThreadExecutor();
		//执行一个任务
		Future<String> future = es.submit(new Callable<String>() {
			public String call() throws Exception {
				return "";
			}
		});
		//获得任务执行后的返回值
		System.out.println("返回值：" + future.get());
		//关闭执行器
		es.shutdown();
	}
}
