package com.company.section2;

import java.io.IOException;

public class Client {
	public static void main(String[] args) {
		try{
			Base base = new Base();
		}catch(IOException e){
			//�쳣����
		}
	}
}

class Base{
	//�����׳�IOException
	public Base() throws IOException{
		throw new IOException();
	}
	//���෽���׳�Exception
	public void method() throws Exception{
		
	}
}

class Sub extends Base{
	//�����׳�Exception�쳣
	public Sub() throws Exception {
	}
	//���෽�����쳣���ͱ����Ǹ�д������������
	@Override
	public void method() throws IOException{
		
	}
}
