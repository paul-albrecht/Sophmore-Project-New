package tetrisv2;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

//gameboard rectangle
//width 496
//height 620
//x 245
//y 82
public class SecondScenev2Controller implements Initializable {

    GameBoard board = new GameBoard(245, 82, 496, 620);
    Stage prevStage; //single player scene
    Stage mainStage; //main menu

    public void mainStage(Stage stage) { //in order to get back to main menu
        mainStage = stage;
    }

    public void prevScene(Stage stage) { //in order to close the singleplayer menu
        prevStage = stage;
    }

    public void gotoMain() { //goes back to main menu
        mainStage.show();
        prevStage.close();
    }

    public void pause() { //make pause
        prevStage.close();
    }

    public void pickPiece() {
        Random rand = new Random();
        int n = rand.nextInt(6);
        switch (n) {
            case 0:
                board.drawI();
                break;
            case 1:
                board.drawRL();
                break;
            case 2:
                board.drawLL();
                break;
            case 3:
                board.drawS();
                break;
            case 4:
                board.drawZ();
                break;
            case 5:
                board.drawSquare();
                break;
        }
    }

    public void timer() {
        TimerTask repeatedTask = new TimerTask() {
            public void run() {
                if(board.checkZero()){
                    board.moveDown();
                }
            }
        };
        Timer timer = new Timer("Timer");

        long delay = 1000L;
        long period = 1000L;
        timer.scheduleAtFixedRate(repeatedTask, delay, period);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

}
