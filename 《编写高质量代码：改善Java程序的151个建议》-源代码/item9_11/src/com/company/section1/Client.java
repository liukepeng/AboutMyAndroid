package com.company.section1;


public class Client {

	public static void main(String[] args) {
		new Thread(new Foo()).start();
	}

}

class Foo implements Runnable{
	@Override
	public void run(){
		//ִ�еݹ麯��
		fun(10);
	}
	//�ݹ麯��
	public synchronized void fun(int i) {
		if (--i > 0) {
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println(i);
			fun(i);
		}
	}
}
