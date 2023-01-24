package com.example.app;

import DataBase.Const;
import DataBase.DBHandler;
import animals.Cat;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    Cat cat = new Cat();
    @FXML
    private Button createAnimal;
    @FXML
    private TextField textField_countCat;

    @FXML
    private TextField textField_countDog;

    @FXML
    private TextField textField_countDonkey;

    @FXML
    private TextField textField_countHamster;

    @FXML
    private TextField textField_countHorse;

    @FXML
    void initialize() {
        DBHandler dbHandler = new DBHandler();
        textField_countCat.setText(dbHandler.countPerAnimal(Const.USER_TABLE_CATS));
        textField_countDog.setText(dbHandler.countPerAnimal(Const.USER_TABLE_DOGS));
        textField_countHamster.setText(dbHandler.countPerAnimal(Const.USER_TABLE_HAMSTERS));
        textField_countDonkey.setText(dbHandler.countPerAnimal(Const.USER_TABLE_DONKEYS));
        textField_countHorse.setText(dbHandler.countPerAnimal(Const.USER_TABLE_HORSES));

        createAnimal.setOnAction(actionEvent -> {
            createAnimal.getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("create-view.fxml"));
            try {
                fxmlLoader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Parent root = fxmlLoader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });
    }

}