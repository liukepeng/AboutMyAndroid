package com.company.section4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Client {
	public static void main(String[] args) {
		File file = new File("�ļ�.txt");
		//�������ֵ��쳣��������������ж�
		if (file.exists() && !file.isDirectory()) {
			try {
				FileInputStream fis = new FileInputStream(file);
				/* ����ҵ���߼����� */
			} catch (FileNotFoundException e) {
				// �쳣����
			}
		}
	}
}
