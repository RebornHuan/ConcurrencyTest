package TestConcurrency.LockTest;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用 synchronized 关键字时，只能在同一个 synchronized块结构中获取和释放控制。
 * Lock接口允许实现更复杂的临界区结构
 * 控制的获取和释放不出现在同一个块结构中
 * Lock接口允许分离读和写操作，允许多个读线程和只有一个写线程.
 * tryLock（） 线程使用tryLock()不能够获取锁，tryLock()会立即返回（）返回布尔型。true表示获取了锁。，他不会将线程置入休眠，tryLock()。
 * 
 * ReetrantLock 类也允许使用递归调用。如果一个线程获取了锁并且进行了递归调用，它将继续持有这个锁，因此调用lock()后也将立即返回，
 * 并且线程将继续执行递归调用。
 * @author huan
 *
 */

public class PrintQueue {
	private final Lock queueLock = new ReentrantLock();

	public void printJob(Object document) {
		queueLock.lock();
		try {
			Long duration = (long) (Math.random() * 10000);
			System.out.println(Thread.currentThread().getName()
					+ ": PrintQueue: Printing a job during " + (duration / 1000)
					+ " seconds");
			Thread.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			queueLock.unlock();
		}

	}
}
