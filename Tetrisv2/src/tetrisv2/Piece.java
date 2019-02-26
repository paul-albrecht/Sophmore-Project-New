/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetrisv2;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Piece extends Rectangle{
        Color color;
        Piece(int x, int y, int length, Color color) {
            super(length, length, color);
            super.setX(x);
            super.setY(y);
//            setTranslateX(x);
//            setTranslateY(y);
        }
    public void setColor(Color color) {
        this.color = color;
    }
//        void moveLeft() {
//            setTranslateX(getTranslateX() - 5);
//        }
//
//        void moveRight() {
//            setTranslateX(getTranslateX() + 5);
//        }
//
//        void moveUp() {
//            setTranslateY(getTranslateY() - 5);
//        }
//
//        void moveDown() {
//            setTranslateY(getTranslateY() + 5);
//        }


}
