package com.company.section1;

public class Client {
	public static void main(String[] args) {
		while(true){
			Person p = new Person(17);
			p.seeMovie();
		}

		/*�������߼�����*/
	}
}

class Person{
	public Person(int _age){
		//����18����û������ܽ���
		if(_age<18){
			//throw new RuntimeException("����������18�ꡣ");
		}		
	}
	//�����Ƽ��ĵ�Ӱ
	public void seeMovie(){
		System.out.println("�����Ƽ���Ӱ");
	}
}
