package Opgave2;

public class Main {
    private static int turn;
    private static boolean[] flag;
    public static void main(String[] args) throws InterruptedException {

        flag = new boolean[2];
        flag[0] = false;
        flag[1] = false;
        turn = 1;

        Faelles faelles = new Faelles();

        MyThread myThread1 = new MyThread("1", faelles, 0);
        MyThread myThread2 = new MyThread("2", faelles, 1);

        myThread1.start();
        myThread2.start();
        myThread1.join();
        myThread2.join();

        System.out.println(faelles.getGlobal());
    }

    public static void setFlag(boolean flag, int id) {
        Main.flag[id] = flag;
    }

    public static boolean getFlag(int id) {
        return flag[id];
    }

    public static int getTurn() {
        return turn;
    }

    public static void setTurn(int turn) {
        Main.turn = turn;
    }
}
