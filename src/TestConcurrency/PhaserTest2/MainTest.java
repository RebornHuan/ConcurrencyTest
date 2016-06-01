package TestConcurrency.PhaserTest2;

public class MainTest {
	public static void main(String[] args) {
		MyPhaser phaser = new MyPhaser();
		Student student[] = new Student[5];
		for (int i = 0; i < 5; i++) {
			student[i] = new Student(phaser);
			phaser.register();
		}

		Thread threads[] = new Thread[5];
		for (int i = 0; i < 5; i++) {
			threads[i] = new Thread(student[i], "Studengt " + i);
			threads[i].start();
		}

		for (int i = 0; i < 5; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.printf("Main: The phaser has finished: %s .\n",
				phaser.isTerminated());
	}
}
