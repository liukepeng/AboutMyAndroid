package co.company.section1;

public class Client {
	public static void main(String[] args) {
		// 不分昼夜的制造垃圾邮件
		while (true) {
			// 多线程多个垃圾邮件制造机
			SpamMachine sm = new SpamMachine();
			// 条件判断，不符合条件线程就设置该线程不可执行
			if (!false) {
				sm.stop();
			}
			// 如果线程是stop状态，则不会启动
			sm.start();
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
