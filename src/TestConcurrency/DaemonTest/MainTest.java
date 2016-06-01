package TestConcurrency.DaemonTest;

import java.util.ArrayDeque;
import java.util.Deque;

public class MainTest {

	public static void main(String[] args) {
		Deque<Event> deque = new ArrayDeque<Event>();
		WriteTaskTest writer = new WriteTaskTest(deque);

		for (int i = 0; i < 3; i++) {
			Thread thread = new Thread(writer);
			thread.start();
		}

		CleanerTaskTest cleaner = new CleanerTaskTest(deque);
		cleaner.start();

	}

}
