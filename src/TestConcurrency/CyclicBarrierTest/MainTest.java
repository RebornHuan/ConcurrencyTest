package TestConcurrency.CyclicBarrierTest;

import java.util.concurrent.CyclicBarrier;

/**
 * 在集合点上的同步；  CyclicBarrier类
 *  在数据矩阵中需找某个数字的个数；
 *  
 *  CyclicBarrier类使用一个整数进行初始化，这个数是需要在某个点上同步的线程数；
 *  当一个线程到达指定的点后，它将调用await() 方法等待其他的线程。
 *  当线程调用await方法后，CycliBarrier将阻塞这个线程并使之休眠，直到所有的其他线程到达。
 *  当最后一个线程调用CyclicBarrier的await方法后，CyclicBarrier 对象将唤醒所有等待的 线程，然后这些线程将继续执行；
 *  CyclicBarrier类有意义的改进，它可以传入另一个 Runnable对象作为初始化参数，当所有线程到达集合点后，
 *  CyclicBarrier类将这个Runnable对象作为线程执行；
 * @author Administrator
 *
 */

public class MainTest {
	public static void main(String[] args) {
		
		final int ROWS = 10000;
		final int NUMBERS = 1000;
		final int SEARCH = 5;
		final int PARTICIPANTS = 5;
		final int LINES_PARTICIPANT = 2000;

		MatrixMock mock = new MatrixMock(ROWS, NUMBERS, SEARCH);
		Results results = new Results(ROWS);
		Grouper grouper = new Grouper(results);
		CyclicBarrier barrier = new CyclicBarrier(PARTICIPANTS, grouper);

		Searcher searchers[] = new Searcher[PARTICIPANTS];
		
		for (int i = 0; i < PARTICIPANTS; i++) {
			searchers[i] = new Searcher(i * LINES_PARTICIPANT,
					((i * LINES_PARTICIPANT) + LINES_PARTICIPANT), mock, results,
					5, barrier);
			Thread thread = new Thread(searchers[i]);
			thread.start();
		}
		
		System.out.printf("Main: The main thread has finished .\n");
		
	

	}

}
