package thread;

import java.util.Iterator;
import java.util.Map;

public class ThreadEx10 {

	public static void main(String[] args) {

		ThreadGroup main = Thread.currentThread().getThreadGroup();
		ThreadGroup grp1 = new ThreadGroup("Group1");
		ThreadGroup grp2 = new ThreadGroup("Group2");
		
		//ThreadGroup (ThreadGroup parent, String name)
		ThreadGroup subGrp1 = new ThreadGroup(grp1, "subGroup1");
		
		grp1.setMaxPriority(3); // ������ �׷� grp1�� �ִ�켱������ 3���� ����
		
		// Thread(ThreadGroup tg, String name)
		Thread th1 = new Thread(grp1, "th1");
		// Thread(ThreadGroup tg, String name)
		Thread th2 = new Thread(subGrp1, "th2");
		// Thread(ThreadGroup tg, String name)
		Thread th3 = new Thread(grp2, "th3");
		
		th1.start();
		th2.start();
		th3.start();
		
		System.out.println(">>List of ThreadGroup : " + main.getName() + ", Active ThreadGorup : " + main.activeGroupCount() +
				", Active Thread : " + main.activeCount());
		
		main.list();
	}

}
