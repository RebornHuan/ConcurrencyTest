package TestConcurrency.SynchronizedTest;

public class BankTest implements Runnable {
	
	private Account account;
	
	public BankTest(Account account) {
		this.account = account;
	}

	@Override
	public void run() {
		for (int i =0; i<100; i++) {
			account.subtractAmount(1000);
		}
	}

}
