package TestConcurrency.ExchangerTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

/**
 * 并发任务间的数据交换
 *  Exchanger类
 *  Exchanger类 允许在两个线程之间定义同步点。
 *  当两个线程都到达（一个到达后 会等另一个）同步点，它们交换数据，因此第一个线程的数据结构进入第一个线程中，
 *  第二个线程的数据结构进入到第一个线程中；
 *  
 *  Exchanger类只能同步两个线程； 
 * @author Administrator
 *
 */

public class MainTest {
	public static void main(String[] args) {
		List<String> buffer1 = new ArrayList<String>();
		List<String> buffer2 = new ArrayList<String>();
		Exchanger<List<String>> exchanger = new Exchanger<>();

		Producer producer = new Producer(buffer1, exchanger);
		Consumer consumer = new Consumer(buffer2, exchanger);

		Thread threadProducer = new Thread(producer);
		Thread threadConsumer = new Thread(consumer);

		threadProducer.start();
		threadConsumer.start();
	}

}
