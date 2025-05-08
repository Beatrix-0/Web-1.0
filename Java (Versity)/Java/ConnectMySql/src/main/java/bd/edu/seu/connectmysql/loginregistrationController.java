package bd.edu.seu.connectmysql;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class loginregistrationController {

    @FXML
    private PasswordField l_pin;

    @FXML
    private TextField l_username;

    @FXML
    private TextField r_login;

    @FXML
    private TextField r_phone;

    @FXML
    private PasswordField r_pin;


    public void actionLogin(){
        String username = this.l_username.getText();
        String pin = this.l_pin.getText();
        System.out.println(username + " " + pin );
    }

    public void actionRegister(){
        String username = this.r_login.getText();
        String number = this.r_phone.getText();
        String password = this.r_pin.getText();
        //System.out.println(username + " " + number + " " + password);

        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/almari","root","12344321");
            Statement statement = connection.createStatement();
            // INSERT INTO register VALUES( 'Siam' , '0165' , '2322');

            String query = "INSERT INTO register VALUES ('" +username + "','" + number + "','" + password + "');";
            System.out.println(query);
            statement.executeUpdate(query);
            System.out.println("User registered successfully");
        } catch( SQLException se ){
            se.printStackTrace();
            System.out.println("SQL Exception");
        }

    }

}
