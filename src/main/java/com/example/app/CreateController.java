package com.example.app;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicReference;

import DataBase.Const;
import DataBase.DBHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CreateController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField birthTextField;

    @FXML
    private Button buttonCreateAnimal;

    @FXML
    private RadioButton catRadioButton;

    @FXML
    private RadioButton dogRadioButton;

    @FXML
    private RadioButton donkeyRadioButton;

    @FXML
    private RadioButton hamsterRadioButton;

    @FXML
    private RadioButton horseRadioButton;

    @FXML
    private TextField nameTextField;

    @FXML
    void initialize() {
        DBHandler dbHandler = new DBHandler();

        buttonCreateAnimal.setOnAction(actionEvent -> {
           // dbHandler.inputDataAnimal(nameTextField.getText().trim(), birthTextField.getText().trim(), chooseKind());
            buttonCreateAnimal.getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("hello-view.fxml"));
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

    public String chooseKind () {
        String kind = null;
        if (catRadioButton.isSelected()){
            kind=Const.USER_TABLE_CATS;
        }
        if (dogRadioButton.isSelected()) {
            kind=Const.USER_TABLE_DOGS;
        }
        if (hamsterRadioButton.isSelected()) {
            kind=Const.USER_TABLE_HAMSTERS;
        }
        if (donkeyRadioButton.isSelected()) {
            kind=Const.USER_TABLE_DONKEYS;
        }
        if (horseRadioButton.isSelected()) {
            kind=Const.USER_TABLE_HORSES;
        }
        return kind;
    }
}