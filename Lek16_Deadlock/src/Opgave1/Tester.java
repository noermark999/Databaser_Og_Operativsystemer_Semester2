package Opgave1;

public class Tester {
    public static void main(String[] args) {
        Stack stack = new Stack();
        PopThread popThread = new PopThread(stack);
        PushThread pushThread = new PushThread(stack);
        popThread.start();
        pushThread.start();
    }
}
