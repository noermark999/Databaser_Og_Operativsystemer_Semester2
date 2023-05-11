package Opgave4;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Faelles faelles = new Faelles();

        MyThread myThread1 = new MyThread("1", faelles);
        MyThread myThread2 = new MyThread("2", faelles);

        myThread1.start();
        myThread2.start();
        myThread1.join();
        myThread2.join();

        System.out.println(faelles.getGlobal());


    }
}
