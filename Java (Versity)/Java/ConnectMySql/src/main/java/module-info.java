module bd.edu.seu.connectmysql {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens bd.edu.seu.connectmysql to javafx.fxml;
    exports bd.edu.seu.connectmysql;
}