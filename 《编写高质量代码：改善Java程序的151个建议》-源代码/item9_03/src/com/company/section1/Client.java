package com.company.section1;

public class Client {
	public static void main(String[] args) throws Exception {
		// ���߳�
		Thread thread = new Thread() {
			@Override
			public void run() {
				try {
					// ���߳�����1��
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					//�쳣����
				}
				System.out.println("�˴����벻��ִ��");
			}
		};
		// �����߳�
		thread.start();
		// ���߳�����0.1��
		Thread.sleep(100);
		// ���߳�ֹͣ
		thread.stop();

	}
}
