package Opgave1;

public class MyThread extends Thread {
    private Faelles faelles;
    private String navn;

    public MyThread(String navn, Faelles faelles) {
        this.navn = navn;
        this.faelles = faelles;
    }

    public void run() {
        for (int j=0; j<100;j++) {
            faelles.kritiskSection();
            faelles.tagerRandomTid(3120);
        }
        System.out.println(faelles.getGlobal());

    }
}
