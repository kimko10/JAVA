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
	
	public synchronized void withdraw(int money) { // method에 lock을 검
		// 요렇게 객체에 lock을 걸 수도 있음
		// synchronized(this) {
		if(balance >= money) {
			try { 
				System.out.println("HJLOG Thread N : " + Thread.currentThread().getName());
				Thread.sleep(1000); // 일부러 이 부분에 와서 다른 쓰레드로 제어권을 넘기기 위해 넣어준 부분
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
			// 100, 200, 300 중의 한 값을 임의로 선택해 출금
			// 0.0 <= Math.random() < 1.0 범위의 double타입이 값
			// 0*3 <= (int) Math.random() < 1 *3 => 0~2
			int money = (int) (Math.random() * 3 + 1) * 100;
			acc.withdraw(money);
			System.out.println("balance : " + acc.balance);
		}
	}
}
