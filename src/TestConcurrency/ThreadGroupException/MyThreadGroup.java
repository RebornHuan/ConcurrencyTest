package TestConcurrency.ThreadGroupException;

public class MyThreadGroup extends ThreadGroup {

	public MyThreadGroup(String name) {
		super(name);
	}

	public void uncaughtException(Thread t, Throwable e) {
		System.out
				.printf("The Thread %s has thrown an Exception \n", t.getId());
		e.printStackTrace();
		System.out.printf("Terminating the rest of the Threads");
		interrupt();

	}

}
