package com.example.lab2manraj;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;
import java.sql.*;

public class HelloController  implements Initializable {
    public TableView<User> userTable;
    public TableColumn <User,Integer> id;
    public TableColumn<User,String> name;
    public TableColumn<User,String> email;
    public TableColumn<User,String> password;
    public TextField uid;
    public TextField uname;
    public TextField uemail;
    public TextField upassword;

    ObservableList<User> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        id.setCellValueFactory(new PropertyValueFactory<User,Integer>("id"));
        name.setCellValueFactory(new PropertyValueFactory<User,String>("name"));
        email.setCellValueFactory(new PropertyValueFactory<User,String>("email"));
        password.setCellValueFactory(new PropertyValueFactory<User,String>("password"));
        userTable.setItems(list);


    }

    @FXML
    protected void onHelloButtonClick() {
        fethdata();
    }

    private void fethdata() {
        list.clear();

        String jdbcUrl = "jdbc:mysql://localhost:3306/lab2csd214";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "SELECT * FROM user";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            // Populate the table with data from the database
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                userTable.getItems().add(new User(id, name, email, password));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void InsertData(ActionEvent actionEvent) {


        String name = uname.getText();
        String email = uemail.getText();
        String password = upassword.getText();




        String jdbcUrl = "jdbc:mysql://localhost:3306/lab2csd214";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "INSERT INTO `user`( `name`, `email`, `password`) VALUES ('"+name+"','"+email+"','"+password+"')";
            Statement statement = connection.createStatement();
            statement.execute(query);
            // Populate the table with data from the database

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void UpdateData(ActionEvent actionEvent) {

        String id = uid.getText();
        String name = uname.getText();
        String email = uemail.getText();
        String password = upassword.getText();




        String jdbcUrl = "jdbc:mysql://localhost:3306/lab2csd214";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "UPDATE `user` SET `name`='"+name+"',`email`='"+email+"',`password`='"+password+"' WHERE id='"+id+"' ";
            Statement statement = connection.createStatement();
            statement.execute(query);
            // Populate the table with data from the database

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void DeleteData(ActionEvent actionEvent) {

        String id = uid.getText();




        String jdbcUrl = "jdbc:mysql://localhost:3306/lab2csd214";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "DELETE FROM `user` WHERE id='"+id+"'";
            Statement statement = connection.createStatement();
            statement.execute(query);
            // Populate the table with data from the database

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void LoadData(ActionEvent actionEvent) {

        String id = uid.getText();

        String jdbcUrl = "jdbc:mysql://localhost:3306/lab2csd214";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "SELECT * FROM user WHERE id='"+id+"'";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            // Populate the table with data from the database
            while (resultSet.next()) {

                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");

                uname.setText(name);
                uemail.setText(email);
                upassword.setText(password);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    }
