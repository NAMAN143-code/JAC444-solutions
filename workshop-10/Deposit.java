public class Deposit extends Thread{
	
	private SharedAccount sa;
	
	private double[] balance;
	private String[] currency;
	private int i = 0;
	private int t_in_use = 0;
	

	public Deposit(SharedAccount sa, double[] balance, String[] currency) {
		this.sa = sa;
		this.balance = balance;
		this.currency = currency;
	}
	
	public void run() {
		
		while(t_in_use == 0) {
			
			synchronized(sa) {
				while(sa.getBalance() != 0) {
					try {
						sa.wait();
					} catch(InterruptedException ie) {
						System.out.println(ie.getMessage());
					}
				}
				
				if(sa.getBalance() == 0 && i < 3) {
					sa.depositBalance(balance[i]);
					System.out.println("\n     Account    ");
					System.out.println("=================");
					System.out.println("Balance is 0 Add Balance: " + sa.getBalance());
					sa.setCurrency(currency[i]);
					System.out.println("Set new Currency to " +  sa.getCurrency() + "\n");
					i++;
					System.out.println(sa.toString() + "\n");
					sa.notify();
				} else {
					Thread.currentThread().interrupt();
					t_in_use = -1;
				}
			}
		}
		Thread.currentThread().interrupt();
	}
}