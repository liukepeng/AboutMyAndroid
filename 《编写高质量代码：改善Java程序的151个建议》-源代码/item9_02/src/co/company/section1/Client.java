package co.company.section1;

public class Client {
	public static void main(String[] args) {
		// ������ҹ�����������ʼ�
		while (true) {
			// ���̶߳�������ʼ������
			SpamMachine sm = new SpamMachine();
			// �����жϣ������������߳̾����ø��̲߳���ִ��
			if (!false) {
				sm.stop();
			}
			// ����߳���stop״̬���򲻻�����
			sm.start();
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
