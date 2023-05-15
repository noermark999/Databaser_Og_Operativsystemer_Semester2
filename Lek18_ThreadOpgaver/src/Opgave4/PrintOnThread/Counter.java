package Opgave4.PrintOnThread;


public class Counter {
    private int kokBestilling;
    private int tjenerBestilling;

    public int getKokBestilling() {
        return kokBestilling;
    }

    public int getTjenerBestilling() {
        return tjenerBestilling;
    }

    public synchronized void tagBestilling() {
        if (kokBestilling == tjenerBestilling) {
            notifyAll();
        }
        tjenerBestilling++;

    }

    public synchronized void lavBestilling() {
        if (kokBestilling < tjenerBestilling && tjenerBestilling != 0) {
            kokBestilling++;
        } else {
            System.out.println("Der er ingen bestillinger at lave");
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
