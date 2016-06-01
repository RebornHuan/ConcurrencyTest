package TestConcurrency.FileClockTest;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 线程的休眠和恢复；
 * 在sleep的这段时间呢，线程不会占用计算机的任何资源
 * 当它继续执行的cpu时钟来临时，JVM会选中它继续执行；
 * 休眠中线程被中断
 * 该方法立即抛出InterruptedException 而不需要等待到线程休眠时间的结束
 * @author 14073984
 *
 */

public class FileClockTest implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.printf("%s\n"+i, new Date());

			try {
				TimeUnit.SECONDS.sleep(1);
				System.out.println("======================");
			} catch (InterruptedException e) {
				System.out.printf("The FileClockTest has been interrupted");
//				return;       //可以尝试 加不加这个的不同；一个是立刻返回 ，一个虽然捕获了异常 还是等待 线程结束返回;
			}
		}
	}

	public static void main(String[] args) {
		FileClockTest clock = new FileClockTest();
		Thread thread = new Thread(clock);

		thread.start();

		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		thread.interrupt();
	}

}
