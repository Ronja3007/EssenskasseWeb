package logik;

public class Balance {
	private int accountBalance;
	
	public Balance() {
		accountBalance = 0;
	}
	
	public void pay(int cent) {
		accountBalance += cent;
	}

	public int getAccountBalance() {
		return accountBalance;
	}

}
