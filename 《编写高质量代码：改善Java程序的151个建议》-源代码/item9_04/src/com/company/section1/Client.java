package com.company.section1;

public class Client {
	public static void main(String[] args){
		//����20����ͬ���ȼ����߳�
		for (int i = 0; i < 20; i++) {
			new TestThread().start(i % 10 + 1);
		}

	}
}

class TestThread implements Runnable {
	//�����߳�
	public void start(int _priority) {
		Thread t = new Thread(this);
		//�����߳����ȼ�
		t.setPriority(_priority);
		t.start();
	}

	@Override
	public void run() {
		//����CPU�ļ��㣬���ܲ�Ļ��������޸�ѭ������
		for (int i = 0; i < 100000; i++) {
			Math.hypot(Math.pow(924526789,i),Math.cos(i));
		}
		//����߳����ȼ�
		System.out.println("Priority:" + Thread.currentThread().getPriority());

	}
}