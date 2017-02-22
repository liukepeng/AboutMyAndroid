package com.company.section1;

import java.util.ArrayList;
import java.util.List;


public class Client {
	//��������ִ�е�ѭ������
	private static final int LOOP_NUM = 100000;
	public static void main(String[] args) {
		int[] score = new int[100];
		//��ʼ��������б�
		List<Integer> list = new ArrayList<Integer>(100);
		for(int i=0;i<score.length;i++){
			score[i] = i;
			list.add(i);
		}
		//������������
		long begin = System.currentTimeMillis();
		for(int i=0;i<LOOP_NUM;i++){
			sum(score);
		}
		long end = System.currentTimeMillis();
		System.out.println("����(Array)ִ��ʱ�䣺" +(end - begin) + " ms");
		
		//�����б�ִ��ʱ��
		for(int i=0;i<LOOP_NUM;i++){
			sum(list);
		}	
		System.out.println("�б�(List)ִ��ʱ�䣺"  +(System.currentTimeMillis() - end)+ " ms");

	}
	//���������
	public static int sum(int[] datas){
		int sum =0;
		for(int i=0;i<datas.length;i++){
			sum +=datas[i];
		}
		return sum;
	}
	
	//���б���ͼ���
	public static int sum(List<Integer> datas){
		int sum =0;
		for(int i=0;i<datas.size();i++){
			sum +=datas.get(i);
		}
		return sum;
	}
}
