package com.company.section5;


import java.util.Timer;
import java.util.TimerTask;

public class Client {
	public static void main(String[] args) throws InterruptedException {
		final SafeStopThread sst = new SafeStopThread();
		sst.start();
		//0.5����߳�ִֹͣ��
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
		//�ж��߳����Ƿ�����
		while (!isInterrupted()) {
			// Do Something
		}
	}	
}
