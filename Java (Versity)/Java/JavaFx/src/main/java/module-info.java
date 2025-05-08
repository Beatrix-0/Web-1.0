module bd.edu.seu.javafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens bd.edu.seu.javafx to javafx.fxml;
    exports bd.edu.seu.javafx;
}