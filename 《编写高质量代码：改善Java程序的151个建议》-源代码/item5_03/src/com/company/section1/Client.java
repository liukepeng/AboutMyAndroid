package com.company.section1;

import java.util.Arrays;

import org.apache.commons.lang.builder.ToStringBuilder;

public class Client {

	public static void main(String[] args) {
		//��������
		int ballonNum = 7;
		// ��һ������
		Balloon[] box1 = new Balloon[ballonNum];
		// ��ʼ����һ�������е�����
		for (int i = 0; i < ballonNum; i++) {
			box1[i] = new Balloon(Color.values()[i], i);
		}
		// �ڶ������ӵ�������ͨ��������һ�����ӵ�
		Balloon[] box2 = Arrays.copyOf(box1, box1.length);
		// �޸����һ��������ɫ
		box2[6].setColor(Color.Blue);
		// ��ӡ����һ��������������ɫ
		for (Balloon b:box1) {
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
