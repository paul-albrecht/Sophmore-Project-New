package tetrisv2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

public class ScoresController implements Initializable {

    Stage mainStage; //main menu
    Stage prevStage; //scores scene
    public void mainStage(Stage stage) { //allows for menu controller to send to the menu scene in order to get back to main menu
        mainStage = stage;
    }
    public void prevScene(Stage stage){ //in order to close the scores menu
        prevStage = stage;
    }
    public void gotoMain() { //goes back to main menu
        mainStage.show();
        prevStage.close();
    }

    public void highsores() { //read the scores file and draw text on fxml scene
        System.out.println("Test");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }}
