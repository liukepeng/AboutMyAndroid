package com.company.section2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Client {
	public static void main(String[] args) throws Exception {
		// �����ʼ����Ϊ5
		BlockingQueue<String> bq = new ArrayBlockingQueue<String>(5);
		// ����10��Ԫ��
		for (int i = 0; i < 10; i++) {
			bq.add("");
		}

	}
}
