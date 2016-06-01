package TestConcurrency22.ThreadPoolExecutor6;

import java.util.Date;
import java.util.concurrent.Callable;

public class Task implements Callable<String> {

	private String name;

	public Task(String name) {
		super();
		this.name = name;
	}

	@Override
	public String call() throws Exception {
		System.out.printf("%s: Starting at : %s   %s\n", name,
				new Date(), Thread.currentThread().getName());
		return "Hello,world";
	}

}
