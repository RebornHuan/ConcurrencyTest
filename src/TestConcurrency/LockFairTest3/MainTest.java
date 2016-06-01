package TestConcurrency.LockFairTest3;

public class MainTest {
	public static void main(String[] args) {
		PrintQueue printQueue = new PrintQueue();
		Thread threads[] = new Thread[10];
		for (int i = 0; i < 10; i++) {
			threads[i] = new Thread(new Job(printQueue), "Thread " + i);
		}
		for (int i = 0; i < 10; i++) {
			threads[i].start();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
