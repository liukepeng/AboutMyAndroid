package com.company.section1;

public class Client {
	public static void main(String[] args) {

		doSports(null);
	}

	public static void doSports(Season season) {
		switch (season) {
		case Spring:
			System.out.println("����ŷ���");
			break;
		case Summer:
			System.out.println("������Ӿ");
			break;
		case Autumn:
			System.out.println("����׽֪��");
			 break;
		case Winter:
			System.out.println("���컬��");
			break;
		default:
			System.out.println("�������");
			break;
		}
	}
}

enum Season {
	Spring, Summer, Autumn, Winter;
}
