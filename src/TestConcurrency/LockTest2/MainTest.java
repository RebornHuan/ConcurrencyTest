package TestConcurrency.LockTest2;

/**
 * 使用读操作锁时可以运行多个线程同时访问；
 * 使用写操作锁时只允许一个线程进行。
 * 在一个线程执行写操作时，其他线程不能够执行读操作。
 * @author Administrator
 *
 */

public class MainTest {
	public static void main(String[] args) {
		PricesInfo pricesInfo = new PricesInfo();
		Reader readers[] = new Reader[5];
		Thread threadsReaders[] = new Thread[5];
		for (int i = 0; i < 5; i++) {
			readers[i] = new Reader(pricesInfo);
			threadsReaders[i] = new Thread(readers[i]);
		}

		Writer writer = new Writer(pricesInfo);
		Thread threadWriter = new Thread(writer);

		for (int i = 0; i < 5; i++) {
			threadsReaders[i].start();
		}
		threadWriter.start();
	}

}
