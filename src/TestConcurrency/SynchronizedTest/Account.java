package TestConcurrency.SynchronizedTest;

/**
 * 如果一个对象已用synchronized 关键字声明，那么只有一个执行线程被允许访问它。
 * 如果其他摸个线程试图访问这个对象的其他方法，它将被挂起；
 * 直到第一个线程执行完正在运行的方法；
 * 
 * 静态方法则有不同的行为。用synchronized声明的 静态方法，同时只能够被一个执行线程访问。
 * 但是，其他线程可以访问这个对象的非静态方法。必须非常谨慎这一点，
 * 因为 两个线程 可以 同时访问 一个 对象的 两个不同的synchronized方法， 其中一个是 静态方法，一个是非静态方法。
 * 如果两个方法都改变了相同的数据，将会出现数据不一致的错误。
 * @author Administrator
 *
 */

public class Account {
	private double balance;

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public synchronized void addAmount(double amount) {
  // public  void addAmount(double amount) {
		double tmp = balance;
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		tmp += amount;
		balance = tmp;
	}

	public synchronized void subtractAmount(double amount) {
//  public  void subtractAmount(double amount) {
		double tmp = balance;
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		tmp =tmp- amount;
		balance = tmp;

	}

}
