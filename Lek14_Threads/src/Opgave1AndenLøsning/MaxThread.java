package Opgave1AndenLøsning;

public class MaxThread extends Thread{
    private int[] board;

    private int max;

    public MaxThread(int[] board) {
        this.board = board;
        max = 0;
    }

    @Override
    public void run() {
        for (int row = 0; row < board.length; row ++) {
            if (board[row] > max) {
                max = board[row];
            }
        }
    }

    public int getMax() {
        return max;
    }
}
