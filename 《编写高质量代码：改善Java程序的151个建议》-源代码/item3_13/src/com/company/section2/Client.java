package com.company.section2;


public class Client {
	public static void main(String[] args) {
		//���常��
		Person f = new Person("����");
		//��������
		Person s1 = new Person("�����",f);
		//С���ӵ���Ϣ��ͨ������ӿ�¡������
		Person s2 = s1.clone();
		s2.setName("С����");
		//�ϸɵ�
		s1.setName("�����");
		s1.getFather().setName("�ɵ�");
		
		System.out.println(s1.getName() +" �ĸ����� " + s1.getFather().getName());
		System.out.println(s2.getName() +" �ĸ����� " + s2.getFather().getName());
	}
}

class Person implements Cloneable{
	//����
	private String name;
	//����
	private Person father;
	
	public Person(String _name){
		name = _name;
	}
	
	public Person(String _name,Person _parent){
		name = _name;
		father = _parent;
	}
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Person getFather() {
		return father;
	}


	public void setFather(Person father) {
		this.father = father;
	}

	//��¡��ʵ��
	@Override
	public Person clone(){
		Person p = null;
		try {
			p = (Person) super.clone();
			p.setFather(new Person(p.getFather().getName()));
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return p;
	}
}
