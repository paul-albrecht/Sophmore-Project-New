/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication3;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import java.io.FileInputStream;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SecondSceneController implements Initializable {

    Stage prevStage;
    Stage mainStage;
    public void mainStage(Stage stage){
        mainStage = stage;
    }
    public void prevScene(Stage stage){ //in order to close the singleplayer menu
        prevStage = stage;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  

    public void gotoMain(){
        mainStage.show();
        prevStage.close();
    }
    
    public void exit(){
        prevStage.close();
    }
    public void highsores(){
        System.out.println("Test");
    }    
    
    
    
}
