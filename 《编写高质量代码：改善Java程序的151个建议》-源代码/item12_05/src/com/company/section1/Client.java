package com.company.section1;

public class Client {
	public static void main(String[] args) {
		Gun gun = new Handgun();
		gun.shoot();
	}
}

//ǹ
interface Gun {
	// ǹ������ʲô�ģ����ɱ¾��
	public void shoot();
}
//��ǹ
class Handgun implements Gun {
	@Override
	public void shoot() {
		System.out.println("��ǹ���...");
	}
}
//���ǹ
class ToyGun implements Gun {
	@Override
	public void shoot() {
		// ���ǹ�����������������Ͳ�ʵ����
	}
}
