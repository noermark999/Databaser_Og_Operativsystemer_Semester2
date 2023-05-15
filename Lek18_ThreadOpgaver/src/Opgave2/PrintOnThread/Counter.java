package Opgave2.PrintOnThread;

import java.util.concurrent.Semaphore;

public class Counter {
    private int kokBestilling;
    private int tjenerBestilling;
    private Semaphore semaphore = new Semaphore(1);

    public int getKokBestilling() {
        return kokBestilling;
    }

    public int getTjenerBestilling() {
        return tjenerBestilling;
    }

    public void tagBestilling() {
        try {
            semaphore.acquire();
            tjenerBestilling++;
            semaphore.release();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void lavBestilling() {
        if (kokBestilling < tjenerBestilling && tjenerBestilling != 0) {
            kokBestilling++;
        } else {
            System.out.println("Der er ingen bestillinger at lave");
        }
    }
}
