package TestConcurrency.JoinTest;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DataSourceLoaderTest implements Runnable {

	@Override
	public void run() {
		System.out.printf("Beginning data source loading : %s\n", new Date());
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("Date sources loading has finished : %s\n ",
				new Date());

	}

}
