package TestConcurrency.ThreadGroupTest;

import java.util.concurrent.TimeUnit;

/**
 * 可以控制，不管多少线程在运行，只需要一个单一的调用，所有这些线程的运行都会被中断；
 * 可以模仿查询；
 * @author Administrator
 *
 */
public class MainTest {
	public static void main(String[] args) {
		ThreadGroup threadGroup = new ThreadGroup("searcher");
		Result result = new Result();
		SearchTask searchTask = new SearchTask(result);
		for (int i = 0; i < 5; i++) {
			Thread thread = new Thread(threadGroup, searchTask);
			thread.start();
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.printf("Number of Threads: %d\n", threadGroup.activeCount());
		System.out.printf("Information about the Thread Group \n");
		threadGroup.list();

		Thread[] threads = new Thread[threadGroup.activeCount()];
		threadGroup.enumerate(threads);
		for (int i = 0; i < threadGroup.activeCount(); i++) {
			System.out.printf("Thread %s: %s\n", threads[i].getName(),
					threads[i].getState());
		}
		
		waitFinish(threadGroup);
		
		threadGroup.interrupt();

	}
	
	private static void waitFinish(ThreadGroup threadGroup) {
		System.out.printf("++++++++++++"+threadGroup.activeCount());
		while (threadGroup.activeCount()>3) {
			try {
				TimeUnit.SECONDS.sleep(1);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
