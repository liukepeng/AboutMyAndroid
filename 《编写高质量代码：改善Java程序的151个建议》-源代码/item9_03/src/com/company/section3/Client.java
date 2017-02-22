package com.company.section3;


import java.util.Timer;
import java.util.TimerTask;

public class Client {
	public static void main(String[] args) throws InterruptedException {
		final SafeStopThread sst = new SafeStopThread();
		sst.start();
		//0.5����߳�ִֹͣ��
		new Timer(true).schedule(new TimerTask() {
			public void run() {
				sst.terminate();
			}
		}, 500);
	}

}

class SafeStopThread extends Thread {
	//�˱����������volatile
	private volatile boolean stop = false;
	@Override
	public void run() {
		//�ж��߳����Ƿ�����
		while (stop) {
			// Do Something
		}
	}
	//�߳���ֹ
	public void terminate() {
		stop = true;
	}
}
