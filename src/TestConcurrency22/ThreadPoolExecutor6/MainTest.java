package TestConcurrency22.ThreadPoolExecutor6;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 在执行器中延迟执行任务；
 * ScheduledThreadPoolExecutor 
 * 为了在定时执行器中等待一段给定的时间后执行一个任务，需要使用schedule方法
 * 这个方法接受如下的参数：
 * 即将执行的任务；
 * 任务执行前所要等待的时间；
 * 等待时间的单位，由TimeUnit 类的一个常量 来指定；
 * @author Administrator
 *
 */

public class MainTest {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ScheduledThreadPoolExecutor executor = (ScheduledThreadPoolExecutor) Executors
				.newScheduledThreadPool(1);

		System.out.printf("Main: Starting at : %s\n", new Date());
		for (int i = 0; i < 5; i++) {
			Task task = new Task("Task " + i);
			executor.schedule(task, i + 1, TimeUnit.SECONDS);
		}
		executor.shutdown();

		try {
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.printf("Main: Ends at: %s\n", new Date());
	}

}
