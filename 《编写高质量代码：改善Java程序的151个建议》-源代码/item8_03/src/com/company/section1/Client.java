package com.company.section1;

public class Client {

}


interface User{
	//�޸��û������룬�׳���ȫ�쳣
	public void changePassword() throws MySecurityException,RejectChangeException;
}

class UserImpl implements User{
	
	@Override
	public void changePassword() throws MySecurityException{
		
	}
}


class MySecurityException extends Exception{
	
}

class RejectChangeException extends Exception{
	
}



