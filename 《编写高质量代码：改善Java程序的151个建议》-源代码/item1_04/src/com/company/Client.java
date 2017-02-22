package com.company;

import java.text.NumberFormat;
/**
 * 
 * ����4��������䳤�����ķ���������
 *
 */
public class Client {
	
	//���ۿۼ���
	public void calPrice(int price,int discount){
		float knockdownPrice =price * discount / 100.0F;
		System.out.println("���ۿۺ�ļ۸��ǣ�"+formateCurrency(knockdownPrice));
	}
	
	//���Ӷ��ۿۼ���
	public void calPrice(int price,int... discounts){
		float knockdownPrice = price;
		for(int discount:discounts){
			knockdownPrice = knockdownPrice * discount / 100;
		}
		System.out.println("�����ۿۺ�ļ۸��ǣ�" +formateCurrency(knockdownPrice));
	}
	
	//��ʽ���ɱ��ػ�����ʽ
	private String formateCurrency(float price){
		return NumberFormat.getCurrencyInstance().format(price/100);
	}
	
	public static void main(String[] args) {
		Client client = new Client();
		//499Ԫ�Ļ����75��
		client.calPrice(49900, 75);
	}
}
