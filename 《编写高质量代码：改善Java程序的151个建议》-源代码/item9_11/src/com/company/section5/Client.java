package com.company.section5;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Client {
	// ��ԴA
	static class A {
		public synchronized void a1(B b) {
			String name = Thread.currentThread().getName();
			System.out.println(name + " ����A.a1()");
			try {
				// ����1�룬��Ȼ������
				Thread.sleep(1000);
			} catch (Exception e) {
				// �쳣����
			}
			System.out.println(name + " ��ͼ����B.b2()");
			b.b2();
		}

		public synchronized void a2() {
			System.out.println("���� a.a2()");
		}
	}

	// ��ԴB
	static class B {
		final ReentrantLock lock = new ReentrantLock();

		public void b1(A a) {
			try {
				lock.lock();
				String name = Thread.currentThread().getName();
				System.out.println(name + " ����B.b1()");
				try {
					// ����1�룬��Ȼ������
					Thread.sleep(1000);
				} catch (Exception e) {
					// �쳣����
				}
				System.out.println(name + " ��ͼ����A.a2()");
				a.a2();
			} finally {
				lock.unlock();
			}

		}

		public void b2() {
			try {
				//���̻����������2��ȴ�����Դ
				if (lock.tryLock() || lock.tryLock(2, TimeUnit.SECONDS)) {
					System.out.println("����B.b2()");
				}				
			} catch (InterruptedException e) {
				//�쳣����
			} finally {
				//�ͷ���
				lock.unlock();
			}

		}
	}

	public static void main(String args[]) {
		final A a = new A();
		final B b = new B();
		// �߳�A
		new Thread(new Runnable() {
			public void run() {
				a.a1(b);
			}
		}, "�߳�A").start();
		// �߳�B
		new Thread(new Runnable() {
			public void run() {
				b.b1(a);
			}
		}, "�߳�B").start();
	}
}
