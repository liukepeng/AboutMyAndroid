package com.company.section1;

public class Client {
	
}
//ͨѶЭ��
interface Connection {
	// ��ͨ�绰
	public void dial(String phoneNumber);

	// ͨ����ϣ��ҵ绰
	public void hangup();

}
//���ݴ���
interface Transfer {
	// ͨ��
	public void chat(Object o);
}

//class Phone implements Connection,Transfer{
//	
//}