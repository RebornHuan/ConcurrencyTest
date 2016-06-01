package TestConcurrency.PhaserTest;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 * 并发阶段任务的运行；
 * Phaser类。
 * 当我们有并发任务并且需要分解成几步执行。
 * Phaser类机制是在每一步结束后对线程进行同步，当所有的线程都完成了这一步，才允许执行下一步。
 * 
 * 
 * @author Administrator
 *
 */

public class FileSearch implements Runnable {
	
	private String initPath;
	private String end;
	private List<String> results;

	private Phaser phaser;

	public FileSearch(String initPath, String end, Phaser phaser) {
		this.initPath = initPath;
		this.end = end;
		this.phaser = phaser;
		results = new ArrayList<String>();
	}

	private void directoryProcess(File file) {
		File list[] = file.listFiles();
		if (list != null) {
			for (int i = 0; i < list.length; i++) {
				if (list[i].isDirectory()) {
					directoryProcess(list[i]);
				} else {
					fileProcess(list[i]);
				}
			}
		}

	}

	
	private void fileProcess(File file) {
		if (file.getName().endsWith(end)) {
			results.add(file.getAbsolutePath());
		}
	}

	
	private void filterResults() {
		
		List<String> newResults = new ArrayList<>();
		long actualDate = new Date().getTime();
		for (int i = 0; i < results.size(); i++) {
			File file = new File(results.get(i));
			long fileDate = file.lastModified();

			if (actualDate - fileDate < TimeUnit.MILLISECONDS.convert(30,
					TimeUnit.DAYS)) {
				newResults.add(results.get(i));
			}
		}
		results = newResults;
	}

	
	private boolean checkResults() {
		if (results.isEmpty()) {
			System.out.printf("%s: Phaser %d: 0 results.\n", Thread
					.currentThread().getName(), phaser.getPhase());
			System.out.printf("%s: Phaser %d: End.\n", Thread.currentThread()
					.getName(), phaser.getPhase());
			phaser.arriveAndDeregister();
			return false;
		} else {
			System.out.printf("%s: Phaser %d: %d results.\n", Thread
					.currentThread().getName(), phaser.getPhase(), results
					.size());
			phaser.arriveAndAwaitAdvance();
			return true;
		}
	}

	private void showInfo() {
		for (int i = 0; i < results.size(); i++) {
			File file = new File(results.get(i));
			System.out.printf("%s: %s\n", Thread.currentThread().getName(),
					file.getAbsolutePath());
		}
		phaser.arriveAndAwaitAdvance();
	}

	@Override
	public void run() {
		phaser.arriveAndAwaitAdvance();

		System.out.printf("%s Starting.\n", Thread.currentThread().getName());

		File file = new File(initPath);

		if (file.isDirectory()) {
			directoryProcess(file);
		}
		if (!checkResults()) {
			return;
		}
		filterResults();
		if (!checkResults()) {
			return;
		}
		showInfo();
		phaser.arriveAndDeregister();
		System.out.printf("%s: Work completed.\n", Thread.currentThread()
				.getName());

	}

}
