package com.company.section1;

import java.util.ArrayList;
import java.util.List;

public class Client {
	public static void main(String[] args) throws Exception {
		//�����ʼ����Ϊ5
		List<String> list = new ArrayList<String>(5);		
		//����10��Ԫ��
		for(int i=0;i<10;i++){
			list.add("");
		}
	}
}
