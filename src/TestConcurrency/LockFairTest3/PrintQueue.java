package TestConcurrency.LockFairTest3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 在公平模式中，很多线程在等待锁时，锁将选择他们中的一个来访问临界区，而且选择的是等待时间最长的。
 * 非公平模式中，这种选择没有任何限制。
 * 
 * 所有线程创建的间隔是0.1秒。第一个线程请求锁是 线程0，然后是线程1，以此类推。
 * 当线程0执行第一个加锁的代码块，其余9个线程等待获取这个锁。
 * 当线程0释放了锁， 它立即又请求锁，这个时候就有10个线程试图请求锁。
 * 在公平模式下，Lock 将选择线程1，因为这个线程等待的时间最长。
 * 然后是线程2,线程3，以此类推。
 * 在所有线程都执行完第一个被锁保护的代码块之前，他们都没有执行第二个被所保护的代码块。
 * @author Administrator
 *
 */

public class PrintQueue {
	/* 公平模式 */
//	private final Lock queueLock = new ReentrantLock(true);
	/* 非公平模式 */
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
		
		queueLock.lock();
		try {
			Long duration = (long) (Math.random() * 10000);
			System.out.println(Thread.currentThread().getName()
					+ ": PrintQueue: Printing a job during ++++++" + (duration / 1000)
					+ " seconds");
			Thread.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			queueLock.unlock();
		}

	}
}
