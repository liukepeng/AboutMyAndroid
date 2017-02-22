package com.company.section1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Client {
	static class Runner implements Callable<Integer> {
		//��ʼ�ź�
		private CountDownLatch begin;
		//�����ź�
		private CountDownLatch end;

		public Runner(CountDownLatch _begin, CountDownLatch _end) {
			begin = _begin;
			end = _end;
		}

		@Override
		public Integer call() throws Exception {
			// �ܲ��ĳɼ�
			int score = new Random().nextInt(25);
			// �ȴ�����ǹ����
			begin.await();
			// �ܲ��С���
			TimeUnit.MILLISECONDS.sleep(score);
			// �ܲ����Ѿ�����ȫ��
			end.countDown();
			return score;
		}
	}

	public static void main(String[] args) throws Exception {
		//�μ���������
		int num = 10;
		// ����ǹֻ��һ��
		CountDownLatch begin = new CountDownLatch(1);
		// �����ܲ��ж��
		CountDownLatch end = new CountDownLatch(num);
		// ÿ���ܲ���һ���ܵ�
		ExecutorService es = Executors.newFixedThreadPool(num);
		// ��¼�����ɼ�
		List<Future<Integer>> futures = new ArrayList<Future<Integer>>();
		// �ܲ��߾�λ�������̴߳��ڵȴ�״̬
		for (int i = 0; i < num; i++) {
			futures.add(es.submit(new Runner(begin, end)));
		}
		// ����ǹ�죬�ܲ��߿�ʼ�ܲ�
		begin.countDown();
		// �ȴ������ܲ�������ȫ��
		end.await();
		int count = 0;
		// ͳ���ܷ�
		for (Future<Integer> f : futures) {
			count += f.get();
		}
		System.out.println("ƽ������Ϊ��" + count / num);
	}
}
