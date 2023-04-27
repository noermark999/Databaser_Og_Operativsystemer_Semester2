package Opgave1;
import java.util.Random;

public class Opgaven {

    private static final int rowindex = 10;
    private static final int colindex = 20000000;

    private static int[][] board = new int[rowindex][colindex];

    public static void main(String[] args) {
        fillBoard();
        // printBoard();
        long l1 = System.nanoTime();

        //System.out.println("Max: " + findMax());


        try {
            System.out.println("Max: " + findMaxThread());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        long l2 = System.nanoTime();
        System.out.println("Køretiden var " + (l2 - l1) / 1000000 + " millisekunder");
    }

    public static int findMax() {
        int res = 0;
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] > res) {
                    res = board[row][col];
                }
            }
        }
        return res;
    }

    public static int findMaxThread() throws InterruptedException {
        MaxThread maxThread1 = new MaxThread(board,true);
        MaxThread maxThread2 = new MaxThread(board, false);
        maxThread1.start();
        maxThread2.start();
        maxThread1.join();
        maxThread2.join();
        return Math.max(maxThread1.getMax(), maxThread2.getMax());
    }

    public static void fillBoard() {
        Random rand = new Random();
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = rand.nextInt(1000);
            }
        }
    }

    public static void printBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
