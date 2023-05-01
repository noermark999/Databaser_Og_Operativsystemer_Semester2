package Eks3_Semaphore;

import java.util.concurrent.Semaphore;

public class BankAccount {

	private Semaphore semaphore = new Semaphore(1);
	private double balance;

	public void setBalance(double amount, String action) {
		try {
			semaphore.acquire();
			if (action.equals("c")) {
				balance = balance + amount;
			}
			if (action.equals("d")) {
				balance = balance - amount;
			}
			semaphore.release();
		}  catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}

	public double getBalance() {
		return balance;
	}
}
