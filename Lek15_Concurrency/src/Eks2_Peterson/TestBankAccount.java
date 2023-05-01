package Eks2_Peterson;

public class TestBankAccount {
	private static int turn;
	private static boolean[] flag;

	public static void main(String[] args) {

		flag = new boolean[2];
		flag[0] = false;
		flag[1] = false;
		turn = 1;

		BankAccount ba = new BankAccount();
			BankAccountTraad bat1 = new BankAccountTraad(ba);
			BankAccountTraad2 bat2 = new BankAccountTraad2(ba);
			
			bat1.start();
			bat2.start();
		}

	public static void setFlag(boolean flag, int id) {
		TestBankAccount.flag[id] = flag;
	}
	public static boolean getFlag(int id) {
		return flag[id];
	}

	public static int getTurn() {
		return turn;
	}

	public static void setTurn(int turn) {
		TestBankAccount.turn = turn;
	}
}
