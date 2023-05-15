package Opgave4.PrintOnThread;

public class Tjener extends Thread{
    private String name;
    private Counter counter;

    public Tjener(String name, Counter counter) {
        this.name = name;
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
            counter.tagBestilling();
            System.out.println(name + " har taget bestilling nummer: " + counter.getTjenerBestilling());
        }
    }
}
