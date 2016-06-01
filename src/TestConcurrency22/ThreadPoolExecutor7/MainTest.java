package TestConcurrency22.ThreadPoolExecutor7;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 在执行器中周期性执行任务；
 * ScheduledThreadPoolExecutor 使用 scheduledAtFixedRate发送任务；
 * 4个参数：
 * 周期性执行任务
 * 任务第一次执行后的延迟时间;
 * 两次任务之间的时间周期
 * 时间单位
 * 
 * 返回一个 ScheduledFuture对象，ScheduledFuture接口则扩展了Future接口,于是它带有了定时任务的相关操作方法
 * ScheduledFuture是一个泛型参数化的接口。任务是Runnable对象，并没有泛型参数化。必须通过？符号
 * 作为参数来泛型化它们
 * getDelay方法返回任务到下一次执行时所要等待的剩余时间。这个方法接收的一个TimeUnit常量作为时间单位
 * 
 * 
 * scheduleWithFixedDelay
 * @author Administrator
 *
 */

public class MainTest {
	public static void main(String[] args) {
		
		ScheduledThreadPoolExecutor executor = (ScheduledThreadPoolExecutor) Executors
				.newScheduledThreadPool(1);
		
		System.out.printf("Main: Starting at: %s\n", new Date());
		
		Task task = new Task("Task");
		ScheduledFuture<?> result = executor.scheduleWithFixedDelay(task, 1, 2,
				TimeUnit.SECONDS);
	/*	ScheduledFuture<?> result = executor.scheduleAtFixedRate(task, 1, 2,
				TimeUnit.SECONDS);*/
		for (int i = 0; i < 10; i++) {
			System.out.printf("Main: Dalay: %d  %s\n", result
					.getDelay(TimeUnit.MILLISECONDS), Thread.currentThread()
					.getName());
			try {
				TimeUnit.MILLISECONDS.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		executor.shutdown();

		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.printf("Main: Finished at: %s\n", new Date());
	}

}
