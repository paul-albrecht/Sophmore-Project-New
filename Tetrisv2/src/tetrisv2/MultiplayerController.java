package tetrisv2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

//gameboard 
//width 621
//height 620
//x 195
//y 92
public class MultiplayerController implements Initializable {

    Stage mainStage; //main menu
    Stage prevStage; //multiplayer scene

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

    public void pause() { //make pause
        prevStage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

}
