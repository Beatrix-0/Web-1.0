package bd.edu.seu.second_new;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class MyControl {

    @FXML
    public TextField username;

    @FXML
    public PasswordField password;

    @FXML
    public void registerEvent(){
        String name = username.getText();
        String pass = password.getText();
        System.out.println(name + " " + pass);
    }
}
