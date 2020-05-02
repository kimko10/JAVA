package thread;

public class ThreadEx25 {

	public static void main(String[] args) {
		
		Runnable r = new RunnableEx25();
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);
		
		t1.start();
		t2.start();

	}

}

class Account2{
	int balance = 1000;
	
	public synchronized void withdraw(int money) { // method�� lock�� ��
		// �䷸�� ��ü�� lock�� �� ���� ����
		// synchronized(this) {
		while(balance < money) { // �ܰ� �����ϸ�
			try { 
				wait();
			} catch (Exception e) {
				
			}
		}
		balance -= money;
		//}
	}
	
	
	// �ܰ� �����ϴ� method
	public synchronized void deposit(int money) {
		balance += money;
		notify();
	}
}

class RunnableEx25 implements Runnable {
	Account2 acc = new Account2();
	
	public void run() {
		while(acc.balance > 0) {
			// 100, 200, 300 ���� �� ���� ���Ƿ� ������ ���
			// 0.0 <= Math.random() < 1.0 ������ doubleŸ���� ��
			// 0*3 <= (int) Math.random() < 1 *3 => 0~2
			int money = (int) (Math.random() * 3 + 1) * 100;
			System.out.println(Thread.currentThread().getName() + " [[[ HJLOG money : " + money);
			acc.withdraw(money);
			System.out.println("balance : " + acc.balance);
		}
		System.out.println("HJLOG ���� ��");
	}
}
