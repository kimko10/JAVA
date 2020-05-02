package thread;

public class ThreadEx24 {

	public static void main(String[] args) {
		
		Runnable r = new RunnableEx24();
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);
		
		t1.start();
		t2.start();

	}

}

class Account{
	int balance = 1000;
	
	public synchronized void withdraw(int money) { // method�� lock�� ��
		// �䷸�� ��ü�� lock�� �� ���� ����
		// synchronized(this) {
		if(balance >= money) {
			try { 
				System.out.println("HJLOG Thread N : " + Thread.currentThread().getName());
				Thread.sleep(1000); // �Ϻη� �� �κп� �ͼ� �ٸ� ������� ������� �ѱ�� ���� �־��� �κ�
			} catch (Exception e) {
				
			}
			balance -= money;
		}
		//}
	}
}

class RunnableEx24 implements Runnable {
	Account acc = new Account();
	
	public void run() {
		while(acc.balance > 0) {
			// 100, 200, 300 ���� �� ���� ���Ƿ� ������ ���
			// 0.0 <= Math.random() < 1.0 ������ doubleŸ���� ��
			// 0*3 <= (int) Math.random() < 1 *3 => 0~2
			int money = (int) (Math.random() * 3 + 1) * 100;
			acc.withdraw(money);
			System.out.println("balance : " + acc.balance);
		}
	}
}
