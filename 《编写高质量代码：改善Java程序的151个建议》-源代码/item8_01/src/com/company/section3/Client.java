package com.company.section3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Client {
	public static void main(String[] args) {
		try {
			doStuff();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void doStuff() throws MyException {
		List<Throwable> list = new ArrayList<Throwable>();
		// ��һ���߼�Ƭ��
		try {
			// Do Something
		} catch (Exception e) {
			
			list.add(e);
		}
		// �ڶ����߼�Ƭ��
		try {
			// Do Something
		} catch (Exception e) {
			list.add(e);
		}

		if (list.size() > 0) {
			throw new MyException(list);
		}

	}
}

class MyException extends Exception {
	// �������е��쳣
	private List<Throwable> causes = new ArrayList<Throwable>();

	// ���캯��������һ���쳣�б�
	public MyException(List<? extends Throwable> _causes) {
		causes.addAll(_causes);
	}

	// ��ȡ���е��쳣
	public List<Throwable> getExceptions() {
		return causes;
	}
}
