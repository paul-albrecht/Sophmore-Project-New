package tetrisv2;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class GameBoard {

    static int gameboard[][]
         = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
    int x;
    int y;
    int width;
    int height;
    int squareSize = 25;
    boolean run = true;
    Timer timer = new Timer("Timer");

    GameBoard(int x, int y, int width, int height) {
        int type; //1 LL, 2RL, 3S, 4Z, 5Square, 6I
        int typeIndex; //1 LL RL, 2 S Z Square, 3 I
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        System.out.println("0123456789");
        draw();
        type = 1;
        typeIndex = 1;
        //moveRight(3, 4);
        //moveLeft(3, 4);
        moveDown(3, 4, 3, 5);
        System.out.println();
        System.out.println("0123456789");

        draw();
    }

    public static void moveRight(int startRow, int endRow, int startCol, int endCol) {

        for (int i = startRow; i <= endRow; i++) {
            for (int j = endCol; j >= startCol; j--) {
                if (gameboard[i][j] > 0 && j + 1 <= 9) {
                    int temp = gameboard[i][j];
                    gameboard[i][j] = 0;
                    gameboard[i][j + 1] = temp;
                }
            }
        }
    }

    public static void moveLeft(int startIndex, int endIndex) {

        for (int i = startIndex; i <= endIndex; i++) {
            for (int j = 0; j <= (gameboard[i].length - 1); j++) {
                if (gameboard[i][j] > 0 && j + 1 <= 9 && gameboard[i][j - 1] == 0) {
                    int temp = gameboard[i][j];
                    gameboard[i][j] = 0;
                    gameboard[i][j - 1] = temp;
                }
            }
        }
    }

    public static void moveDown(int startIndex, int endIndex, int startCol, int endCol) {

        for (int i = endIndex; i >= startIndex; i--) {
            for (int j = startCol; j <= endCol; j++) {
                if (gameboard[i][j] > 0 && checkRow(i + 1, startCol, endCol)) {
                    int temp = gameboard[i][j];
                    gameboard[i][j] = 0;
                    gameboard[i + 1][j] = temp;
                }
            }
        }
    }

    public static void rotate() {

    }

    public static boolean checkRow(int rowIndex, int startCol, int endCol) {
        boolean full = false;
        for (int i = startCol; i <= endCol; i++) {
            if (gameboard[rowIndex][i] > 0) {
                full = true;
                System.out.println(full);
            }
        }
        return full;
    }

    public static void clearRow() {

    }

    public static void draw() {
        for (int i = 0; i < gameboard.length; i++) {
            for (int j = 0; j < gameboard[j].length; j++) {
                System.out.print(gameboard[i][j]);
            }
            System.out.println("");

        }

    }

    public void drawI() {
        
        timer();
    }

    public void drawLL() {

    }

    public void drawRL() {

    }

    public void drawS() {

    }

    public void drawZ() {

    }

    public void drawSquare() {

    }

    public void pickPiece() {
        Random rand = new Random();
        int n = rand.nextInt(6);
        switch (n) {
            case 0:
                drawI();
                break;
            case 1:
                drawRL();
                break;
            case 2:
                drawLL();
                break;
            case 3:
                drawS();
                break;
            case 4:
                drawZ();
                break;
            case 5:
                drawSquare();
                break;
        }
    }

    public void timer() {

        TimerTask repeatedTask = new TimerTask() {
            public void run() {
                moveDown();

            }
        };

        long delay = 1000L;
        long period = 1000L;
        if (run == true) {
            timer.scheduleAtFixedRate(repeatedTask, delay, period);
        }
    }

    public void timerStop() {
        timer.cancel();
        run = false;
    }

}
