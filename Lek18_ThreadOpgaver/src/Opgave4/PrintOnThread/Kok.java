package Opgave4.PrintOnThread;

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
                sleep(600);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            counter.lavBestilling();
            System.out.println(name + " har lavet bestilling nummer: " + counter.getKokBestilling());
        }
    }
}
