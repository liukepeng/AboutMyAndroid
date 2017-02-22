package com.company.section2;

public class Client {
	static class Foo {
		public synchronized void m1() {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// �쳣����
			}
			System.out.println("m1ִ�����");
		}

		public synchronized void m2() {
			System.out.println("m2ִ�����");
		}
	}

	public static void main(String[] args) throws Exception {
		final Foo foo = new Foo();
		// ����һ���߳�
		Thread t = new Thread(new Runnable() {
			public void run() {
				foo.m1();
			}
		});
		t.start();
		// �ȴ�t1�߳��������
		Thread.sleep(10);
		// m2������Ҫ�ȴ�m1ִ�����
		foo.m2();
	}
}
