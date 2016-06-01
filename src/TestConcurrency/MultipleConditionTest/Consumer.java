package TestConcurrency.MultipleConditionTest;

import java.util.Random;

/**
 * 当线程调用条件的await方法时，它将自动释放这个条件绑定的锁，
 * 其他某个线程才可以获取这个锁并且执行相同的操作，或者执行这个锁保护的另一个临界区代码。
 * @author huan
 *
 */

public class Consumer implements Runnable {

	private Buffer buffer;

	public Consumer(Buffer buffer) {
		this.buffer = buffer;
	}

	@Override
	public void run() {
		while (buffer.hasPendingLines()) {
			String line = buffer.get();
			/* 可以查看 睡 和不睡 的区别 */
			processLine(line);
		}
	}

	private void processLine(String line) {
		try {
			Random random = new Random();
			Thread.sleep(random.nextInt(100));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
