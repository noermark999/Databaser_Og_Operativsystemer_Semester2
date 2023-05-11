package Opgave1;

public class Stack {
    private class Element {
        int info;
        Element next;
        Element(int n, Element e) {
            info = n;
            next = e;
        }
    }
    private Element first;
    public Stack() {
        first = null;
    }
    public synchronized void push(int n) {
        if (first == null) {
            first = new Element(n, null);
            notify();
        } else {
            first = new Element(n, first);
        }

    }
    public synchronized int pop() {
        if (first == null) {
            System.out.println("Stacken er tom");
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        int n = first.info;
        first = first.next;
        return n;
    }
    public boolean is_empty() {
        return first == null;
    }
}
