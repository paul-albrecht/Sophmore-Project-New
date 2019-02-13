/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication3;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import java.io.FileInputStream;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.*; 
import java.util.Scanner; 

public class MenuController implements Initializable {
    Stage prevStage;
    
    public void setPrevStage(Stage stage){ //needed to close the menu when switching scenes
        prevStage = stage;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }   
    public void gotoSceneTwo() throws IOException{ //loads the second scene, adds to stage, shows, closes menu, sends the stage to secondscene controller
        Stage stage = new Stage();
        
        FXMLLoader loader = new FXMLLoader();
        String fxmlDocPath = "build/classes/javafxapplication3/SecondScene.fxml";
        FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
        AnchorPane root = (AnchorPane) loader.load(fxmlStream);
    
        Scene scene = new Scene(root);
  
        SecondSceneController controller = (SecondSceneController) loader.getController();
        controller.mainStage(prevStage); //sents main menu to second controller in order to return to main
        
        stage.setScene(scene);
        stage.setTitle("Single Player");
        controller.prevScene(stage);
        prevStage.close();
        stage.show();

    }
    public void exit(){ //adds function to exit button
        prevStage.close();
    }
    public void highsores(){ //test 
        System.out.println("Test");
//        try{
//        File highscores = new File("/highscores.txt");
//        }catch(FileNotFoundException e){
//        Scanner sc = new Scanner(highscores);
//        }
//        while(sc.hasNextLine()){
//            System.out.println(sc.nextLine());
//        }
    }
   
}
