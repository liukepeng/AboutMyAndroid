package com.company;

import java.util.List;
import java.util.Random;
import java.util.Vector;

public class Client {

	public static void main(String[] args) {
		// ��Ʊ�б�
		final List<String> tickets = new Vector<String>();
		// ��ʼ��Ʊ�ݳ�
		for (int i = 0; i < 100000; i++) {
			tickets.add("��Ʊ" + i);
		}

		// ��Ʊ
		Thread returnThread = new Thread() {
			public void run() {
				while (true) {
					tickets.add("��Ʊ" + new Random().nextInt());
				}
			};
		};

		// ��Ʊ
		Thread saleThread = new Thread() {
			public void run() {
				for (String ticket : tickets) {
					tickets.remove(ticket);
				}
			};
		};

		// ������Ʊ�߳�
		returnThread.start();
		// ������Ʊ�߳�
		saleThread.start();

	}
}
