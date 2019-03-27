package tetrisv2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

//Shape class built by piece has a method to get piece x and y collisoin check an array if 
//an entire line is full if it is add length of side to x above line if collison is detected
//drop new piece
public class Tetrisv2 extends Application {

    private Pane root = new Pane();

    private Parent createScene() { //might not need could just add to start
        root.setPrefSize(800, 600);
        return root;
    }

    @Override
    public void start(Stage stage) throws FileNotFoundException, IOException {
        Font.loadFont(getClass().getResourceAsStream("./src/tetrisv2/fonts/Tetris.ttf"), 14);
        //loads main menu
        FXMLLoader loader = new FXMLLoader();
        String fxmlDocPath = "build/classes/tetrisv2/Menuv2.fxml";
        FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
        root = (Pane) loader.load(fxmlStream);

        Scene scene = new Scene(createScene());
        //sends main menu to menu controller
        Menuv2Controller controller = (Menuv2Controller) loader.getController();
        controller.setPrevStage(stage);
//        root.setOnKeyPressed(new EventHandler<KeyEvent>() {
//            @Override
//            public void handle(KeyEvent e) {
//                if (e.getCode() == KeyCode.A) {
//                    System.out.println("A");
//                }
//            }
//        });
        //add css and shows menu scene
        scene.getStylesheets().addAll(this.getClass().getResource("MenuStyle.css").toExternalForm());

        stage.setScene(scene);
        stage.setTitle("Main Menu");
        stage.show();
        
        stage.setOnCloseRequest(event -> System.exit(0));
    }

    
    
    
    public static void main(String[] args) {
        launch(args);
    }
}
