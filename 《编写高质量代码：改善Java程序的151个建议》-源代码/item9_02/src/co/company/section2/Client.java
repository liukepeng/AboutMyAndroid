package co.company.section2;



public class Client {
	public static void main(String[] args) {
		// 不分昼夜的制造垃圾邮件
		while (true) {			
			// 条件判断，不符合条件就不创建线程
			if (!false) {
				// 多线程多个垃圾邮件制造机
				new SpamMachine().start();	
			}		
		}
	}
}

// 垃圾邮件制造机
class SpamMachine extends Thread {
	@Override
	public void run() {
		// 制造垃圾邮件
		System.out.println("制造大量垃圾邮件……");
	}
}
