package thread;

import javax.swing.JOptionPane;


public class ThreadEx7 {

	static Boolean inputCheck = false;

	public static void main(String[] args) {
		ThreadEx7_1 th1 = new ThreadEx7_1();
		ThreadEx7_2 th2 = new ThreadEx7_2();
		th1.start();
		th2.start();
	}
}

class ThreadEx7_1 extends Thread {
	public void run() {
		System.out.println("10�� �ȿ� ���� �Է��ؾ� �մϴ�.");
		String input = JOptionPane.showInputDialog("�ƹ� ���̳� �Է��ϼ���.");
		ThreadEx7.inputCheck = true;
		System.out.println("�Է°��� " + input + "�Դϴ�.");
	}
}

class ThreadEx7_2 extends Thread {
	public void run() {
		for(int i=9;i>=0;i--) {
			if(ThreadEx7.inputCheck) return;
			System.out.println(i);
		}
		try {
			sleep(10000);
		} catch(InterruptedException e) {}
		
		System.out.println("10�� ���� ���� �Էµ��� �ʾ� �����մϴ�.");
		System.exit(0);
	}
}