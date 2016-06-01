package TestConcurrency22.ThreadPoolExecutor8;

import java.util.concurrent.Callable;

public class Task implements Callable<String> {

	@Override
	public String call() throws Exception {
		while (true) {
			System.out.printf("Task: test\n");
			Thread.sleep(1000);
		}
		
		/*System.out.printf("Task: test\n");
		Thread.sleep(1000);
		return null;*/
		
	}

}
