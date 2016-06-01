package TestConcurrency.PhaserTest2;

import java.util.concurrent.Phaser;

public class MyPhaser extends Phaser {

	protected boolean onAdvance(int phaser, int registeredParties) {
		switch (phaser) {
		case 0:
			return studentsArrived();
		case 1:
			return finishFirstExercise();
		case 2:
			return finishSecondExercise();
		case 3:
			return finishExam();
		default:
			return true;
		}
	}

	private boolean finishExam() {
		System.out.printf("Phaser: All the student have finished the exam.\n");
		System.out.printf("Phaser: Thank you for your time.\n");
		return false;
	}

	private boolean finishSecondExercise() {
		System.out
				.printf("Phaser: All the student have finished the second exercise.\n");
		System.out.printf("Phaser: It's the time for the third one.\n");

		return false;
	}

	private boolean finishFirstExercise() {
		System.out
				.printf("Phaser: All the student have finished the first exercise.\n");
		System.out.printf("Phaser: It's the time for the second one.\n");
		return false;
	}

	private boolean studentsArrived() {
		System.out
				.printf("Phaser: The exam are going to start . The students are ready .\n");
		System.out.printf("Phaser: We have %d student .\n", getRegisteredParties());
		return false;
	}

}