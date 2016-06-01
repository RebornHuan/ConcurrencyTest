package TestConcurrency22.ThreadPoolExecutor9;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class ResultTask extends FutureTask<String> {

	private String name;

	public ResultTask(Callable<String> callable) {
		super(callable);
		this.name = ((ExecutorTask) callable).getName();
	}

	protected void done() {
		if (isCancelled()) {
			System.out.printf("%s: Has been canceled.\n", name);
		} else {
			System.out.printf("%s: Has finished \n", name);
		}

	}

}
