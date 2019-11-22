package thread;

// 하나의 쓰레드가 여러 작업을 하는 예제
public class ThreadEx4 {

	public static void main(String args[]) {
		long startTime = System.currentTimeMillis();
		for(int i=0; i<300; i++) {
			System.out.print("-");
		}
		System.out.println("소요시간1:" + (System.currentTimeMillis()-startTime));
		
		for(int i=0; i<300; i++) {
			System.out.print("|");
		}
		
		System.out.println("소요시간2:" + (System.currentTimeMillis()-startTime));
	}
}
