package co.company.section2;



public class Client {
	public static void main(String[] args) {
		// ������ҹ�����������ʼ�
		while (true) {			
			// �����жϣ������������Ͳ������߳�
			if (!false) {
				// ���̶߳�������ʼ������
				new SpamMachine().start();	
			}		
		}
	}
}

// �����ʼ������
class SpamMachine extends Thread {
	@Override
	public void run() {
		// ���������ʼ�
		System.out.println("������������ʼ�����");
	}
}
