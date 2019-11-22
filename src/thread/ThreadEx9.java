package thread;

// ������ �켱����
// �켱���� 1 ~ 10 ���ڰ� ���� ���� ���� �켱����
public class ThreadEx9 {

	public static void main(String[] args) {
		// main �޼ҵ忡�� ������ ������� ���θ޼��� ������ ������ 5�� main �޼����� �켱������ �״�� ��ӵ�
		ThreadEx9_1 th1 = new ThreadEx9_1();
		ThreadEx9_2 th2 = new ThreadEx9_2();
		
		th2.setPriority(7); // th2�� �켱������ 7�� �ٲ���
		
		System.out.println("Priority of th1(-) : " + th1.getPriority());
		System.out.println("Priority of th2(|) : " + th2.getPriority());
		
		th1.start();
		th2.start();

	}

}

class ThreadEx9_1 extends Thread {
	public void run() {
		for(int i=0;i<300;i++) {
			System.out.print("-");
			for(int x=0;x<10000000;x++); // �۾��� ������Ű�� ���� for��
		}
	}
}

class ThreadEx9_2 extends Thread {
	public void run() {
		for(int i=0;i<300;i++) {
			System.out.print("|");
			for(int x=0;x<10000000;x++);
		}
	}
}
