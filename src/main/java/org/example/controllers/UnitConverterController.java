package org.example.controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import org.example.converter.Converter;
import org.example.converter.TemperatureConverter;
import org.example.converter.UnitConverter;
import org.example.units.Unit;
import org.example.units.Units;
import org.example.units.UnitsCategory;

import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;


public class UnitConverterController implements Initializable {

    @FXML private ChoiceBox<UnitsCategory> categoryChoiceBox;
    @FXML private ChoiceBox<String> fromUnitChoiceBox;
    @FXML private ChoiceBox<String> toUnitChoiceBox;

    @FXML private TextField numberTextField;
    @FXML private TextField resultTextField;

    @FXML private Button calculateButton;

    private Converter converter;

    @FXML
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        this.converter = new UnitConverter();

        ObservableList<UnitsCategory> categoryList = FXCollections.observableArrayList();
        categoryList.addAll(Arrays.asList(UnitsCategory.values()));

        categoryChoiceBox.setItems(categoryList);

        categoryChoiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, currentCategory) -> {
            choiceConverter(currentCategory);
            addUnitsToConverter(Units.allUnits.get(currentCategory), Units.allBaseUnit.get(currentCategory));
            resultTextField.setText("");
            numberTextField.setText("");
        });
    }

    @FXML
    public void pressButton() {
        try {
            converter.setFrom(fromUnitChoiceBox.getValue());
            converter.setTo(toUnitChoiceBox.getValue());
            converter.setNumber(new BigDecimal(numberTextField.getText()));
            converter.convert();
            resultTextField.setText(converter.getResult());
        } catch (Exception e) {
            numberTextField.setText("Incorrect Data");
        }
    }

    private void choiceConverter(UnitsCategory category) {
        if(category.equals(UnitsCategory.TEMPERATURE)) {
            this.converter = new TemperatureConverter();
        } else {
            this.converter = new UnitConverter();
        }
    }

    private void addUnitsToConverter(ArrayList<Unit> units, String baseUnit) {
        ObservableList<String> o = FXCollections.observableArrayList();

        for(Unit unit: units) {
            o.add(unit.getUnit());
        }

        fromUnitChoiceBox.setItems(o);
        toUnitChoiceBox.setItems(o);

        converter.setBaseUnit(baseUnit);
        converter.setUnits(units);
    }
}