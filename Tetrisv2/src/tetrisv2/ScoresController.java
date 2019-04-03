package tetrisv2;

import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.fxml.Initializable;
//<<<<<<< HEAD
import javafx.scene.text.Text;
//=======
import javafx.scene.layout.AnchorPane;
//>>>>>>> 9918f1111484ca6043b4406e7595d1d37b382d93
import javafx.stage.Stage;

public class ScoresController implements Initializable {
    AnchorPane root;
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
    public void sendRoot(AnchorPane root){
        this.root = root;
    }
    public void highsores() throws Exception { //read the scores file and draw text on fxml scene
   
       
        
       
        
        ArrayList<String> Score = new ArrayList<>();
        
        try {
            FileReader file = new FileReader("score.txt");
            Scanner s = new Scanner(file);
            while (s.hasNext()) {
                Score.add(s.next());
                
               // ScoreArray.add(Integer.parseInt(s.next()));
               // System.out.println(Score);
            }
            
           // Arrays.sort(Score);
            System.out.println((Score.get(0)));
            int s1 = Integer.parseInt(Score.get(0));
            System.out.println((Score.get(1)));
            int s2 = Integer.parseInt(Score.get(1));
            System.out.println((Score.get(2)));
            int s3 = Integer.parseInt(Score.get(2));
            System.out.println((Score.get(3)));
            int s4 = Integer.parseInt(Score.get(3));
            System.out.println((Score.get(4)));
            int s5 = Integer.parseInt(Score.get(4));
            
            
            int[] scores = {s1,s2,s3,s4,s5};
           
            //int[] ints = {3,6,3,9,1};
            Arrays.sort(scores);
            System.out.println(Arrays.toString(scores));
            
            
            
            
            file.close();
        } catch (Exception e) {
            
        }
        
      
        
        
     

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

    
}
