package TestConcurrency.UncaughtExceptionTest;

public class Task implements Runnable {

	@Override
	public void run() {
		int numero = Integer.parseInt("TTT");
	}
	
	public static void main(String[] args){
		Task task = new Task();
		Thread thread = new Thread(task);
		thread.setUncaughtExceptionHandler(new ExceptionHandlerTest());
		thread.start();
		
	}

}
