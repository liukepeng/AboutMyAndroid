package com.company.section3;
import java.text.NumberFormat;

import static java.lang.Double.*;
import static java.lang.Math.*;
import static java.lang.Integer.*;
import static java.text.NumberFormat.*;

public class Client {
	//����뾶�;���Ҫ�󣬼������
	public static void main(String[] args) {
		double s = PI * parseDouble(args[0]);
		NumberFormat nf = getInstance();
		nf.setMaximumFractionDigits(parseInt(args[1]));		
		formatMessage(nf.format(s));
	}
	
	//��ʽ����Ϣ���
	public static void formatMessage(String s){
		System.out.println("Բ����ǣ�"+s);
	}
}
