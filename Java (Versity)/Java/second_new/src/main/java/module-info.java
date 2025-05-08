module bd.edu.seu.second_new {
    requires javafx.controls;
    requires javafx.fxml;


    opens bd.edu.seu.second_new to javafx.fxml;
    exports bd.edu.seu.second_new;
}