package TestConcurrency.CalculatorTest2;

public class CalculatorTest2 implements Runnable {
	private int number;

	public CalculatorTest2(int number) {
		this.number = number;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 1; i < 10; i++) {
			System.out.printf("%s: %d * %d = %d\n", Thread.currentThread()
					.getName(), number, i, i * number);
		
		}
	}

}
