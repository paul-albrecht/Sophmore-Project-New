/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication3;

import java.io.FileInputStream; 
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class JavaFXApplication3 extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader loader = new FXMLLoader();
        String fxmlDocPath = "build/classes/javafxapplication3/Menu.fxml";
        FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
        AnchorPane root = (AnchorPane) loader.load(fxmlStream);
        
        MenuController controller = (MenuController) loader.getController();
        controller.setPrevStage(primaryStage);
        
        
        Scene scene = new Scene(root);
  
        
        
        primaryStage.setScene(scene);
        primaryStage.setTitle("Main Menu");
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
    
}
