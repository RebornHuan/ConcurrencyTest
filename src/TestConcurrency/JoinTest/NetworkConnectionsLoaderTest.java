package TestConcurrency.JoinTest;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * DataSourceLoaderTest一起使用
 * 两个线程都运行结束，主线程才会继续运行并且打印出最后的信息；
 * @author 14073984
 *
 */
public class NetworkConnectionsLoaderTest implements Runnable{

	@Override
	public void run() {
		System.out.printf("Beginning data source loading : %s\n", new Date());
		try {
			TimeUnit.SECONDS.sleep(6);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("Date sources loading has finished : %s\n ",
				new Date());

	}
	
	public static void main(String[] args){
		
		DataSourceLoaderTest dsLoader = new DataSourceLoaderTest();
		Thread thread1 = new Thread(dsLoader,"DataSourceLoaderTest");
		
		NetworkConnectionsLoaderTest ncLoader = new NetworkConnectionsLoaderTest();
		Thread thread2 = new Thread(ncLoader,"NetworkConnectionsLoaderTest");
		
		thread1.start();
		thread2.start();
		
		try {
			thread1.join();
			thread2.join();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("Main: configuration has been loaded : %s\n", new Date());
	}

}
