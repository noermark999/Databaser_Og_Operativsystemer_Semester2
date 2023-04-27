package Opgave1;

public class MaxThread extends Thread{
    boolean even;
    private int[][] board;

    private int max;

    public MaxThread(int[][] board, boolean even) {
        this.board = board;
        this.even = even;
        max = 0;
    }

    @Override
    public void run() {
        if (even) {
            for (int row = 0; row < board.length; row += 2) {
                for (int col = 0; col < board[row].length; col += 2) {
                    if (board[row][col] > max) {
                        max = board[row][col];
                    }
                }
            }
        } else {
            for (int row = 1; row < board.length; row += 2) {
                for (int col = 1; col < board[row].length; col += 2) {
                    if (board[row][col] > max) {
                        max = board[row][col];
                    }
                }
            }
        }
    }

    public int getMax() {
        return max;
    }
}
