package bd.edu.seu.new_one;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
    @FXML
    public TextField username;
    @FXML
    public PasswordField password;

    public static String LoggedEmail = "";

    @FXML
    public void LoginEvent() {
        String name = username.getText();
        String pass = password.getText();
        LoggedEmail = name;

        String n = "siam";
        String p = "1234";

        if( name.isEmpty()){
            System.err.println("Name is empty ");
        }
        else if( pass.isEmpty()){
            System.err.println("Password is empty ");
        }
        else if (  name.isEmpty() &&  name.isEmpty() ){
            System.err.println(" Info is not given ");
        }
        else {
            if(n.equals(name) && p.equals(pass)){
                HelloApplication.changeScene("dashboard");
            }
            else {
                System.err.println("Id pass is not valid");
            }
        }

    }

    @FXML
    public void goToRegisterEvent(){
        HelloApplication.changeScene("registration");
    }

}
