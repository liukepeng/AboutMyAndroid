package com.company.section;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Client {
	public static void main(String[] args) {
		int tagCloudNum = 10;
		List<String> tagClouds = new ArrayList<String>(tagCloudNum);
		//��ʼ����ǩ�ƣ�һ���Ǵ����ݿ����
		for (int i = 0; i < tagCloudNum; i++) {
			tagClouds.add("��ǩ" + i);
		}
		//����˳��
		Random rand = new Random();
		for(int i=0;i<tagCloudNum;i++){
			//ȡ�����λ��
			int randomPosition = rand.nextInt(tagCloudNum);
			//��ǰԪ�������Ԫ�ؽ���
			String temp = tagClouds.get(i);
			tagClouds.set(i, tagClouds.get(randomPosition));
			tagClouds.set(randomPosition, temp);
		}
		//���
		for(String tag:tagClouds){
			System.out.println(tag);
		}

	}
}
