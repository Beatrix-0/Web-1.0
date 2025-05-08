module bd.edu.seu.embarkinginfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires jdk.dynalink;
    requires java.desktop;


    opens bd.edu.seu.embarkinginfx to javafx.fxml;
    exports bd.edu.seu.embarkinginfx;
}