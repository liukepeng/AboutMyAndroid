package com.company.section1;

import java.util.concurrent.TimeUnit;

public class Client {
	public static void main(String[] args) throws Exception {
		// ����һ���̣߳��½�״̬
		Thread t = new Thread(new Runnable() {
			public void run() {
				System.out.println("�߳������С���");
			}
		});
		// ����״̬
		t.start();
		// �Ƿ�������̬����������ȴ�10����
		while (!t.getState().equals(Thread.State.TERMINATED)) {
			TimeUnit.MILLISECONDS.sleep(10);
		}
		// ֱ���ɽ���̬ת��Ϊ����̬
		t.start();
	}
}
