package com.company;

import java.util.Random;
/**
 * Ī�ó�����ɱ��� 
 *
 */
public class Client {	
	public static void main(String[] args) {
		System.out.println("�������Ŷ��" + Const.RAND_CONST);
	}
}

/*�ӿڳ���*/
interface Const{
	//�⻹�ǳ�����
	public static final int RAND_CONST = new Random().nextInt();
}