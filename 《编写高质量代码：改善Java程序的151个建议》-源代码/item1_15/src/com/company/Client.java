package com.company;
/**
 * 
 *��������ϰ�ߣ�break��������
 *
 */
public class Client {

	public static void main(String[] args) {
		System.out.println("2 = "+toChineseNumberCase(2));
	}
	
	//�Ѱ��������ַ�������Ĵ�д����
	public static String toChineseNumberCase(int n) {
		String chineseNumber = "";
		switch (n) {
		case 0:chineseNumber = "��";
		case 1:chineseNumber = "Ҽ";
		case 2:chineseNumber = "��";
		case 3:chineseNumber = "��";
		case 4:chineseNumber = "��";
		case 5:chineseNumber = "��";
		case 6:chineseNumber = "½";
		case 7:chineseNumber = "��";
		case 8:chineseNumber = "��";
		case 9:chineseNumber = "��";
		}
		return chineseNumber;
	}
}
