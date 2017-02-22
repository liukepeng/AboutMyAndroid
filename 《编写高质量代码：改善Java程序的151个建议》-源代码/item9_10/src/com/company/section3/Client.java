package com.company.section3;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Client {

	public static void main(String[] args) {
		final Foo foo = new Foo();
		// ���������߳�
		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {
				public void run() {
					if (new Random().nextBoolean()) {
						foo.write("");
					} else {
						foo.read();
					}
				}
			}).start();

		}
	}

}

class Foo {
	//������Ķ�д��
	private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
	//����
	private final Lock r = rwl.readLock();
	//д��
	private final Lock w = rwl.writeLock();
	
	//��������ɲ���ִ��
	public void read() {
		try {
			r.lock();
			Thread.sleep(1000);
			System.out.println("read����");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			r.unlock();
		}

	}
	//д������ͬʱֻ����һ��д����
	public void write(Object _obj) {
		try {
			w.lock();
			Thread.sleep(1000);
			System.out.println("Writing����");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			w.unlock();
		}
	}

}
