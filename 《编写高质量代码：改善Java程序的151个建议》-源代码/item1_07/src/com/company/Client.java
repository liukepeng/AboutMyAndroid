package com.company;

/**
 * ��������������
 *
 */
public class Client {
	public static void main(String[] args) {
		int count =0;
		for(int i=0;i<10;i++){
			count=count++;
		}
		System.out.println("count="+count);
	}
}

class Mock{
	public static void main(String[] args) {
		int count =0;
		for(int i=0;i<10;i++){
			count=mockAdd(count);
		}
		System.out.println("count="+count);
	}

	public static int mockAdd(int count){
		//�ȱ����ʼֵ
		int temp =count;
		//����������
		count = count+1;
		//����ԭʼֵ
		return temp;
	}
}
