package bd.edu.seu.new_one;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    public static Stage stage;
    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
    public static void changeScene(String fxml){ // parameter to open a page (ie, Login , Registration)
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource( fxml + ".fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            stage.setScene(scene);

        } catch( IOException ex){
            System.out.println("Failed to load fxml");
            ex.printStackTrace();
        }

    }
}