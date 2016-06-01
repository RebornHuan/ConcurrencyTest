package TestConcurrency.SynchronizedTest;

public class MainTest {
	public static void main(String[] args) {
		Account account = new Account();
		account.setBalance(1000);
		Company company = new Company(account);
		Thread ThreadCompany = new Thread (company);
		BankTest bank = new BankTest(account);
		Thread ThreadBank = new Thread(bank);
		
		System.out.printf("Account : Initial Balance: %f\n", account.getBalance());
		ThreadCompany.start();
		ThreadBank.start();
		
		try {
			
			ThreadCompany.join();
			ThreadBank.join();
			System.out.printf("Account : Final Balance : %f\n", account.getBalance());
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
