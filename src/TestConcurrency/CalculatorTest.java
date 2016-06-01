package TestConcurrency;

/**
 * 开始的时候JVM将启动一个执行线程调用程序的main()方法；
 * 当调用Thread对象的start()方法的时候，另外一个执行线程将会被调用。
 * 当所有非守护线程都运行完成的时候，这个java程序结束；
 * 如果初始线程（执行main的线程）结束了,其余的线程仍将继续执行直到他们运行结束；
 * 某个线程调用System.exit()函数，所有的线程都将会结束；
 * （执行Thread.start()的时候 执行线程才会被创建；）
 * @author 14073984
 *
 */

public class CalculatorTest implements Runnable {

	private int number;

	public CalculatorTest(int number) {
		this.number = number;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 1; i < 10; i++) {
			System.out.printf("%s: %d * %d = %d\n", Thread.currentThread()
					.getName(), number, i, i * number);
			if(number==6){
				System.exit(0);
			}
		}
	}

	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
			CalculatorTest calculator = new CalculatorTest(i);
			Thread thread = new Thread(calculator);
			thread.start();
/*			if(i==6){
				System.out.println("22222");
				System.exit(0);
			}*/
		}
	}

}
