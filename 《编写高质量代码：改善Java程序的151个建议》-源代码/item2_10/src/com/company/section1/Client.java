package com.company.section1;

import java.util.Random;

/**
 *
 *�������������
 * 2011-3-8
 */
public class Client {
	public static void main(String[] args) {
		Random r = new Random();
		for(int i=1;i<4;i++){
			System.out.println("��"+i+"�Σ�"+r.nextInt());
		}
	}
}
