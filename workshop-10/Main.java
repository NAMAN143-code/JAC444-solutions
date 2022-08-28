public class Main {

	public static void main(String[] args) {
		double[] balance = {40.0, 20.0, 30.0};
		String[] currency = {"USD", "INR", "CAD"};
		
		SharedAccount sa = new SharedAccount(0, "");
		
		Thread d_t = new Thread(new Deposit(sa, balance, currency));
		Thread w_t = new Thread(new Withdraw(sa));
		
		d_t.start();
		w_t.start();
		
		try {
			d_t.join();
			w_t.join();
		} catch(InterruptedException ie) {
			System.out.println(ie.getMessage());
		}
		
	}
	
}