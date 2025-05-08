package bd.edu.seu.dresscollection;

import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class finalsceneController implements Initializable {
    @FXML
    public Label logout;
    @FXML
    public void goToInputScene(){

        HelloApplication.changeScene("input");
    }

    @FXML
    private TableView<allData> dataTable;
    @FXML
    private TableColumn<allData,String> nameColumn;
    @FXML
    private TableColumn<allData,String> typeColumn;
    @FXML
    private TableColumn<allData,String> colorColumn;
    @FXML
    private TableColumn<allData,String> priceColumn;
    @FXML
    private TableColumn<allData,String> dateColumn;
    @FXML
    private TableColumn<allData,String> quantityColumn;
    @FXML
    private TableColumn<allData,String> boostColumn;

    @FXML
   // public static ObservableList<allData> allDataObservableList;
    public static ObservableList<allData> allDataObservableList = FXCollections.observableArrayList();

    @FXML
    Label dressNameLast ;
    @FXML
    Label dressType;
    @FXML
    Label dressSize ;
    @FXML
    Label dressColor;
    @FXML
    Label dressPrice ;
    @FXML
    Label dressDetails;
    @FXML
    Label dressDate ;
    @FXML
    Label dressQuantity;
    @FXML
    Label dressCustomer ;
    @FXML
    Label dressBoost;
    @FXML
    ImageView imageSet;

    @FXML
    private Button toggleButton;
    @FXML
    private Label shownPassword;
    @FXML
    Label q_alert;
    @FXML
    Label priceMark;

    @FXML
    void alertFeature() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Feature Notice");
        alert.setHeaderText(null);
        alert.setContentText("Feature is coming soon!");
        alert.showAndWait();
    }



    private boolean isCouponVisible = false;
    @FXML
    void seeCoupon() {
        if (isCouponVisible) {
            shownPassword.setText("*****");
            toggleButton.setText("Show");
        } else {
            shownPassword.setText(InputConroller.D_Copun);
            toggleButton.setText("Hide");
        }
        isCouponVisible = !isCouponVisible;
    }

    String quantity ;
    void checkQuantity() {
        int cnt = Integer.parseInt(quantity);
        if (cnt < 10) {
            q_alert.setStyle("-fx-text-fill: red;");
            dressQuantity.setStyle("-fx-text-fill: red;");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nameColumn.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getName()));
        typeColumn.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getType()));
        colorColumn.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getColor()));
        priceColumn.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getPrice()));
        dateColumn.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getDate()));
        quantityColumn.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getQuantity()));
        boostColumn.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getBoost()));

        dataTable.setItems(allDataObservableList);

        if (!allDataObservableList.isEmpty()) {
            allData lastData = allDataObservableList.get(allDataObservableList.size() - 1);
            dressNameLast.setText(lastData.getName());
            dressType.setText(lastData.getType());
            dressColor.setText(lastData.getColor());
            dressPrice.setText(lastData.getPrice());
            dressDetails.setText(lastData.getDetails());
            dressDate.setText(lastData.getDate());
            dressQuantity.setText(lastData.getQuantity());
            dressBoost.setText(lastData.getBoost());
            dressCustomer.setText(lastData.getCustomer());
            dressSize.setText(lastData.getSize());
            imageSet.setImage(lastData.getImage());
            quantity = lastData.getQuantity();
        }

        shownPassword.setText("*****");
        toggleButton.setText("Show");
        checkQuantity();
        dressPrice.setStyle("-fx-font-weight: bold;");
        priceMark.setStyle("-fx-font-weight: bold;");



    }

}
