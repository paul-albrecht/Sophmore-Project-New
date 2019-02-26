package tetrisv2;

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

public class Menuv2Controller implements Initializable {

    Stage prevStage;//mainmenu

    public void setPrevStage(Stage stage) { //needed to close the menu when switching scenes allows the controller to have control of the menu scene
        prevStage = stage;
    }

    public void gotoSceneTwo() throws IOException { //loads the second scene, adds to stage, shows, closes menu, sends the stage to secondscene controller
        Stage stage = new Stage();

        FXMLLoader loader = new FXMLLoader();
        String fxmlDocPath = "build/classes/tetrisv2/SecondScenev2.fxml";
        FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
        AnchorPane root = (AnchorPane) loader.load(fxmlStream);

        Scene scene = new Scene(root);

        SecondScenev2Controller single_controller = (SecondScenev2Controller) loader.getController(); //sends to singleplayer controller
        single_controller.mainStage(prevStage); //sents main menu to second controller in order to return to main

        //include the prevstage method for each in order for it to receive its stage
        scene.getStylesheets().addAll(this.getClass().getResource("MenuStyle.css").toExternalForm()); //adds css
        stage.setScene(scene);
        stage.setTitle("Single Player");

        single_controller.prevScene(stage);//gives the singleplayer controller the scene
        prevStage.close();
        stage.show();

    }

    public void gotoMult() throws IOException {//loads fxml for mult page, creates scene, sends the controller the main and score scene, adds css, closes main and shows mult scene
        Stage stage = new Stage();

        FXMLLoader loader = new FXMLLoader();
        String fxmlDocPath = "build/classes/tetrisv2/Multiplayer.fxml";
        FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
        AnchorPane root = (AnchorPane) loader.load(fxmlStream);

        Scene scene = new Scene(root);

        MultiplayerController mult_controller = (MultiplayerController) loader.getController(); //sends to multiplayer controller
        mult_controller.mainStage(prevStage); //sents main menu to second controller in order to return to main

        scene.getStylesheets().addAll(this.getClass().getResource("MenuStyle.css").toExternalForm()); //adds css
        stage.setScene(scene);
        stage.setTitle("Multiplayer");

        mult_controller.prevScene(stage);//gives the singleplayer controller the scene
        prevStage.close();
        stage.show();
    }

    public void gotoScore() throws IOException { //loads fxml for score page, creates scene, sends the controller the main and score scene, adds css, closes main and shows score scene
        Stage stage = new Stage();

        FXMLLoader loader = new FXMLLoader();
        String fxmlDocPath = "build/classes/tetrisv2/Scores.fxml";
        FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
        AnchorPane root = (AnchorPane) loader.load(fxmlStream);

        Scene scene = new Scene(root);

        ScoresController score_controller = (ScoresController) loader.getController(); //sends to multiplayer controller
        score_controller.mainStage(prevStage); //sents main menu to second controller in order to return to main

        scene.getStylesheets().addAll(this.getClass().getResource("MenuStyle.css").toExternalForm()); //adds css
        stage.setScene(scene);
        stage.setTitle("Scores");

        score_controller.prevScene(stage);//gives the singleplayer controller the scene
        prevStage.close();
        stage.show();
    }

    public void exit() { //adds function to exit button
        prevStage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

}
