package bd.edu.seu.dresscollection;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.ResourceBundle;


public class InputConroller implements Initializable {

    @FXML
    public TextField dressname;
    @FXML
    public Label dressnamealert ;
    @FXML
    public ChoiceBox<String> dresschoice;
    @FXML
    public Label dresstypealert ;
    @FXML
    public ComboBox<String> sizechoice;
    @FXML
    public Label sizealert;
    @FXML
    public ColorPicker colorpicker;
    @FXML
    public Label colouralert ;
    @FXML
    public Slider PriceRange;
    @FXML
    Text amount;
    @FXML
    public Label pricealert;
    @FXML
    public TextArea textarea;
    @FXML
    public Label textareaalert;
    @FXML
    public Label counter;
    @FXML
    public Spinner<Integer> quantity;
    SpinnerValueFactory<Integer> svf = new SpinnerValueFactory.IntegerSpinnerValueFactory(-100, 500, 0);
    @FXML
    public Label quantityalert;
    @FXML
    public RadioButton male;
    @FXML
    public RadioButton female;
    @FXML
    public Label choicealert;
    @FXML
    public CheckBox check;
    @FXML
    public ImageView imageSelect;
    @FXML
    public Label imagealert;
    @FXML
    DatePicker dateselect;
    @FXML
    Label datealert;
    @FXML
    PasswordField discount;
    @FXML
    Label discountalert;

    String D_name , D_Type , D_Size , D_Colour , D_Price , D_Details , D_Date;
    String D_Quantity , D_Customer , D_Boosting ;
    public static String D_Copun , D_Picture;

    boolean checkName = false ;
    @FXML
    public void DressnameAlert(){
        if(dressname.getText().isEmpty()){
            System.err.println("Dress name is not selected");
            dressnamealert.setVisible(true);
            checkName = false ;
        }else {
            // remove the alert msg
            D_name = dressname.getText();
            checkName = true;
              dressnamealert.setVisible(false);
        }
    }
    boolean checkType = false ;
    @FXML
    public void DresschoiceAlert(){
        if (dresschoice.getSelectionModel().isEmpty()){
            System.err.println("Dresstype is not selected");
            checkType = false ;
        }else {
            D_Type = dresschoice.getValue();
            checkType = true;
            dresstypealert.setVisible(false);
        }
    }
    boolean checkSize = false ;
    @FXML
    public void DressSizeAlert(){
        if( sizechoice.getValue() == null ){
            System.err.println("Dresssize is not selected");
            checkSize = false ;
        }
        else {
            D_Size = sizechoice.getValue();
            checkSize = true;
            sizealert.setVisible(false);
        }
    }
    boolean checkColour = false ;
    private String getColorName(Color color) {
        if (color.equals(Color.RED)) return "Red";
        else if (color.equals(Color.BLUE)) return "Blue";
        else if (color.equals(Color.GREEN)) return "Green";
        else if (color.equals(Color.BLACK)) return "Black";
        else if (color.equals(Color.WHITE)) return "White";
        else if (color.equals(Color.YELLOW)) return "Yellow";
        else if (color.equals(Color.PINK)) return "Pink";
        else return String.format("#%02X%02X%02X",
                    (int)(color.getRed() * 255),
                    (int)(color.getGreen() * 255),
                    (int)(color.getBlue() * 255));
    }

    @FXML
    public void DressClourAlert(){
        if(colorpicker.getValue() == null){
            System.err.println("Dress colour is not selected");
            checkColour = false ;
        }
        else {
            Color selectedColor = colorpicker.getValue();
            D_Colour = getColorName(selectedColor);
            checkColour = true;
            colouralert.setVisible(false);
        }
    }
    boolean checkPrice = false ;
    @FXML
    public void DressPriceAlert(){
        int x = (int)PriceRange.getValue();
       amount.setText(String.valueOf((int)PriceRange.getValue()));
       if ( x < 500 ){
           System.err.println("Amount is less than 500");
           pricealert.setVisible(true);
           checkPrice = false ;
       }
       else{
           D_Price = String.valueOf(x);
           checkPrice = true;
           pricealert.setVisible(false);
        }
    }
    boolean checkDetails = false ;
    @FXML
    public void DressDescriptionAlert(){
        String s = textarea.getText();
        counter.setText(String.valueOf(textarea.getLength()));
        if ( s.length() > 50){
            System.err.println("Dress description is too long");
            textareaalert.setVisible(true);
            checkDetails = false ;
        }
        else {
            D_Details = s;
            checkDetails = true;
            textareaalert.setVisible(false);
        }
    }

