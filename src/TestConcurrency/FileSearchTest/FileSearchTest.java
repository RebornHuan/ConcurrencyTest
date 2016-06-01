package TestConcurrency.FileSearchTest;

import java.io.File;

/**
 * 如果线程实现了复杂的算法并且分布在几个方法中
 * 或者线程里面有递归调用，
 * JAVA提供了InterruptedException异常
 * 当检查到线程中断的时候，就跑出异常，然后在run()中捕获并处理;
 * @author 14073984
 *
 */

public class FileSearchTest implements Runnable {

	private String initPath;
	private String fileName;

	public FileSearchTest(String initPath, String fileName) {
		this.initPath = initPath;
		this.fileName = fileName;
	}

	@Override
	public void run() {
		
		System.out.println("=========================");
		System.out.println(initPath);
		System.out.println(fileName);
		System.out.println("=========================");

		File file = new File(initPath);
		if (file.isDirectory()) {
			
			System.out.println("++++++++++++++++");

			try {
				directoryProcess(file);
			} catch (InterruptedException e) {
				System.out.printf("%s : The search has been interrupted",
						Thread.currentThread().getName());
			}
		}
	}

	private void directoryProcess(File file) throws InterruptedException {
		
		File list[] = file.listFiles();
		
		if (list != null) {
			for (int i = 0; i < list.length; i++) {
				if (list[i].isDirectory()) {
					directoryProcess(list[i]);
				} else {
					fileProcess(list[i]);
				}
			}
		}
		if (Thread.interrupted()) {
			throw new InterruptedException();
		}
	}

	private void fileProcess(File file) throws InterruptedException {
		if(file.getName().equals(fileName)){
			System.out.printf("%s : %s\n",Thread.currentThread().getName(),file.getAbsolutePath());
		}
		if(Thread.interrupted()){
			throw new InterruptedException();
		}

	}

}
