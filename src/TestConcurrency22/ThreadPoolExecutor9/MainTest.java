package TestConcurrency22.ThreadPoolExecutor9;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MainTest {
	public static void main(String[] args) {
		ExecutorService executor = (ExecutorService) Executors
				.newCachedThreadPool();
		ResultTask resultTasks[] = new ResultTask[5];
		for (int i = 0; i < 5; i++) {
			ExecutorTask executorTask = new ExecutorTask("Task " + i);

			resultTasks[i] = new ResultTask(executorTask);
			executor.submit(resultTasks[i]);
		}

		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.printf("+++++++++\n");

		for (int i = 0; i < 5; i++) {
			resultTasks[i].cancel(true);
		}

/*		for (int i = 0; i < resultTasks.length; i++) {
			try {
				if (!resultTasks[i].isCancelled()) {
					System.out.printf("%s\n", resultTasks[i].get());
				}
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}*/
		executor.shutdown();
	}
}
