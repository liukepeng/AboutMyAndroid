package com.company.section2;


public class Client {
	
	public  void doSomething() {
		//�쳣��Ϣ
		String exceptionMsg = "Ϊ�����쳣�ˣ������;�Ϊ��";
		try {
			Thread.sleep(10);
		} catch (Exception e) {
			//ת��Ϊ�Զ�����������쳣
			throw new MyException(e,exceptionMsg);
		}		
	}	
}

class MyException extends RuntimeException{
	public MyException(Throwable e,String msg){
		
	}
}
