package com.company.section5;


import java.util.Timer;
import java.util.TimerTask;

public class Client {
	public static void main(String[] args) throws InterruptedException {
		final SafeStopThread sst = new SafeStopThread();
		sst.start();
		//0.5秒后线程停止执行
		new Timer(true).schedule(new TimerTask() {
			public void run() {
				sst.interrupt();
			}
		}, 500);
	}

}

class SafeStopThread extends Thread {
	@Override
	public void run() {
		//判断线程体是否运行
		while (!isInterrupted()) {
			// Do Something
		}
	}	
}
