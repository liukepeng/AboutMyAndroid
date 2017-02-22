package com.company.section1;

public class Client {

}


interface User{
	//修改用户名密码，抛出安全异常
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



