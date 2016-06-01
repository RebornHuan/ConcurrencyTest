package TestConcurrency.MultipleConditionTest;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Buffer {

	/* 用来存放共享数据 */
	private LinkedList<String> buffer;
	/* buffer的长度 */
	private int maxSize;
	private ReentrantLock lock;
	private Condition lines;
	private Condition space;
	/* 表面缓冲区是否还有数据 */
	private boolean pendingLines;

	public Buffer(int maxSize) {
		this.maxSize = maxSize;
		buffer = new LinkedList<String>();
		lock = new ReentrantLock();
		lines = lock.newCondition();
		space = lock.newCondition();
		pendingLines = true;
	}

	public void insert(String line) {
		lock.lock();
		try {
			while (buffer.size() == maxSize) {
				space.await();
			}
			buffer.offer(line);
			System.out.printf("%s: Inserted Line: %d\n", Thread.currentThread()
					.getName(), buffer.size());
			lines.signalAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public String get() {
		String line = null;
		lock.lock();
		try {
			while ((buffer.size() == 0) && (hasPendingLines())) {
				lines.await();
			}
			if (hasPendingLines()) {
				line = buffer.poll();
				System.out.printf("%s: Line Readed: %d\n", Thread
						.currentThread().getName(), buffer.size());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
		return line;
	}

	public void setPendingLines(boolean pendingLines) {
		this.pendingLines = pendingLines;
	}

	public boolean hasPendingLines() {
		return pendingLines || buffer.size() > 0;

	}

}
