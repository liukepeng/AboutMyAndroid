package com.company.section4;

public class Client {
	public static void main(String[] args) {
		Thread t1 = new Thread() {
			public void run() {
				//�߳�һֱ����
				while (true) {
					System.out.println("Running����");
				}
			}
		};
		// ����t1�߳�
		t1.start();
		System.out.println(t1.isInterrupted());
		// �ж�t1�߳�
		t1.interrupt();
		System.out.println(t1.isInterrupted());
	}
}
