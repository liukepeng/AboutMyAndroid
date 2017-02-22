package com.company.section1;

public class Client {
	public static void main(String[] args) throws Exception {
		// 子线程
		Thread thread = new Thread() {
			@Override
			public void run() {
				try {
					// 该线程休眠1秒
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					//异常处理
				}
				System.out.println("此处代码不会执行");
			}
		};
		// 启动线程
		thread.start();
		// 主线程休眠0.1秒
		Thread.sleep(100);
		// 子线程停止
		thread.stop();

	}
}
