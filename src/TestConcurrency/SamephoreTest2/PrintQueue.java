package TestConcurrency.SamephoreTest2;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 信号量机制 必须遵循的三个步骤： 首先、必须通过acquire()方法获取信号量； 其次、使用共享资源执行必要的操作；
 * 最后、必须通过release()来释放信号量；
 * 
 * 一个打印队列，它被三个不同的打印机使用；
 * @author Administrator
 *
 */

public class PrintQueue {

	private final Semaphore semaphore;
	private boolean freePrinters[];
	private Lock lockPrinters;

	public PrintQueue() {
		/* 可以更改 计数器大小 */
		this.semaphore = new Semaphore(3);
		freePrinters = new boolean[3];
		for (int i = 0; i < 3; i++) {
			freePrinters[i] = true;
		}
		lockPrinters = new ReentrantLock();
	}

	public void printJob(Object document) {
		try {
			semaphore.acquire();
			int assignedPrinter = getPrinter();

			long duration = (long) (Math.random() * 10);
			System.out
					.printf("%s: PrintQueue: Printing a Job in Priter %d during %d seconds \n",
							Thread.currentThread().getName(), assignedPrinter,
							duration);
			TimeUnit.SECONDS.sleep(duration);
			freePrinters[assignedPrinter] = true;
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaphore.release();
		}
	}

	private int getPrinter() {
		int ret = -1;
		try {
			lockPrinters.lock();
			for (int i = 0; i < freePrinters.length; i++) {
				if (freePrinters[i]) {
					ret = i;
					freePrinters[i] = false;
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lockPrinters.unlock();
		}
		return ret;
	}

}
