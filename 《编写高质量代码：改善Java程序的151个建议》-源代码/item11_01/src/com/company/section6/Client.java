package com.company.section6;

import java.util.HashMap;
import java.util.Map;

import com.google.common.base.Joiner;

public class Client {
	public static void main(String[] args) {
		//�������ӷ���
		Joiner joiner = Joiner.on("��");
		//�������Ӷ�����󣬲�������String;�����null��������
		String str = joiner.skipNulls().join("��","Guava�ܲ���ġ�");
		System.out.println(str);
		Map<String,String> map = new HashMap<String,String>();
		map.put("����","��ͨԱ��");
		map.put("����","�쵼");
		System.out.println("��ͨ�����"+map);
		//��ֵ֮����"�ǡ����ӣ������ֵ�Կո�ָ�
		System.out.println(Joiner.on("\r\n").withKeyValueSeparator(" �� ").join(map));
	}
}
