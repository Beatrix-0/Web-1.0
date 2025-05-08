module bd.edu.seu.tableview {
    requires javafx.controls;
    requires javafx.fxml;


    opens bd.edu.seu.tableview to javafx.fxml;
    exports bd.edu.seu.tableview;
}