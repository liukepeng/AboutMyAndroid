package com.company.section2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;

public class Client {

	public static void main(String[] args) {
		//��������
		int ballonNum = 7;
		// ��һ������
		List<Balloon> box1 = new ArrayList<Balloon>();
		// ��ʼ����һ�������е�����
		for (int i = 0; i < ballonNum; i++) {
			box1.add(new Balloon(Color.values()[i], i));
		}
		//ת��Ϊ����
		Balloon[] b1 = new Balloon[box1.size()];
		box1.toArray(b1);	
		//������ת��ΪList	
		List<Balloon> box2 = Arrays.asList(b1);
		//�޸�����ԭɫ
		box2.get(6).setColor(Color.Blue);
		//������һ�����ӵ�����
		for(Balloon b:box1){
			System.out.println(b);
		}
	}
}

// ������ɫ
enum Color {
	Red, Orange, Yellow, Green, Indigo, Blue, Violet;
}

// ����
class Balloon {
	// ���
	private int id;
	// ��ɫ
	private Color color;

	public Balloon(Color _color, int _id) {
		color = _color;
		id = _id;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	//apache-common���µ�ToStringBuilder��дtoString����
	public String toString() {
		return new ToStringBuilder(this)
				.append("���", id)
				.append("��ɫ", color)
				.toString();
	}
}
