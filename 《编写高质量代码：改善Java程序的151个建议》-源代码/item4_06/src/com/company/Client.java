package com.company;

import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		//���ռ�������
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String str = input.nextLine();
			//ʹ��split�����ָ���ͳ��
			int wordsCount = str.split(" ").length;
			System.out.println(str + " ��������" + wordsCount);
		}
	}
}
