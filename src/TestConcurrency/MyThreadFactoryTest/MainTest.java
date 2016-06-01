package TestConcurrency.MyThreadFactoryTest;

public class MainTest {
	public static void main(String[] args) {
		MyThreadFactory factory = new MyThreadFactory("MyThreadFactory");
		Task task = new Task();
		Thread thread;
		for (int i = 0; i<10; i++) {
			thread = factory.newThread(task);
			thread.start();
		}
		System.out.printf("Factory stats: \n");
		System.out.printf("%s\n", factory.getStats());
	}
}
