package TestConcurrency22.ThreadPoolExecutor7;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Task implements Runnable {

	private String name;

	public Task(String name) {
		super();
		this.name = name;
	}

	@Override
	public void run() {
		System.out.printf("%s: Starting at: %s  %s\n", name, new Date(), Thread
				.currentThread().getName());
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
