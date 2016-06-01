package TestConcurrency22.ThreadPoolExecutor8;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 在执行器取消任务：
 * 取消一个已经发送给执行器的任务，可以使用Future接口的cancel方法。
 * ： 如果任务已经完成，或者之前已经被取消，或者由于某种原因而不能取消，那么方法将false 并且任务也不能取消
 * ：如果任务在执行器中等待分配Thread对象来执行它 ，那么任务被取消，并且不会开始执行。
 * 如果任务已经在运行，那么它依赖调用cancel 方法时所传递的参数
 * 如果传递的参数是true 并且任务正在运行，那么任务将会取消
 * 如果传递的参数是false 并且任务正在运行。那么任务不会被取消。
 * @author Administrator
 *
 */

public class MainTest {
	public static void main(String[] args) {
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors
				.newCachedThreadPool();
		Task task = new Task();
		System.out.printf("Main: Executing the Task \n");
		Future<String> result = executor.submit(task);

		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("Main: Canceling the Task \n");
//		result.cancel(false);
		result.cancel(true);

		System.out.printf("Main: Cancelled: %s\n", result.isCancelled());
		System.out.printf("Main: Done: %s\n", result.isDone());

		executor.shutdown();

		System.out.printf("Main: The executor has finished");

	}

}
