package tetrisv2;

import java.util.Random;
import java.util.Timer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class GameBoard { // error check moving left and right for all pieces

     int gameboard[][]
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
    int x = 0;
    int y = 0;
    int squareSize = 25;

    boolean run = true;
//    Timer timer = new Timer("Timer");
    int startRow_index = 2;
    int endRow_index = 3;
    int startCol_index = 3;
    int endCol_index = 5;
    int type = 1;

    AnchorPane root = new AnchorPane();
    String key;
    Group rectGroup = new Group();
    Pane rectPane = new Pane();
    int count = 0;
    Timeline timeline = new Timeline(new KeyFrame(Duration.millis(500), new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent t) {

            System.out.println("Time: " + timeline.getCurrentTime());
            moveDown(startRow_index, endRow_index, startCol_index, endCol_index);
            drawToScene();
            if (timeline.getRate() != 1) {
                timeline.setRate(1);
            }
        }
    }));

    GameBoard(int x, int y) {
        this.x = x;
        this.y = y;
//        drawToScene();

        System.out.println("    0123456789");
        draw();
        System.out.println();
        System.out.println("    0123456789");
        draw();
    }

    public void moveRight(int startRow, int endRow, int startCol, int endCol) { //&& gameboard[i + 1][j + 1] == 0 when top row is blocked but bottom isnt
        boolean moved = false;
        boolean edge = false;

        for (int i = endRow; i >= startRow; i--) {
            for (int j = endCol; j >= startCol; j--) { //left to right all other pieces
                if (j + 1 <= gameboard[0].length - 1) {
                    if (gameboard[i][j + 1] == 0) {
                        if (gameboard[i][j] > 0) {
                            int temp = gameboard[i][j];
                            gameboard[i][j] = 0;
                            gameboard[i][j + 1] = temp;
                            moved = true;
                        }
                    } else {
                        moved = false;
                    }
                    edge = false;
                } else {
                    edge = true;
                    break;
                }

            }
            if (edge) {
                break;
            }
        }
        if (moved && (endCol + 1 <= gameboard[0].length - 1)) {
            startCol_index++;
            endCol_index++;
        }
        
        rectGroup.getChildren().clear();
        drawToScene();

    }

    public void moveLeft(int startRow, int endRow, int startCol, int endCol) { //&& gameboard[i - 1][j-1] == 0 when top row is blocked but bottom isnt

        boolean moved = false;
        boolean edge = false;
        for (int i = endRow; i >= startRow; i--) {
            for (int j = startCol; j <= endCol; j++) {
                if (j - 1 >= 0) {
                    if (gameboard[i][j - 1] == 0) {
                        if (gameboard[i][j] > 0) {
                            int temp = gameboard[i][j];
                            gameboard[i][j] = 0;
                            gameboard[i][j - 1] = temp;
                            moved = true;
                        }
                    } else {
                        moved = false;
                    }
                    edge = false;
                } else {
                    edge = true;
                    break;
                }
            }

            if (edge) {
                break;
            }
        }
        if (moved && (startCol - 1 >= 0)) {
            startCol_index--;
            endCol_index--;
        }

        rectGroup.getChildren().clear();
        drawToScene();

    }

    public void moveDown(int startRow, int endRow, int startCol, int endCol) { //takes in the top/bottom and left/right bounds should work with all pieces
//        boolean filled = false;
        boolean moved = false;
        boolean edge = false;
        for (int i = endRow; i >= startRow; i--) {
            for (int j = startCol; j <= endCol; j++) {
                if (i + 1 <= gameboard.length - 1) {
                    if (gameboard[i][j] > 0) {
                        if (gameboard[i + 1][j] == 0) {
                            if (i == endRow) {
                                if (!checkRow(endRow, startCol)) {
                                    int temp = gameboard[i][j];
                                    gameboard[i][j] = 0;
                                    gameboard[i + 1][j] = temp;
                                    moved = true;
                                } else {
                                    edge = true;
                                    break;
                                }
                            } else {
                                int temp = gameboard[i][j];
                                gameboard[i][j] = 0;
                                gameboard[i + 1][j] = temp;
                                moved = true;
                            }
                        } else {
                            edge = true;
                            break;
                        }
                    }
                } else {
                    edge = true;
                    break;
                }
            }
            if (edge) {
                timeline.pause();
                break;
            }
        }
        if (moved && (endRow + 1 <= gameboard.length - 1)) {
            startRow_index++;
            endRow_index++;
        }
        if (edge) {
            pickPiece();
        }
        rectGroup.getChildren().clear();
        drawToScene();
    }

    public static void rotate() {

    }

    public boolean checkRow(int endRow, int startCol) { //wont work when rotating is added
        boolean full = false;
        if (type == 4) {
            if ((gameboard[endRow + 1][startCol] != 0 && (gameboard[endRow + 1][startCol] != type)) || (gameboard[endRow + 1][startCol + 1] != 0 && (gameboard[endRow + 1][startCol + 1] != type)) || (gameboard[endRow][startCol + 2] != 0 &&  (gameboard[endRow][startCol + 2] != type))) {
//                if ((gameboard[endRow + 1][startCol] != type) || (gameboard[endRow + 1][startCol + 1] != type) || (gameboard[endRow][startCol + 2] != type)) {
                    full = true;
//                }
            }
        } else if (type == 5) {
            if ((gameboard[endRow][startCol] != 0 && (gameboard[endRow][startCol] != type)) || (gameboard[endRow + 1][startCol + 1] != 0 && (gameboard[endRow + 1][startCol + 1] != type)) || (gameboard[endRow][startCol + 2] != 0 && (gameboard[endRow][startCol + 2] != type))) {
//                if ((gameboard[endRow][startCol] != type) || (gameboard[endRow + 1][startCol + 1] != type) || (gameboard[endRow][startCol + 2] != type)) {
                    full = true;
//                }
            }
        } else if (type == 7) {
            if ((gameboard[endRow + 1][startCol] != 0 && gameboard[endRow + 1][startCol] != type) || (gameboard[endRow + 1][startCol + 1] != 0 && gameboard[endRow + 1][startCol + 1] != type) || (gameboard[endRow + 1][startCol + 2] != 0 && gameboard[endRow + 1][startCol + 2] != type )) {
//                if ((gameboard[endRow + 1][startCol] != type) || (gameboard[endRow + 1][startCol + 1] != type) || (gameboard[endRow + 1][startCol + 2] != type)) {
                    full = true;
//                }
            }
        }  else if (type == 1) {
            if ((gameboard[endRow + 1][startCol] != 0 && gameboard[endRow + 1][startCol] != type)){
//                if ((gameboard[endRow + 1][startCol] != type) || (gameboard[endRow + 1][startCol + 1] != type) || (gameboard[endRow + 1][startCol + 2] != type)) {
                    full = true;
//                }
            }
        } else {
            if ((gameboard[endRow + 1][startCol] != 0 && gameboard[endRow + 1][startCol] != type) || (gameboard[endRow + 1][startCol + 1] != 0 && (gameboard[endRow + 1][startCol + 1] != type))) {
//                if ((gameboard[endRow + 1][startCol] != type) || (gameboard[endRow + 1][startCol + 1] != type)) {
                    full = true;
//                }
            }
        }
        return full;

    }

    public void clearRow() {//every time tick check entire board for full lines before respawning a piece so that a line is add to the top before a piece is added //broken
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

    public void addRow(int amount) {//broken
        for (int i = 0; i < gameboard.length; i++) {
            for (int j = 0; j < gameboard[i].length; j++) {

            }
        }
    }

    public void draw() { //test draw to print array
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

    public void drawToScene() { //should take in the root then depending on the number in the slot pick what color rectangle to draw
        rectGroup.getChildren().clear();
        if (root.getChildren().contains(rectPane)) {
            root.getChildren().remove(rectPane);
        }
        rectPane.getChildren().clear();
        for (int i = 0; i < gameboard.length; i++) {
            for (int j = 0; j < gameboard[j].length; j++) {
                switch (gameboard[i][j]) {
                    case 1: // I
                        Color c = new Color(1, 1, 1, 1);
                        Rectangle rect = new Rectangle((25 * j) + x, (25 * i) + y, 25, 25);
                        rect.setFill(c.rgb(35, 202, 0));
                        rect.setArcHeight(10);
                        rect.setArcWidth(10);
                        rectPane.getChildren().addAll(rect);
                        break;
                    case 2: //RL
                        Color c1 = new Color(1, 1, 1, 1);
                        Rectangle rect1 = new Rectangle((25 * j) + x, (25 * i) + y, 25, 25);
                        rect1.setFill(c1.rgb(232, 184, 9));
                        rect1.setArcHeight(10);
                        rect1.setArcWidth(10);
                        rectPane.getChildren().addAll(rect1);

                        break;
                    case 3: //LL
                        Color c2 = new Color(1, 1, 1, 1);
                        Rectangle rect2 = new Rectangle((25 * j) + x, (25 * i) + y, 25, 25);
                        rect2.setFill(c2.rgb(227, 36, 0));
                        rect2.setArcHeight(10);
                        rect2.setArcWidth(10);
                        rectPane.getChildren().addAll(rect2);

                        break;
                    case 4: //S
                        Color c3 = new Color(1, 1, 1, 1);
                        Rectangle rect3 = new Rectangle((25 * j) + x, (25 * i) + y, 25, 25);
                        rect3.setFill(c3.rgb(214, 0, 151));
                        rect3.setArcHeight(10);
                        rect3.setArcWidth(10);
                        rectPane.getChildren().addAll(rect3);

                        break;
                    case 5: //Z
                        Color c4 = new Color(1, 1, 1, 1);
                        Rectangle rect4 = new Rectangle((25 * j) + x, (25 * i) + y, 25, 25);
                        rect4.setFill(c4.rgb(23, 90, 255));
                        rect4.setArcHeight(10);
                        rect4.setArcWidth(10);
                        rectPane.getChildren().addAll(rect4);

                        break;
                    case 6: //square
                        Color c5 = new Color(1, 1, 1, 1);
                        Rectangle rect5 = new Rectangle((25 * j) + x, (25 * i) + y, 25, 25);
                        rect5.setFill(c5.rgb(202, 88, 0));
                        rect5.setArcHeight(10);
                        rect5.setArcWidth(10);
                        rectPane.getChildren().addAll(rect5);

                        break;
                    case 7: //T
                        Color c6 = new Color(1, 1, 1, 1);
                        Rectangle rect6 = new Rectangle((25 * j) + x, (25 * i) + y, 25, 25);
                        rect6.setFill(c6.rgb(146, 0, 209));
                        rect6.setArcHeight(10);
                        rect6.setArcWidth(10);
                        rectPane.getChildren().addAll(rect6);

                        break;
                }
            }
        }
        root.getChildren().addAll(rectPane);
    }

    public void drawI() {//doesnt step through the drawing 
        timeline.pause();

        startRow_index = 0;
        endRow_index = 3;
        startCol_index = 5;
        endCol_index = 5;
        gameboard[0][5] = 1;
        gameboard[1][5] = 1;
        gameboard[2][5] = 1;
        gameboard[3][5] = 1;
        drawToScene();

        timeline.play();
        System.out.println(type);
    }

    public void drawLL() {
        timeline.pause();

        startRow_index = 0;
        endRow_index = 2;
        startCol_index = 4;
        endCol_index = 5;

        gameboard[2][4] = 3;
        gameboard[0][5] = 3;
        gameboard[1][5] = 3;
        gameboard[2][5] = 3;
        drawToScene();

        timeline.play();
        System.out.println(type);
    }

    public void drawRL() {
        timeline.pause();

        startRow_index = 0;
        endRow_index = 2;
        startCol_index = 5;
        endCol_index = 6;
        gameboard[0][5] = 2;
        gameboard[1][5] = 2;
        gameboard[2][5] = 2;
        gameboard[2][6] = 2;
        drawToScene();

        timeline.play();
        System.out.println(type);
    }

    public void drawS() {
        timeline.pause();

        startRow_index = 0;
        endRow_index = 1;
        startCol_index = 4;
        endCol_index = 6;
        gameboard[0][6] = 4;
        gameboard[0][5] = 4;
        gameboard[1][5] = 4;
        gameboard[1][4] = 4;
        drawToScene();

        timeline.play();
        System.out.println(type);
    }

    public void drawZ() {
        timeline.pause();

        startRow_index = 0;
        endRow_index = 1;
        startCol_index = 4;
        endCol_index = 6;
        gameboard[0][4] = 5;
        gameboard[0][5] = 5;
        gameboard[1][5] = 5;
        gameboard[1][6] = 5;
        drawToScene();

        timeline.play();
        System.out.println(type);
    }

    public void drawSquare() {
        timeline.pause();

        startRow_index = 0;
        endRow_index = 1;
        startCol_index = 4;
        endCol_index = 5;
        gameboard[0][4] = 6;
        gameboard[0][5] = 6;
        gameboard[1][4] = 6;
        gameboard[1][5] = 6;
        drawToScene();

        timeline.play();
        System.out.println(type);
    }

    public void drawT() {
        timeline.pause();

        startRow_index = 0;
        endRow_index = 1;
        startCol_index = 4;
        endCol_index = 6;
        gameboard[0][5] = 7;
        gameboard[1][4] = 7;
        gameboard[1][5] = 7;
        gameboard[1][6] = 7;
        drawToScene();

        timeline.play();
        System.out.println(type);
    }

    public void sendAnchorPane(AnchorPane root) {
        this.root = root;
    }

    public void pickPiece() {
        Random rand = new Random();
        int n = rand.nextInt(7) + 1;
//        int n = 7;
        System.out.println(n);
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

    public void timer(AnchorPane root) {

//    timeline  = new Timeline(new KeyFrame(Duration.millis(2000), new EventHandler<ActionEvent>() {
//        @Override
//        public void handle(ActionEvent t) {
//            moveDown(startRow_index, endRow_index, startCol_index, endCol_index);
//            drawToScene();
//        }
//    }));
//
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setDelay(Duration.millis(500));
        pickPiece();
//        timeline.play();
    }

    public void timerStop() {
        timeline.stop();
        run = false;
    }

    public void timerPause(){
        timeline.pause();
    }
    public void resume(){
        timeline.play();
    }
    public void sendKeyCode(String s) { //recieves key from second scene
        System.out.println(s);
        if (s == "D") {
            moveRight(startRow_index, endRow_index, startCol_index, endCol_index);
        } else if (s == "A") {
            moveLeft(startRow_index, endRow_index, startCol_index, endCol_index);

        } else if (s == "S") {
            timeline.setRate(100); // multipe of the rate set

        }
    }//for staored when key is pressed store type and pick new piece 
    //to retreive when button is pressed set type and draw.

}
