package TestConcurrency.SynchroinzedTest2;

/**
 * 同一时间只有一个线程能够访问这个对象的代码保护快；
 * 但是例子中允许同时运行两个线程:一个修改vacanciesCinema1属性；一个修改vacanciesCinema2属性；
 * @author Administrator
 *
 */

public class Cinema {
	long vacanciesCinema1;
	long vacanciesCinema2;
	private final Object controlCinema1,controlCinema2;
	public Cinema() {
		controlCinema1 = new Object();
		controlCinema2 = new Object();
		this.vacanciesCinema1=20;
		this.vacanciesCinema2=20;
	}
	public boolean sellTickets1 (int number) {
		synchronized (controlCinema1) {
			if (number < vacanciesCinema1) {
				vacanciesCinema1 -= number;
				return true;
			}else {
				return false;
			}
		}
	}
	
	public boolean sellTickets2 (int number) {
		synchronized (controlCinema2) {
			if (number < vacanciesCinema2) {
				vacanciesCinema2 -= number;
				return true;
			}else {
				return false;
			}
		}
	}
	
	public boolean returnTickets1(int number) {
		synchronized(controlCinema1) {
			vacanciesCinema1 += number;
			return true;
		}
	}
	
	public boolean returnTickets2(int number) {
		synchronized(controlCinema2) {
			vacanciesCinema2 += number;
			return true;
		}
	}
	
	public long getvacanciesCinema1() {
		return vacanciesCinema1;
	}
	
	public long getvacanciesCinema2() {
		return vacanciesCinema2;
	}

}
