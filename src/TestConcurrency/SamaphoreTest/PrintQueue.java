package TestConcurrency.SamaphoreTest;

import java.util.concurrent.Semaphore;

/**
 * 信号量机制
 * 必须遵循的三个步骤：
 * 首先、必须通过acquire()方法获取信号量；
 * 其次、使用共享资源执行必要的操作；
 * 最后、必须通过release()来释放信号量；
 * @author Administrator
 *
 */

public class PrintQueue {
	private final Semaphore semaphore;

	public PrintQueue() {
		/*可以更改 计数器大小*/
		this.semaphore = new Semaphore(3);
	}

	public void printJob(Object document) {
		try {
			semaphore.acquire();
			long duration = (long) (Math.random() * 10);
			System.out.printf(
					"%s: PrintQueue: Printing a Job during %d seconds \n",
					Thread.currentThread().getName(), duration);
			Thread.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaphore.release();
		}
	}

}