    boolean checkDate = false ;
    @FXML
    public void DressDateSelect(){
        LocalDate myDate = dateselect.getValue();
        LocalDate currentDate = LocalDate.now();
        if ( myDate != null && myDate.isAfter(currentDate) ) {
            datealert.setVisible(true);
            checkDate = false ;
        }
        else {
            D_Date = myDate.toString();
            checkDate = true;
            datealert.setVisible(false);
        }
    }

    boolean checkQuantity = false ;
    @FXML
    public void DressQuantityAlert(){
        int x = (int)quantity.getValue();
        if( x < 0 ){
            System.err.println("Quantity is low");
            quantityalert.setVisible(true);
            checkQuantity = false ;
        }
        else {
            D_Quantity = String.valueOf(x);
            checkQuantity = true;
            quantityalert.setVisible(false);
        }
    }

    boolean checkCopun = false;
    @FXML
    public void DressDicountAlert() {
        String s = discount.getText();
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/almari", "root", "12344321");
            String query = "SELECT 1 FROM dressdata WHERE coupon = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, s);
            ResultSet resultSet = statement.executeQuery();
            boolean exists = resultSet.next();  // true if found

            if (exists) {
                discountalert.setText("Coupon already exists!");
                discountalert.setVisible(true);
                checkCopun = false;
            } else {
                D_Copun = s;
                discountalert.setVisible(false);
                checkCopun = true;
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Coupon Exception");
            checkCopun = false;
        }
    }


    boolean checkCustomer = false ;
    @FXML
    public void DressChoiceAlert(){
        if ( male.isSelected() || female.isSelected()) {
            choicealert.setVisible(false);
            checkCustomer = true;
            if ( male.isSelected() ){
                D_Customer = "Male";
            }
            else {
                D_Customer = "Female";
            }
        }
    }

    @FXML
    public void DressBoostCheck(){
        if(check.isSelected()){
            D_Boosting = "Enable";
        }
    }

    boolean checkPicture = false ;
    //public static Image tmp_img ;
    Image  tmp_img ;
    @FXML
    public void DressImageUpload(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif")
        );
        File file = fileChooser.showOpenDialog(null);
        if(file != null){
            Image image = new Image(file.toURI().toString());
            imageSelect.setImage(image);
            tmp_img = image;
        }
        if( imageSelect != null ){
            //D_Picture = imageSelect.getImage().toString();
            D_Picture = file.toURI().toString();
            checkPicture = true;
            imagealert.setVisible(false);
        }
    }

    @FXML
    public void goToFinalScene(){
       //HelloApplication.changeScene("finalscene");
        if(checkName && checkType && checkSize && checkColour && checkPrice && checkDetails && checkDate && checkQuantity && checkCopun && checkCustomer && checkPicture ) {

            if (D_Boosting == null || D_Boosting.isEmpty()) {
                D_Boosting = "Disable";
            }
            allData d1 = new allData(D_name, D_Type, D_Colour, D_Price, D_Date, D_Quantity, D_Boosting, D_Size, D_Details, D_Customer, D_Copun , tmp_img);
            finalsceneController.allDataObservableList.add(d1);
            HelloApplication.changeScene("finalscene");
        }
    }

    public void FinalSave(){
        if(checkName && checkType && checkSize && checkColour && checkPrice && checkDetails && checkDate && checkQuantity && checkCopun && checkCustomer && checkPicture ) {
            if (D_Boosting == null || D_Boosting.isEmpty()) {
                D_Boosting = "Disable";
            }

            try{
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/almari","root","12344321");
                Statement statement = connection.createStatement();
                String query = "INSERT INTO dressdata VALUES ('" +D_name + "','" + D_Type + "','" + D_Size + "','" + D_Colour + "','" + D_Price + "','" + D_Details + "','" + D_Customer + "','" + D_Boosting + "','" + D_Copun +"');";
                statement.executeUpdate(query);
                System.out.println("Data saved successfully");
            } catch( SQLException se ){
                se.printStackTrace();
                System.out.println("SQL Exception");
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> DressOption = FXCollections.observableArrayList();
        DressOption.add("Shirt");
        DressOption.add("T-Shirt");
        DressOption.add("Hoddie");
        dresschoice.setItems(DressOption);

        ObservableList<String> Sizeoption = FXCollections.observableArrayList();
        Sizeoption.add("M");
        Sizeoption.add("L");
        Sizeoption.add("XL");
        sizechoice.setItems(Sizeoption);
        quantity.setValueFactory(svf);
    }
}
