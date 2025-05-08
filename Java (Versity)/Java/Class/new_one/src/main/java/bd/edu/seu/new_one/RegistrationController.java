package bd.edu.seu.new_one;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegistrationController {
    @FXML
    public TextField nameField;
    @FXML
    public TextField emailField;
    @FXML
    public PasswordField passwordField;

    @FXML
    public void registerEvent(){
        String name = nameField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();

        System.out.println("Sign up completed");
    }


    @FXML
    public void goToLoginEvent(){
        // System.out.println("Now in Login Page");
        HelloApplication.changeScene("Login");
    }

}
