package TestConcurrency.DaemonTest;

import java.util.Date;
import java.util.Deque;

/**
 *  setDaemon(true);
 *   通常，当 同一个应用程序里没有其他的线程运行的时候，守护线程才运行。
 *   当守护线程是程序中唯一运行的程序时,执行结束后，JVM也就结束了这个程序；
 * @author 14073984
 *
 */

public class CleanerTaskTest extends Thread{
	private Deque<Event> deque;
	
	public CleanerTaskTest(Deque<Event> deque) {
		this.deque = deque;
		/* important */
		setDaemon(true);
	}
	
	public void run() {
		while(true) {
			
			Date date = new Date();
			clean(date);
		}
	}
	
	private void clean(Date date) {
		long difference;
		boolean delete;
		if(deque.size() == 0) {
			return;
		}
		delete = false;
		do {
			Event e = deque.getLast();
			difference = date.getTime() - e.getDate().getTime();
			if (difference > 10000) {
				System.out.printf("Cleaner: %s\n", e.getEvent());
				deque.removeLast();
				delete = true;
			}
		} while (difference > 10000);
		if (delete) {
			System.out.printf("Cleaner: Size of the queue: %d\n", deque.size());
		}
	}

}
