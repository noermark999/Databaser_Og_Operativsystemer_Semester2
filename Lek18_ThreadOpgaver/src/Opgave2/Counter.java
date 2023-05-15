package Opgave2;

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
            System.out.println("Tjener har taget bestilling nummer: " + (tjenerBestilling+1));
            tjenerBestilling++;
            semaphore.release();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void lavBestilling() {
        if (kokBestilling < tjenerBestilling && tjenerBestilling != 0) {
            System.out.println("Kok har lavet bestilling nummer: " + (kokBestilling+1));
            kokBestilling++;
        } else {
            System.out.println("Der er ingen bestillinger at lave");
        }
    }
}
