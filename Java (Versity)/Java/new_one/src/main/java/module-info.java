module bd.edu.seu.new_one {
    requires javafx.controls;
    requires javafx.fxml;


    opens bd.edu.seu.new_one to javafx.fxml;
    exports bd.edu.seu.new_one;
}