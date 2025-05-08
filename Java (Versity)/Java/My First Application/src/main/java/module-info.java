module bd.edu.seu.my_first_application {
    requires javafx.controls;
    requires javafx.fxml;


    opens bd.edu.seu.my_first_application to javafx.fxml;
    exports bd.edu.seu.my_first_application;
}