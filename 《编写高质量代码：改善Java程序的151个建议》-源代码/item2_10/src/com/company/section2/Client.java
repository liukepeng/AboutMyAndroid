package com.company.section2;

import java.util.Random;

/**
 *
 * �����˹̶����ӵ������
 * 2011-3-8
 */
public class Client {
	public static void main(String[] args) {
		Random random = new Random(10000);
		for(int i=1;i<4;i++){
			System.out.println("��"+i+"�Σ�"+random.nextInt());
		}
	}
}
