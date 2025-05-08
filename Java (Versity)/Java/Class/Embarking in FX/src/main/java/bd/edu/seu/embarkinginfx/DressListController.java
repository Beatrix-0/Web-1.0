package bd.edu.seu.embarkinginfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class DressListController {

    @FXML
    private TextField searchField;

    @FXML
    void backEvent(ActionEvent event) {
        HelloApplication.changeScene("entry");

    }

}
