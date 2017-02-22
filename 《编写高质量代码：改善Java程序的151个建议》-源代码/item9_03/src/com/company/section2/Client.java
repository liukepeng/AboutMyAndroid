package com.company.section2;

public class Client {
	public static void main(String[] args) {
		MultiThread t = new MultiThread();
		Thread t1 = new Thread(t);
		// ����t1�߳�
		t1.start();
		for (int i = 0; i < 5; i++) {
			new Thread(t).start();
		}
		// ֹͣt1�߳�
		t1.stop();
	}
}

class MultiThread implements Runnable {
	int a = 0;

	@Override
	public void run() {
		// ͬ������飬��֤ԭ�Ӳ���
		synchronized ("") {
			// ����
			a++;
			try {
				// �߳�����0.1��
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// �Լ�
			a--;
			String tn = Thread.currentThread().getName();
			System.out.println(tn + ":a =" + a);
		}
	}
}