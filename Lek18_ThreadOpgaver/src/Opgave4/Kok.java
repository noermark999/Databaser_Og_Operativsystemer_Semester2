package Opgave4;

public class Kok extends Thread{
    private String navn;
    private Counter counter;

    public Kok(String navn, Counter counter) {
        this.navn = navn;
        this.counter = counter;
    }

    @Override
    public void run() {
        while (true) {
            try {
                sleep(600);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            counter.lavBestilling(this);
        }
    }

    public String getNavn() {
        return navn;
    }
}
