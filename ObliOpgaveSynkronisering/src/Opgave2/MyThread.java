package Opgave2;

public class MyThread extends Thread {
    private Faelles faelles;
    private String navn;
    private int concurrentId;
    private int id;

    public MyThread(String navn, Faelles faelles, int id) {
        this.navn = navn;
        this.faelles = faelles;
        this.id = id;
    }

    public void run() {
        for (int j=0; j<100;j++) {
            concurrentId = (id + 1) % 2;
            Main.setFlag(true,id);
            Main.setTurn(concurrentId);
            while (Main.getFlag(concurrentId) && Main.getTurn() == concurrentId);
            faelles.kritiskSection();
            Main.setFlag(false,id);
            faelles.tagerRandomTid(3120);
        }
        System.out.println(faelles.getGlobal());
    }
}
