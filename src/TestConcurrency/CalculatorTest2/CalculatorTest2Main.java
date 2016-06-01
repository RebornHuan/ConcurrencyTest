package TestConcurrency.CalculatorTest2;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.Thread.State;

/**
 * ID：保存了线程的唯一标示符；
 * Name：线程名称；
 * Priority: 1到10； 1是 最低优先级； 10 是最高优先级；
 * Status：     new.  runnable . blocked . waiting . time waiting  terminated
 * @author 14073984
 *
 */

public class CalculatorTest2Main {

	public static void main(String[] args) {

		Thread threads[] = new Thread[10];
		Thread.State status[] = new Thread.State[10];

		for (int i = 0; i < 10; i++) {
			threads[i] = new Thread(new CalculatorTest2(i));
			if (i % 2 == 0) {
				threads[i].setPriority(Thread.MAX_PRIORITY);
			} else {
				threads[i].setPriority(Thread.MIN_PRIORITY);
			}
			threads[i].setName("Thread " + i);
		}

		try (FileWriter file = new FileWriter(
				"D:\\Office\\MyFile\\Learning\\TestAll\\data\\log.txt");
				PrintWriter pw = new PrintWriter(file);) {
			
			for (int i = 0; i < 10; i++) {
				pw.println("Main : Status of Thread " + i + " : "
						+ threads[i].getState());
				status[i] = threads[i].getState();
			}

			for (int i = 0; i < 10; i++) {
				threads[i].start();
			}

			boolean finish = false;
			while (!finish) {
				for (int i = 0; i < 10; i++) {
					if (threads[i].getState() != status[i]) {
						writeThreadInfo(pw, threads[i], status[i]);
						status[i] = threads[i].getState();
					}
				}
				finish = true;
				for (int i = 0; i < 10; i++) {
					finish = finish
							& (threads[i].getState() == State.TERMINATED);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void writeThreadInfo(PrintWriter pw, Thread thread,
			State state) {
		pw.printf("Main : Id %d - %s\n", thread.getId(), thread.getName());
		pw.printf("Main : Priority: %d\n", thread.getPriority());
		pw.printf("Main : Old State: %s\n", state);
		pw.printf("Main : New State %s\n", thread.getState());
		pw.printf("Main : ********************** \n");
	}
}
