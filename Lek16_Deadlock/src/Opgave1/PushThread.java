package Opgave1;

public class PushThread extends Thread{
    private Stack stack;

    public PushThread(Stack stack) {
        this.stack = stack;
    }

    public void run() {
        while (true) {
            stack.push(1);
            System.out.println("Der er blevet pushet");
            try {
                sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
