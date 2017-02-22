package com.company.section1;

/**
 * 
 * @author Phenix 2011-6-29
 */
public class Client {
	private static class Apple implements Cloneable {
		public Object clone() {
			try {
				return  super.clone();
			} catch (CloneNotSupportedException e) {
				throw new Error();
			}
		}
	}

	public static void main(String[] args) {
		// ѭ��10���
		final int maxLoops = 10 * 10000;
		int loops = 0;
		// ��ʼʱ��
		long start = System.nanoTime();
		// ��ĸ������
		Apple apple = new Apple();
		while (++loops < maxLoops) {
			apple.clone();
		}
		long mid = System.nanoTime();
		System.out.println("clone�������ɶ����ʱ��" + (mid - start) + " ns");
		// new���ɶ���
		while (--loops > 0) {
			new Apple();
		}
		long end = System.nanoTime();
		System.out.println("new���ɶ����ʱ��" + (end - mid) + " ns");
	}
}
