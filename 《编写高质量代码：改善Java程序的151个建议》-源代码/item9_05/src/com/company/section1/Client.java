package com.company.section1;

public class Client {
	public static void main(String[] args) throws InterruptedException {
		//�����߳�
		new TcpServer();
	}
}

class TcpServer implements Runnable {
	//����������
	public TcpServer() {
		Thread t = new Thread(this);
		t.setUncaughtExceptionHandler(new TcpServerExceptionHanlder());
		t.start();
	}

	@Override
	public void run() {
		// ����ҵ������,����3��
		for (int i = 0; i < 3; i++) {
			try {
				Thread.sleep(1000);
				System.out.println("ϵͳ��������:" + i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// �׳��쳣
		throw new RuntimeException();
	}

	// �쳣������
	private static class TcpServerExceptionHanlder implements
			Thread.UncaughtExceptionHandler {
		@Override
		public void uncaughtException(Thread t, Throwable e) {
			// ��¼�߳��쳣��Ϣ
			System.out.println("�߳� " + t.getName() + "�����쳣����������,�����ԭ��");
			e.printStackTrace();
			// �����̣߳���֤ҵ���ж�
			new TcpServer();
		}
	}
}
