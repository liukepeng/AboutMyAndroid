package com.company.section1;

import java.util.Arrays;

public class Client {

	public static void main(String[] args) {
		//һ���༶�������60��ѧ��
		Stu[] classes = new Stu[60];
		/*classes��ʼ�� ����*/
		
		//ż��һ���༶��������80�ˣ�����ӳ�
		classes = expandCapacity(classes,80);
		/*���³�ʼ�������޶��20�ˡ���*/
	}
	
	//�ӳ�����
	public static <T> T[]  expandCapacity(T[] datas, int newLen) {
		// �������Ǹ�ֵ
		newLen = newLen<0?0:newLen;
		// ����һ�������飬������ԭֵ		
		return Arrays.copyOf(datas, newLen);		
	}
}

class Stu{
	
}