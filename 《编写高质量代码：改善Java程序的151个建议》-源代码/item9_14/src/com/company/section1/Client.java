package com.company.section1;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;

public class Client {
	static class Worker implements Runnable {
		// �ؿ�
		private CyclicBarrier cb;

		public Worker(CyclicBarrier _cb) {
			cb = _cb;
		}

		@Override
		public void run() {
			try {
				Thread.sleep(new Random().nextInt(1000));
				System.out.println(Thread.currentThread().getName() + "-�����ϵ�");
				// �����ϵ�
				cb.await();
			} catch (Exception e) {
				// �쳣����
			}

		}
	}

	public static void main(String[] args) throws Exception {
		// ���û㼯�������Լ��㼯��ɺ������
		CyclicBarrier cb = new CyclicBarrier(2, new Runnable() {
			public void run() {
				System.out.println("����Ѿ���ͨ��");
			}
		});
		// ����1�����
		new Thread(new Worker(cb), "����1").start();
		// ����2�����
		new Thread(new Worker(cb), "����2").start();
	}
}
