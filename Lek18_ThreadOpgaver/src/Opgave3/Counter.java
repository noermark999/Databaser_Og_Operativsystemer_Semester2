package Opgave3;


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
        System.out.println("Tjener har taget bestilling nummer: " + (tjenerBestilling+1));
        if (kokBestilling == tjenerBestilling) {
            notify();
        }
        tjenerBestilling++;

    }

    public synchronized void lavBestilling() {
        if (kokBestilling < tjenerBestilling && tjenerBestilling != 0) {
            System.out.println("Kok har lavet bestilling nummer: " + (kokBestilling+1));
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
