package Opgave1;

public class Kok extends Thread{
    private String name;
    private Counter counter;

    public Kok(String name, Counter counter) {
        this.name = name;
        this.counter = counter;
    }

    @Override
    public void run() {
        while (true) {
            try {
                sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            counter.lavBestilling();
        }
    }
}
