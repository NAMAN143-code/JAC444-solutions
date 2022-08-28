public class SharedAccount {

	private double balance;
	private String currency;
	

	SharedAccount(double balance, String currency) {
		this.balance = balance;
		this.currency = currency;
	}
	

	public double getBalance() {
		return balance;
	}
	public String getCurrency() {
		return currency;
	}
	

	public void setBalance(double balance) {
		this.balance = balance;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	
	public void depositBalance(double balance) {
		this.balance = this.balance + balance;
	}
	
	
	public void withdrawBalance(double balance) {
		this.balance = this.balance - balance;
	}
	

	@Override
	public String toString() {
		return "Account -----> balance is " + getBalance() + " and Currency is " + getCurrency();
	}
}