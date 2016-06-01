package TestConcurrency.PrimeGeneratorTest;

public class PrimeGeneratorTestMain {
	public static void main(String[] args){
		Thread task=new PrimeGeneratorTest();
		task.start();
		try{
			Thread.sleep(1000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		task.interrupt();
	}
	

}
