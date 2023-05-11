package Opgave4;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Faelles {
    private int global = 0;
    private Semaphore semaphore = new Semaphore(1);

    public Faelles() {

    }

    public void tagerRandomTid(int max) {
        int res = 3;
        Random r = new Random();
        int nymax = Math.abs(r.nextInt())% max +1;
        for (int i = 0; i < nymax; i++) {
            for (int j = 0; j < max; j++) {
                res = res+j+i;
            }
        }
    }

    public int getGlobal() {
        return global;
    }

    public void kritiskSection() {
        try {
            semaphore.acquire();
            int temp;
            temp = global;
            tagerRandomTid(1215);
            global = temp + 1;
            semaphore.release();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
