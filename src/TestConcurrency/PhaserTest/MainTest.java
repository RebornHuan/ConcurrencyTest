package TestConcurrency.PhaserTest;

import java.util.concurrent.Phaser;

public class MainTest {
	public static void main(String[] args) {
		Phaser phaser = new Phaser(3);
		FileSearch system = new FileSearch("G:\\MySoft", "exe", phaser);
		FileSearch apps = new FileSearch("G:\\360", "exe", phaser);
		FileSearch document = new FileSearch("G:\\Downloads", "exe", phaser);

		Thread threadSystem = new Thread(system, "system");
		threadSystem.start();

		Thread threadApps = new Thread(apps, "apps");
		threadApps.start();

		Thread threadDocument = new Thread(document, "document");
		threadDocument.start();

		try {
			threadSystem.join();
			threadApps.join();
			threadDocument.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Terminated: " + phaser.isTerminated());

	}

}
