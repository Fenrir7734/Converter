package org.example.controllers;

import javafx.event.ActionEvent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import org.example.converter.NumberSystemConverter;

public class ConverterController {
    private final ObservableList<Integer> systems = FXCollections.observableArrayList();
    private final NumberSystemConverter numberSystemConverter = new NumberSystemConverter();

    @FXML private ChoiceBox<Integer> fromSystemChoiceBox;
    @FXML private ChoiceBox<Integer> toSystemChoiceBox;

    @FXML private TextField numberTextField;
    @FXML private TextField resultTextField;

    @FXML private Button calculateButton;

    @FXML
    public void initialize() {
        for (int i = 2; i <= 36; i++) {
            systems.add(i);
        }

        fromSystemChoiceBox.setItems(systems);
        fromSystemChoiceBox.setValue(systems.get(0));

        toSystemChoiceBox.setItems(systems);
        toSystemChoiceBox.setValue(systems.get(0));
    }

    @FXML
    public void pressButton(ActionEvent event) {
        numberSystemConverter.setFrom(fromSystemChoiceBox.getValue());
        numberSystemConverter.setTo(toSystemChoiceBox.getValue());
        numberSystemConverter.setNumber(numberTextField.getText());

        if(!numberSystemConverter.checkEnteredNumber()) {   //if the number cannot be written to the given system, the function is aborted
            numberTextField.setText("Incorrect Data");
            return;
        }

        numberSystemConverter.convert();
        resultTextField.setText(numberSystemConverter.getResult());
    }
}
