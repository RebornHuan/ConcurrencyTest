package TestConcurrency.PrimeGeneratorTest;
/**
 * Java 提供了 中断 机制
 * @author 14073984
 *
 */
public class PrimeGeneratorTest extends Thread{
	public void run(){
		Long number=1l;
		while(true){
			if (isPrime(number)){
				System.out.printf("Number %d is Prime \n",number);
			}
			if(isInterrupted()){
				System.out.printf("The Prime Generator has been Interrupted");
				return;
			}
			number++;
		}
	}
	
	private boolean isPrime(Long number){
		if (number<2){
			return true;
		}
		for(long i=2; i<number; i++){
			if((number % i)==0){
				return false;
			}
		}
		return true;
	}

}
