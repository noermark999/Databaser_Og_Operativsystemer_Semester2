package Opgave1;

public class PopThread extends Thread {
    private Stack stack;

    public PopThread(Stack stack) {
        this.stack = stack;
    }

    public void run() {
        while (true) {
            stack.pop();
            System.out.println("Der er blevet poppet");
            try {
                sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
