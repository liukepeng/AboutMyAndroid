package com.company.section1;

import java.util.Calendar;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Client {
	public static void runTasks(Class<? extends Runnable> clz) throws Exception {
		ExecutorService es = Executors.newCachedThreadPool();
		System.out.println("*****��ʼִ��" + clz.getSimpleName() + " ����******");
		// ���������߳�
		for (int i = 0; i < 3; i++) {
			es.submit(clz.newInstance());
		}
		// �ȴ��㹻��ʱ�䣬Ȼ��ر�ִ����
		TimeUnit.SECONDS.sleep(10);

		System.out.println("------" + clz.getSimpleName() + " ����ִ�����-----\n");
		// �ر�ִ����
		es.shutdown();
	}
	public static void main(String[] args) throws Exception {
		runTasks(TaskWithLock.class);
		runTasks(TaskWithSync.class);
	}

	
}

class Task {
	public void doSomething() {
		try {
			// ÿ���̵߳ȴ�2���ӣ�ע���ʱ�߳�תΪWAITING״̬
			Thread.sleep(2000);
		} catch (Exception e) {
			// �쳣����
		}
		StringBuffer sb = new StringBuffer();
		// �߳�����
		sb.append("�߳����ƣ�" + Thread.currentThread().getName());
		// ���е�ʱ���
		sb.append(",ִ��ʱ�䣺" + Calendar.getInstance().get(13)+ " s");
		System.out.println(sb);
	}
}
//��ʽ������
class TaskWithLock extends Task implements Runnable {
	// ������ʽ��
	private final Lock lock = new ReentrantLock();

	@Override
	public void run() {
		try {
			// ��ʼ����
			lock.lock();
			doSomething();
		} finally {
			// �ͷ���
			lock.unlock();
		}
	}
}
//�ڲ�������
class TaskWithSync extends Task implements Runnable {
	@Override
	public void run() {
		// �ڲ���
		synchronized ("A") {
			doSomething();

		}
	}
}
