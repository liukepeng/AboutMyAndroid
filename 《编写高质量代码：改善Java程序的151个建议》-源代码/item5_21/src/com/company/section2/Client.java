package com.company.section2;

import java.util.ArrayList;
import java.util.List;

public class Client {
	
	public static void main(String[] args) {
		//��Ʊ�б�
		final List<String> tickets = new ArrayList<String>();
		//��ʼ��Ʊ�ݳ�
		for(int i=0;i<100000;i++){
			tickets.add("��Ʊ" + i);
		}
		//10��������Ʊ
		for(int i=0;i<10;i++){
			new Thread(){
				public void run() {
					while(true){
						System.out.println(Thread.currentThread().getId() +"����"+ tickets.remove(0));
					}
				};
			}.start();
		}
		
		
	}
}
