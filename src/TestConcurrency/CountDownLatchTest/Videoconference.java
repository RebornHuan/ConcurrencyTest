package TestConcurrency.CountDownLatchTest;

import java.util.concurrent.CountDownLatch;

/**
 * 等待多个并发事件的完成；
 *   CountDownLacth类. 
 *   在完成一组正在其它线程中执行的操作之前，它允许线程一直等待。
 *   需要调用await方法，这个方法让线程进入休眠直到等待的所有操作都完成；
 *   当某个操作完成后，它将调用 CountDown 将 内部计数器减1.当计数器为0时，
 *   CountDownLatch将唤醒所有调用await()进入休眠的线程；
 *   
 * @author Administrator
 *
 */

public class Videoconference implements Runnable {

	private final CountDownLatch controller;

	public Videoconference(int number) {
		this.controller = new CountDownLatch(number);
	}

	public void arrive(String name) {
		System.out.printf("%s has arrived  ", name);
		controller.countDown();
		System.out.printf("Videoconference: Waiting for %d participants. \n",
				controller.getCount());

	}

	@Override
	public void run() {
		System.out.printf(
				"Videoconference: Initialization: %d participants.\n",
				controller.getCount());
		try {
			controller.await();
			System.out
					.printf("Videoconference: All the participants have come \n");
			System.out.printf("Videoconference: Let's start ...\n");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
