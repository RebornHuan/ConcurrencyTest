package TestConcurrency.FileSearchTest;

import java.util.concurrent.TimeUnit;

public class FileSearchTestMain {
	public static void main(String[] args){
		
		FileSearchTest searcher = new FileSearchTest("D:\\","npMyEditBox.log");
		Thread thread = new Thread(searcher);
		
		thread.start();
		
		try {
			TimeUnit.SECONDS.sleep(10);
		}catch (InterruptedException e){
			e.printStackTrace();
		}
		thread.interrupt();
	}
}
