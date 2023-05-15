package Opgave4;

public class Tjener extends Thread{
    private String navn;
    private Counter counter;

    public Tjener(String navn, Counter counter) {
        this.navn = navn;
        this.counter = counter;
    }

    @Override
    public void run() {
        while (true) {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            counter.tagBestilling(this);
        }
    }

    public String getNavn() {
        return navn;
    }
}
