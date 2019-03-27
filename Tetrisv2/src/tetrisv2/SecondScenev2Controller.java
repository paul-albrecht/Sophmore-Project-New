package tetrisv2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SecondScenev2Controller implements Initializable {

    int x = 275; // +5 for border
    int y = 73;

    GameBoard board = new GameBoard(x, y);
    Stage prevStage; //single player scene
    Stage mainStage; //main menu
    AnchorPane root;

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

    public void pause(){ //make pause
        board.timerPause();
    }
    public void resume(){
        board.resume();
    }
    public void Start() {
        board.drawToScene();
        board.timer(root);

    }

    public void sendAnchorPane(AnchorPane root) { //gets root which allows for the shape to be drawn on scene
        this.root = root;
        board.sendAnchorPane(root);
    }

    public void sendKeyCode(String s) { //receivce key from menu
        board.sendKeyCode(s);
    }
//
//    public void spawnPiece() {
//        board.pickPiece();
//    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

}
