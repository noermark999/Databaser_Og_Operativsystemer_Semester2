package Lotto;

public class LottoThread extends Thread {
    private int[] antalRigtige = new int[8];
    private Lotto[] lottos;
    private Lotto lottoRigtig;

    public LottoThread(Lotto[] lottos, Lotto lottoRigtig) {
        this.lottos = lottos;
        this.lottoRigtig = lottoRigtig;
    }

    @Override
    public void run() {
        for (int i = 0; i < lottos.length; i++) {
            int antal = lottos[i].antalrigtige(lottoRigtig);
            for (int j = 0; j < antalRigtige.length; j++) {
                if (antal == j) {
                    antalRigtige[j]++;
                }
            }
        }
    }

    public int[] getAntalRigtige() {
        return antalRigtige;
    }
}
