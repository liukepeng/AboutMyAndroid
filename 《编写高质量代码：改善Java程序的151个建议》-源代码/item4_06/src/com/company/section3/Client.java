package com.company.section3;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Client {
	public static void main(String[] args) {
		//���ռ�������
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			String str = input.nextLine();
			//������ʽ����
			Pattern pattern = Pattern.compile("\\b");
			//����ƥ����
			Matcher matcher = pattern.matcher(str);
			//��¼��������
			int wordsCount = 0;
			//��������ƥ�䣬ͳ�Ƶ�������
			while (matcher.find()) {
				System.out.println(matcher.group());
				wordsCount++;
			}
			System.out.println(str + " ��������" + wordsCount);
		}
	}
}
