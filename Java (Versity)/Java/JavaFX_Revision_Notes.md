# JavaFX & Java Revision Notes

---

## Table of Contents

- [JavaFX \& Java Revision Notes](#javafx--java-revision-notes)
  - [Table of Contents](#table-of-contents)
  - [1. ChoiceBox, ComboBox \& Spinner (Basic Usage)](#1-choicebox-combobox--spinner-basic-usage)
  - [2.Alert Dialog (Information Alert)](#2alert-dialog-information-alert)
  - [3. ImageView – Load Image from File](#3-imageview--load-image-from-file)
  - [4. DatePicker (Basic Usage)](#4-datepicker-basic-usage)
  - [5. PasswordField (Basic Usage)](#5-passwordfield-basic-usage)
  - [6. TextArea (Basic Usage)](#6-textarea-basic-usage)
  - [7. TextField (Basic Usage)](#7-textfield-basic-usage)
  - [8. MySQL Connection (Singleton Pattern)](#8-mysql-connection-singleton-pattern)
  - [9. Example: Insert Data into Database](#9-example-insert-data-into-database)
  - [10. TableView Setup with Columns](#10-tableview-setup-with-columns)
  - [11. Application Entry Point \& Scene Switching](#11-application-entry-point--scene-switching)
  - [12. User Login with Security Check](#12-user-login-with-security-check)

---

## 1. ChoiceBox, ComboBox & Spinner (Basic Usage)

```java
@FXML private ChoiceBox<String> dressChoice;    // ChoiceBox: no dropdown search
@FXML private ComboBox<String> sizeChoice;      // ComboBox: dropdown with typing
@FXML private Spinner<Integer> quantity;        // Spinner for numeric selection

@Override
public void initialize(URL url, ResourceBundle resourceBundle) {
    // ChoiceBox items
    ObservableList<String> dressOptions = FXCollections.observableArrayList();
    dressOptions.add("Shirt");
    dressOptions.add("T-Shirt");
    dressOptions.add("Hoodie");
    dressChoice.setItems(dressOptions);

    // ComboBox items
    ObservableList<String> sizeOptions = FXCollections.observableArrayList();
    sizeOption.add("M");
    sizeOption.add("L");
    sizeOption.add("XL");
    sizeChoice.setItems(sizeOptions);

    // Spinner value factory (min, max, initial)
    SpinnerValueFactory<Integer> svf = new SpinnerValueFactory.IntegerSpinnerValueFactory(-100, 500, 0);
    quantity.setValueFactory(svf);
}
```

## 2.Alert Dialog (Information Alert)
```java
@FXML
void alertFeature() {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Feature Notice");
    alert.setHeaderText(null);
    alert.setContentText("Feature is coming soon!");
    alert.showAndWait();
}
```
## 3. ImageView – Load Image from File
```java 
@FXML
private ImageView imageSelect;

@FXML
public void uploadImage() {
    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Select Image");
    fileChooser.getExtensionFilters().add(
        new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif")
    );

    File file = fileChooser.showOpenDialog(null);
    if (file != null) {
        Image image = new Image(file.toURI().toString());
        imageSelect.setImage(image);
    }
}
```
## 4. DatePicker (Basic Usage)
```java
@FXML
private DatePicker userBirthday;

@FXML
void handleUserBirthdayInput(ActionEvent event) {
    LocalDate U_Birthday = userBirthday.getValue();
    System.out.println("Birthday: " + U_Birthday);
}
```
## 5. PasswordField (Basic Usage)
```java
@FXML
private PasswordField userPassword;
private String U_Password;

@FXML
void handleUserPasswordInput(ActionEvent event) {
    U_Password = userPassword.getText();
    System.out.println("Password: " + U_Password);
}
```
## 6. TextArea (Basic Usage)
```java
@FXML
private TextArea userAddress;
private String U_Address;

@FXML
void handleUserAddressInput(ActionEvent event) {
    U_Address = userAddress.getText();
    System.out.println("Address: " + U_Address);
}
```
## 7. TextField (Basic Usage) 
```java
@FXML
private TextField userName;
private String U_Name;

@FXML
void handleUserNameInput(ActionEvent event) {
    U_Name = userName.getText();
    System.out.println("User Name: " + U_Name);
}
```
## 8. MySQL Connection (Singleton Pattern)
```java
public class connectionSingleton {
    private static final String DB_HOST = "localhost";
    private static final String DB_PORT = "3306";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "12344321";
    private static final String DB_NAME = "payment";
    private static final String DB_URL = "jdbc:mysql://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME;

    private static Connection connection;
    private static connectionSingleton instance = new connectionSingleton();

    private connectionSingleton(){
        try{
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        }catch(SQLException ex ){
            ex.printStackTrace();
            System.out.println("Problem in Database(connectionSingleton)");
        }
    }
    public static Connection getConnection(){
        return connection;
    }
}
```
## 9. Example: Insert Data into Database
```java
try {
    Connection connection = ConnectionSingleton.getConnection();
    Statement statement = connection.createStatement();

    String query1 = "INSERT INTO userdetails VALUES ('" + U_Name + "','" + U_Email + "','" +
                    U_Number + "','" + U_Address + "','" + U_Birthday + "');";

    String query2 = "INSERT INTO userlogincheck VALUES ('" + U_Number + "','" + U_Password + "');";

    statement.executeUpdate(query1);
    statement.executeUpdate(query2);

    System.out.println("User Registered Successfully");
} catch (Exception e) {
    e.printStackTrace();
    System.out.println("Database insertion error");
}
```
## 10. TableView Setup with Columns
```java
// AllData is a class and a constructor that holds all the user input
// Scene 01 
@FXML
    public void Save(){
            AllData d1 = new AllData(D_name, D_Type, D_Colour, D_Price, D_Date, D_Quantity, D_Boosting, D_Size, D_Details, D_Customer, D_Copun , tmp_img);
            finalsceneController.allDataObservableList.add(d1);
            HelloApplication.changeScene("finalscene");
    }

// Scene 02 
@FXML private TableView<AllData> dataTable;
@FXML private TableColumn<AllData, String> nameColumn;
@FXML private TableColumn<AllData, String> typeColumn;
@FXML private TableColumn<AllData, String> colorColumn;
@FXML private TableColumn<AllData, String> priceColumn;
@FXML private TableColumn<AllData, String> dateColumn;
@FXML private TableColumn<AllData, String> quantityColumn;
@FXML private TableColumn<AllData, String> boostColumn;

public static ObservableList<AllData> allDataObservableList = FXCollections.observableArrayList();

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
}

```
## 11. Application Entry Point & Scene Switching
```java
public class HelloApplication extends Application {
    public static Stage stage;
    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Input.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 750, 650);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public static void changeScene(String fxml){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxml + ".fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 750, 650);
            stage.setScene(scene);

        }catch(IOException ex ){
            System.out.println("Error loading fxml");
            ex.printStackTrace();
        }
    }
}
```
## 12. User Login with Security Check
```java
@FXML
void doLogin(ActionEvent event) {
    try {
        // Get connection from Singleton
        Connection connection = ConnectionSingleton.getConnection();
        Statement statement = connection.createStatement();

        String givenPhone = loginPhone.getText();
        String givenPin = loginPin.getText();

        String query = "SELECT * FROM register";
        ResultSet resultSet = statement.executeQuery(query);

        boolean ok = false;
        while (resultSet.next()) {
            String phone = resultSet.getString("mobile");
            String pin = resultSet.getString("pin");

            if (givenPhone.equals(phone) && givenPin.equals(pin)) {
                System.out.println("Login Successful");
                ok = true;
                break;
            }
        }
        if (!ok) {
            System.out.println("Login Failed");
        }

    } catch (SQLException ex) {
        ex.printStackTrace();
    }

    HelloApplication.changeScene("newPage");
}
```
