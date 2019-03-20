package tetrisv2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

//gameboard rectangle
//width 496
//height 620
//x 245
//y 82
public class SecondScenev2Controller implements Initializable {

    int x = 275;
    int y = 73;
    int width = 260;
    int height = 510;
    GameBoard board = new GameBoard(x, y, width, height);
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

    public void pause() { //make pause
//        prevStage.close();
        board.drawToScene(root);

    }

    public void sendAnchorPane(AnchorPane root) { //gets root which allows for the shape to be drawn on scene
        this.root = root;
    }
//
//    public void spawnPiece() {
//        board.pickPiece();
//    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

}
