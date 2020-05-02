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
	
	public synchronized void withdraw(int money) { // method에 lock을 검
		// 요렇게 객체에 lock을 걸 수도 있음
		// synchronized(this) {
		while(balance < money) { // 잔고가 부족하면
			try { 
				wait();
			} catch (Exception e) {
				
			}
		}
		balance -= money;
		//}
	}
	
	
	// 잔고 증가하는 method
	public synchronized void deposit(int money) {
		balance += money;
		notify();
	}
}

class RunnableEx25 implements Runnable {
	Account2 acc = new Account2();
	
	public void run() {
		while(acc.balance > 0) {
			// 100, 200, 300 중의 한 값을 임의로 선택해 출금
			// 0.0 <= Math.random() < 1.0 범위의 double타입이 값
			// 0*3 <= (int) Math.random() < 1 *3 => 0~2
			int money = (int) (Math.random() * 3 + 1) * 100;
			System.out.println(Thread.currentThread().getName() + " [[[ HJLOG money : " + money);
			acc.withdraw(money);
			System.out.println("balance : " + acc.balance);
		}
		System.out.println("HJLOG 빵원 끝");
	}
}
