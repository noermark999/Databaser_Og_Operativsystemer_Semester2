package Opgave4;

public class App {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Kok kok = new Kok("Madmester Martin", counter);
        Kok kok1 = new Kok("Gordon Ramsey", counter);
        Tjener tjener1 = new Tjener("Lars Tjener", counter);
        Tjener tjener2 = new Tjener("Laura Waiter", counter);

        tjener1.start();
        tjener2.start();
        kok.start();
        kok1.start();

    }
}
