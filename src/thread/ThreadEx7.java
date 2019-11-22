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
		System.out.println("10초 안에 값을 입력해야 합니다.");
		String input = JOptionPane.showInputDialog("아무 값이나 입력하세요.");
		ThreadEx7.inputCheck = true;
		System.out.println("입력값은 " + input + "입니다.");
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
		
		System.out.println("10초 동안 값이 입력되지 않아 종료합니다.");
		System.exit(0);
	}
}