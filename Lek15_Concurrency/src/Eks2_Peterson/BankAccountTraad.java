package Eks2_Peterson;

public class BankAccountTraad extends Thread {

	private BankAccount ba;

	public BankAccountTraad(BankAccount ba) {
		this.ba = ba;
	}

	public void run() {
		int i = 0;
		while (i < 4) {
			try {
				this.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			TestBankAccount.setFlag(true,0);
			TestBankAccount.setTurn(1);
			while (TestBankAccount.getFlag(1) && TestBankAccount.getTurn() == 1);
			ba.setBalance(100, "c");
			TestBankAccount.setFlag(false,0);
			i++;
		}
		System.out.println("Balancen er: " + ba.getBalance());
	}

}
