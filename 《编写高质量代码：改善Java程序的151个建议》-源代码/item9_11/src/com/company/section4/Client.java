package com.company.section4;

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
		public synchronized void b1(A a) {
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
		}

		public synchronized void b2() {
			System.out.println("����B.b2()");
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


