package TestConcurrency.SynchronizedTest3;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * java 在Object 类中提供了wait(),notify(),notifyAll()方法。线程只能在同步代码块中调用wait方法。
 * 当一个线程调用wait方法时，JVM将这个线程置入休眠，并且释放控制这个同步代码块的对象
 * 同时允许其他线程执行这个对象控制的其他的同步代码块。
 * 为了唤醒这个线程，必须在这个对象控制的某个同步代码块中调用notify或者notifyAll 方法。
 * 唤醒之后，还是要先判断是否满足条件
 * 必须在while 循环中调用wait方法，并且不断查询while条件，直到条件为真才会 继续；
 * @author Administrator
 *
 */

public class EventStorage {
	private int maxSize;
	private List<Date> storage;

	public EventStorage() {
		maxSize = 10;
		storage = new LinkedList<Date>();
	}

	public synchronized void set() {
		while (storage.size() == maxSize) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		storage.add(new Date());
		System.out.printf("Set: %d\n", storage.size());
		notifyAll();
	}

	public synchronized void get() {
		while (storage.size() == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.printf("Get: %d : %s\n", storage.size(),
				((LinkedList<?>) storage).poll());
		notifyAll();
	}

}
