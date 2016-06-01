import java.util.Random;


public class RouletleSelectionTest {
	public static void main(String[] args) throws InterruptedException{
		  Random r = new java.util.Random();
		  Long totalAvailable=1000l;
		  while(true){
	      long randomPosition = Math.abs(r.nextLong()) % totalAvailable;
	          System.out.println(randomPosition);
//	          System.out.println(Math.abs(r.nextLong()));
	          Thread.sleep(1000);
		  }
	}

}
