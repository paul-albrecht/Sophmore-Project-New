package tetrisv2;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class GameBoard {

    static int gameboard[][]
            = {{1, 2, 3, 4, 5, 6, 7, 0, 0, 0},
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
            {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
            {0, 7, 0, 0, 3, 3, 1, 4, 4, 0},
            {7, 7, 7, 3, 3, 0, 1, 0, 4, 4}};
    int x = 0;
    int y = 0;
    int width = 0;
    int height = 0;
    int squareSize = 25;
    boolean run = true;
    Timer timer = new Timer("Timer");
    int startRow_index = 3;
    int endRow_index = 4;
    int startCol_index = 7;
    int endCol_index = 9;
    int type = -1;

    GameBoard(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        System.out.println("    0123456789");
        draw();
        //moveRight(3, 4);
        //moveLeft(3, 4);
//        moveDown(3, 4, 3, 5);
        System.out.println();
        System.out.println("    0123456789");
        draw();
    }

    public void moveRight(int startRow, int endRow, int startCol, int endCol) { //should now work
        boolean moved = false;
        boolean edge = false;
        for (int i = endRow; i <= startRow; i--) {
            if (type == 4) {
                for (int j = startCol; j >= endCol; j++) { //right to left S
                    if (gameboard[i][j] > 0) {
                        if (j + 1 <= 9) {
                            int temp = gameboard[i][j];
                            gameboard[i][j] = 0;
                            gameboard[i][j + 1] = temp;
                            moved = true;
                        } else {
                            edge = true;
                            break;
                        }
                    }
                }
            } else {
                for (int j = endCol; j >= startCol; j--) { //left to right all other pieces
                    if (gameboard[i][j] > 0) {
                        if (j + 1 <= 9) {
                            int temp = gameboard[i][j];
                            gameboard[i][j] = 0;
                            gameboard[i][j + 1] = temp;
                            moved = true;
                        } else {
                            edge = true;
                            break;
                        }
                    }
                }
            }
            if (edge) {
                System.out.println("break");
                break;
            }

        }
        if (moved && (endCol + 1 <= 9)) {
            startCol_index++;
            endCol_index++;
        }

    }

    public void moveLeft(int startRow, int endRow, int startCol, int endCol) { //should now work
        boolean moved = false;
        for (int i = startRow; i <= endRow; i++) {
            if (type == 5) { //right to left Z
                for (int j = endCol; j <= startCol; j--) {
                    if (gameboard[i][j] > 0 && j + 1 <= 9 && gameboard[i][j - 1] == 0) {
                        int temp = gameboard[i][j];
                        gameboard[i][j] = 0;
                        gameboard[i][j - 1] = temp;
                        moved = true;

                    }
                }
            } else { //left to right all other pieces
                for (int j = startCol; j <= endCol; j++) {
                    if (gameboard[i][j] > 0 && j + 1 <= 9 && gameboard[i][j - 1] == 0) {
                        int temp = gameboard[i][j];
                        gameboard[i][j] = 0;
                        gameboard[i][j - 1] = temp;
                        moved = true;

                    }
                }
            }
        }
        if (moved && (startCol - 1 >= 0)) {
            startCol_index--;
            endCol_index--;
        }
    }

    public void moveDown(int startRow, int endRow, int startCol, int endCol) { //takes in the top/bottom and left/right bounds should work with all pieces
        boolean filled = false;
        boolean moved = false;
        for (int i = endRow; i >= startRow; i--) {
            for (int j = startCol; j <= endCol; j++) {
                if (gameboard[i][j] > 0) {
                    if (!checkRow(i + 1, j)) {
                        int temp = gameboard[i][j];
                        gameboard[i][j] = 0;
                        gameboard[i + 1][j] = temp;
                    } else {
                        filled = true;
                        break;
                    }
                }
            }
            if (filled) {
                break;
            }
        }
        if (moved && (endRow + 1 < gameboard.length)) {
            startRow_index++;
            endRow_index++;
        }
    }

    public static void rotate() {

    }

    public static boolean checkRow(int row, int col) { //checks the i+1 row to see if it is a 1/0
        boolean full = false;
        if (row < gameboard.length && col <= gameboard[gameboard.length - 1].length) {
            if (gameboard[row][col] > 0) {
                full = true;
            }
        }
        return full;
    }

    public static void clearRow() {//every time tick check entire board for full lines before respawning a piece so that a line is add to the top before a piece is added //broken
        int fullRowCount = 0;
        for (int i = 0; i < gameboard.length; i++) {
            int fullCount = 0;
            for (int j = 0; j < gameboard[i].length; j++) {
                if (gameboard[i][j] > 0) {
                    fullCount += 1;
                }
            }
            if (fullCount == gameboard[i].length) {
                fullRowCount += 1;
                for (int j = 0; j < gameboard[i].length; j++) {
                    gameboard[i][j] = 0;
                }
            }
        }
        if (fullRowCount > 0) {
            addRow(fullRowCount);
        }

    }

    public static void addRow(int amount) {//broken
        for (int i = 0; i < gameboard.length; i++) {
            for (int j = 0; j < gameboard[i].length; j++) {

            }
        }
    }

    public static void draw() { //test draw to print array
        for (int i = 0; i < gameboard.length; i++) {
            if (i < 10) {
                System.out.print(i + ":  ");
            } else {
                System.out.print(i + ": ");

            }
            for (int j = 0; j < gameboard[j].length; j++) {
                System.out.print(gameboard[i][j]);
            }
            System.out.println("");

        }

    }

    public void drawToScene(AnchorPane root) { //should take in the root then depending on the number in the slot pick what color rectangle to draw
        System.out.println("test");
        for (int i = 0; i < gameboard.length; i++) {
            for (int j = 0; j < gameboard[j].length; j++) {
                switch (gameboard[i][j]) {
                    case 1: // I
                        Color c = new Color(1, 1, 1, 1);
                        System.out.println("test2");
                        Rectangle rect = new Rectangle((25 * j) + x, (25 * i) + y, 25, 25);
                        rect.setFill(c.rgb(35, 202, 0));
                        rect.setArcHeight(10);
                        rect.setArcWidth(10);
                        System.out.println("test3");

                        root.getChildren().addAll(rect);
                        break;
                    case 2: //RL
                        Color c1 = new Color(1, 1, 1, 1);
                        Rectangle rect1 = new Rectangle((25 * j) + x, (5 * i) + y, 25, 25);
                        rect1.setFill(c1.rgb(232, 184, 9));
                        rect1.setArcHeight(10);
                        rect1.setArcWidth(10);
                        root.getChildren().addAll(rect1);
                        break;
                    case 3: //LL
                        Color c2 = new Color(1, 1, 1, 1);
                        Rectangle rect2 = new Rectangle((25 * j) + x, (25 * i) + y, 25, 25);
                        rect2.setFill(c2.rgb(227, 36, 0));
                        rect2.setArcHeight(10);
                        rect2.setArcWidth(10);
                        root.getChildren().addAll(rect2);
                        break;
                    case 4: //S
                        Color c3 = new Color(1, 1, 1, 1);
                        Rectangle rect3 = new Rectangle((25 * j) + x, (25 * i) + y, 25, 25);
                        rect3.setFill(c3.rgb(214, 0, 151));
                        rect3.setArcHeight(10);
                        rect3.setArcWidth(10);
                        root.getChildren().addAll(rect3);
                        break;
                    case 5: //Z
                        Color c4 = new Color(1, 1, 1, 1);
                        Rectangle rect4 = new Rectangle((25 * j) + x, (25 * i) + y, 25, 25);
                        rect4.setFill(c4.rgb(23, 90, 255));
                        rect4.setArcHeight(10);
                        rect4.setArcWidth(10);
                        root.getChildren().addAll(rect4);
                        break;
                    case 6: //square
                        Color c5 = new Color(1, 1, 1, 1);
                        Rectangle rect5 = new Rectangle((25 * j) + x, (25 * i) + y, 25, 25);
                        rect5.setFill(c5.rgb(202, 88, 0));
                        rect5.setArcHeight(10);
                        rect5.setArcWidth(10);
                        root.getChildren().addAll(rect5);
                        break;
                    case 7: //T
                        Color c6 = new Color(1, 1, 1, 1);
                        Rectangle rect6 = new Rectangle((25 * j) + x, (25 * i) + y, 25, 25);
                        rect6.setFill(c6.rgb(146, 0, 209));
                        rect6.setArcHeight(10);
                        rect6.setArcWidth(10);
                        root.getChildren().addAll(rect6);
                        break;
                }
            }
        }
    }

    public void drawI() {

//        timer();
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

    public void drawT() {

    }

    public void sendAnchorPane(AnchorPane root) {
//        this.root = root;
    }

    public void pickPiece() {
        Random rand = new Random();
        int n = rand.nextInt(7) + 1;
        switch (n) {
            case 1:
                type = 1;
                drawI();
                break;
            case 2:
                type = 2;
                drawRL();
                break;
            case 3:
                type = 3;
                drawLL();
                break;
            case 4:
                type = 4;
                drawS();
                break;
            case 5:
                type = 5;
                drawZ();
                break;
            case 6:
                type = 6;
                drawSquare();
                break;
            case 7:
                type = 7;
                drawT();
                break;
        }
    }

    public void timer() {

        TimerTask repeatedTask = new TimerTask() {
            public void run() {
                moveDown(startRow_index, endRow_index, startCol_index, endCol_index);

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
