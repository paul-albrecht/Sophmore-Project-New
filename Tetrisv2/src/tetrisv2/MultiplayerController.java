package tetrisv2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class MultiplayerController implements Initializable {

    int x = 200; // +5 for border
    int y = 75;
    GameBoard board = new GameBoard(x, y);
    Stage mainStage; //main menu
    Stage prevStage; //multiplayer scene
    AnchorPane root;

    public void mainStage(Stage stage) { //allows for menu controller to send to the menu scene in order to get back to main menu
        mainStage = stage;
    }

    public void prevScene(Stage stage) { //in order to close the multiplayer menu
        prevStage = stage;
    }

    public void gotoMain() { //goes back to main menu
        mainStage.show();
        prevStage.close();
    }

    public void pause() throws Exception { //make pause
//        prevStage.close();
        board.timerPause();
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
