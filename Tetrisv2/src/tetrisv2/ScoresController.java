package tetrisv2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.Scanner;
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

    public void highsores() throws Exception { //read the scores file and draw text on fxml scene
        String scoresArray[][] = new String[5][2];
        ArrayList<String> score = new ArrayList<>();
        try {
            FileReader file = new FileReader("score.txt");
            Scanner s = new Scanner(file);
            while (s.hasNext()) {
                score.add(s.next());
            }
            file.close();
        } catch (Exception e) {
        }

        String list2[] = new String[score.size()];
        list2 = score.toArray(list2);
        for (int i = 0; i < scoresArray.length - 2; i++) {
            for (int j = 0; j < scoresArray[i].length; j++) {
                if (j == 0) {
                    scoresArray[i][j] = list2[i];
                } else {
                    scoresArray[i][j] = list2[i + 1];
                }
            }
        }
        for(int i = 0; i < scoresArray.length; i++){
            for(int j = 0; j < scoresArray[i].length; j++){
                System.out.println(Arrays.toString(scoresArray[i]));
            }
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }}
