package com.company.section3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Client {
	public static void main(String[] args) {
		int tagCloudNum = 10;
		List<String> tagClouds = new ArrayList<String>(tagCloudNum);
		//��ʼ����ǩ�ƣ�һ���Ǵ����ݿ����
		for (int i = 0; i < tagCloudNum; i++) {
			tagClouds.add("��ǩ" + i);
		}
		//����˳��
		Collections.shuffle(tagClouds);
		for(String tag:tagClouds){
			System.out.println(tag);
		}
	}
}
