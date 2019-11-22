package thread;

// 쓰레드 우선순위
// 우선순위 1 ~ 10 숫자가 높을 수록 높은 우선순위
public class ThreadEx9 {

	public static void main(String[] args) {
		// main 메소드에서 생성한 쓰레드는 메인메서드 쓰레드 순서가 5인 main 메서드의 우선순위를 그대로 상속됨
		ThreadEx9_1 th1 = new ThreadEx9_1();
		ThreadEx9_2 th2 = new ThreadEx9_2();
		
		th2.setPriority(7); // th2의 우선순위를 7로 바꿔줌
		
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
			for(int x=0;x<10000000;x++); // 작업을 지연시키기 위한 for문
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
