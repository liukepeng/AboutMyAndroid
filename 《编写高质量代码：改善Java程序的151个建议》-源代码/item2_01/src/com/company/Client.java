package com.company;

import java.util.Scanner;
/**
 * 
 * ȫ�濼����ż���ж�
 *
 */

public class Client {
	public static void main(String[] args) {
		//���ռ����������
		Scanner input = new Scanner(System.in);
		System.out.print("�������������ж���ż��");
		while(input.hasNextInt()){
			int i = input.nextInt();
			String str =i+ "->" + (i%2 ==1?"����":"ż��");
			System.out.println(str);
			
		}
	}
}

class MockUtils{
	//ģ��ȡ�����,dividend��������divisor����
	public static int remainder(int dividend,int divisor){
		return dividend - dividend / divisor * divisor;
	}
}
