package tetrisv2;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.Node;
//10x16
//[[0000000000000],
// [0000000000000],
 //[0000000000000],
// [0000000000000],]
//create a gameboard  bounds so that shape cant move past edge of screen
public class TShape {

    int centerX, centerY;
    int length;
    boolean collison;
    int cPiecex, lPiecex, rPiecex, tPiecex;
    int cPiecey, lPiecey, rPiecey, tPiecey;
    static Piece TShape[] = new Piece[4];

    TShape(int centerx, int centery, int length) {
        centerX = centerx;
        centerY = centery;
        this.length = length;
        setPieceXY();
        buildLshape();
    }

    public static void TShapeDraw(Pane root) {
        for (int i = 0; i < 4; i++) {
            root.getChildren().add(TShape[i]);
        }
    }

    private void setPieceXY() {
        cPiecex = centerX;
        cPiecey = centerY;
        lPiecex = centerX - length;
        lPiecey = centerY;
        rPiecex = centerX + length;
        rPiecey = centerY;
        tPiecex = centerX;
        tPiecey = centerY - length;
    }

    private void buildLshape() {
        TShape[0] = new Piece(centerX, centerY, length, Color.BLACK);
        TShape[1] = new Piece(lPiecex, lPiecey, length, Color.BLACK);
        TShape[2] = new Piece(rPiecex, rPiecey, length, Color.BLACK);
        TShape[3] = new Piece(tPiecex, tPiecey, length, Color.BLACK);

    }

     public void moveLeft() {
         
        setCenterX(centerX - length);
    }

     public void moveRight() {
        TShape[0].setTranslateX(TShape[0].getTranslateX() + length);
    }

     void moveUp() {
        TShape[0].setTranslateY(TShape[0].getTranslateY() - length);
    }

     void moveDown() {
        TShape[0].setTranslateY(TShape[0].getTranslateY() + length);
    }

    public int getCenterX() {
        return centerX;
    }

    public  void setCenterX(int x) {
        centerX = x;
    }

    public int getCenterY() {
        return centerY;
    }

    public void setCenterY(int y) {
        centerY = y;
    }

    public int getcPiecex() {
        return cPiecex;
    }

    public int getlPiecex() {
        return lPiecex;
    }

    public int getrPiecex() {
        return rPiecex;
    }

    public int gettPiecex() {
        return tPiecex;
    }

    public int getcPiecey() {
        return cPiecey;
    }

    public int getlPiecey() {
        return lPiecey;
    }

    public int getrPiecey() {
        return rPiecey;
    }

    public int gettPiecey() {
        return tPiecey;
    }

}
