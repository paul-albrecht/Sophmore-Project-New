
package tetrisv2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

//gameboard rectangle
//width 496
//height 620
//x 245
//y 82
public class SecondScenev2Controller implements Initializable {

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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

}
