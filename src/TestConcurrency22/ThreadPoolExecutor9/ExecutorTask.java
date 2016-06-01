package TestConcurrency22.ThreadPoolExecutor9;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * 在执行器中控制任务的完成
 * FutureTask 类提供了一个名为done的方法。运行在执行器中的任务执行结束后，还可以执行一些代码。
 * 这个方法可以被用来执行一些后期处理操作
 * 
 * 比如：产生报表。通过邮件发送结果或释放一些系统资源；
 * 当任务完成是受FutureTask类控制时，这个方法在内部被FutureTask 类调用。
 * 在任务结果设置后以及任务状态改变为isDone 后，无论任务是否被取消或者正常结束，done 都会被调用。
 * 默认情况done方法的实现为 空。我们可以覆盖futureTask 类并 实现done 方法来改变这种行为；
 * @author Administrator
 *
 */

public class ExecutorTask implements Callable<String> {

	private String name;

	public ExecutorTask(String name) {
		super();
		this.name = name;
	}

	@Override
	public String call() throws Exception {
		try {
			long duration = (long) (Math.random() * 10);
			System.out.printf("%s: Waiting %d seconds for result.\n",
					this.name, duration);
			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException e) {
			System.out.printf("++++++++ %s\n", this.name);
			e.printStackTrace();
		}

		return "Hello, world. I'm " + name;
	}

	public String getName() {
		return name;
	}

}
