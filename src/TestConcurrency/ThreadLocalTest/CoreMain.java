package TestConcurrency.ThreadLocalTest;

import java.util.concurrent.TimeUnit;

/**
 * 如果创建的对象是实现了Runnable 接口的 类的实例
 * 用它作为传入参数创建多个线程对象并启动这些线程，
 * 所有的线程将共享相同的属性。
 * @author Administrator
 *
 */

public class CoreMain {
	public static void main(String[] args) {
//		SafeTask task = new SafeTask();
		UnsafeTask task = new UnsafeTask();
		for (int i = 0; i < 10; i++) {
			Thread thread = new Thread(task);
			thread.start();
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
}
