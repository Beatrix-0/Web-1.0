package bd.edu.seu.new_one;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {

    @FXML
    public Label Emailname ;

    @FXML
    public void goToLoginEvent(){
        // System.out.println("Now in Register Page");
        HelloApplication.changeScene("Login");
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Emailname.setText(LoginController.LoggedEmail);
        System.out.println(Emailname);
    }
}
