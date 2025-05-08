package bd.edu.seu.embarkinginfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import jdk.dynalink.beans.StaticClass;

import java.io.IOException;

public class HelloApplication extends Application {


    static Stage stage; // changeScene stage er jonne global variable declare

    @Override
    public void start(Stage stage) throws IOException {

        this.stage = stage; // classer stage = parameter stage

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("entry.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 650);
        stage.setTitle("");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public static void changeScene(String fxml) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxml + ".fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 650);
            stage.setScene(scene); // ai stage ke  pawar jonnei global stage khula hoise
        } catch (IOException ex) {
            System.out.println("Failed to FXML file load.");
            ex.printStackTrace();
        }
    }

}
