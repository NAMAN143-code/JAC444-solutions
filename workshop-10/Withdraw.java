public class Withdraw extends Thread {
	private SharedAccount sa;
	private int t_in_use = 0;
	

	public Withdraw(SharedAccount sa) {
		this.sa = sa;
	}
	
	public void run() {
		while(t_in_use == 0) {
			synchronized(sa) {
				while(sa.getBalance() != 0) {
					sa.withdrawBalance(10.0);
					System.out.println("Balance left in Account: " + sa.getBalance());
					sa.notify();
				}

				try {
					sa.wait();
				} catch (InterruptedException ie) {
					System.out.println(ie.getMessage());
				}
			}
		}
	}
}