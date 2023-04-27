package Lotto;

public class App {
    private static int[] antalRigtige = new int[8];
    private static Lotto lottoRigtig = new Lotto();
    private static int numberOfLotto = 10000000;
    public static void main(String[] args) {
        Lotto[] lottos = new Lotto[numberOfLotto];
        for (int i = 0; i < lottos.length; i++) {
            lottos[i] = new Lotto();
        }

        long l1 = System.nanoTime();
        skrivAntalRigtige(lottos);
        long l2 = System.nanoTime();
        System.out.println("Køretiden var " + (l2 - l1) / 1000000 + " millisekunder");

        System.out.println();
        long l3 = System.nanoTime();
        try {
            skrivAntalRigtigeThread(lottos);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long l4 = System.nanoTime();
        System.out.println("Køretiden var " + (l4 - l3) / 1000000 + " millisekunder");
    }

    public static void skrivAntalRigtige(Lotto[] lottos) {
        for (int i = 0; i < lottos.length; i++) {
            int antal = lottos[i].antalrigtige(lottoRigtig);
            for (int j = 0; j < antalRigtige.length; j++) {
                if (antal == j) {
                    antalRigtige[j]++;
                }
            }
        }
        for (int i = 0; i < antalRigtige.length; i++) {
            System.out.println("Antal med " + i + ": " + antalRigtige[i]);
        }
    }

    public static void skrivAntalRigtigeThread(Lotto[] lottos) throws InterruptedException {
        Lotto[] part1 = new Lotto[numberOfLotto/2];
        Lotto[] part2 = new Lotto[numberOfLotto/2];
        System.arraycopy(lottos,0, part1, 0, part1.length);
        System.arraycopy(lottos, part1.length, part2, 0, part2.length);
        LottoThread lottoThread1 = new LottoThread(part1, lottoRigtig);
        LottoThread lottoThread2 = new LottoThread(part2, lottoRigtig);
        lottoThread1.start();
        lottoThread2.start();
        lottoThread1.join();
        lottoThread2.join();
        for (int i = 0; i < antalRigtige.length; i++) {
            antalRigtige[i] = lottoThread1.getAntalRigtige()[i] + lottoThread2.getAntalRigtige()[i];
        }
        for (int i = 0; i < antalRigtige.length; i++) {
            System.out.println("Antal med " + i + ": " + antalRigtige[i]);
        }
    }
}
