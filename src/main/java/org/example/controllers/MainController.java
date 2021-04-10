package org.example.controllers;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Objects;


public class MainController extends Application {

    @FXML private Button numberSystemConverterButton;
    @FXML private Button unitConverterButton;

    @FXML private Menu menu = new Menu();
    @FXML private MenuItem author = new Menu();
    @FXML private MenuItem close = new Menu();
    @FXML private Menu history = new Menu();


    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("mainSample.fxml")));
        primaryStage.setTitle("Converter");
        primaryStage.setMaxWidth(350);
        primaryStage.setMinWidth(350);
        primaryStage.setMinHeight(375);
        primaryStage.setResizable(false);
        Scene scene = new Scene(root, 350, 375);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    public void loadSystemConverter(ActionEvent event) {
        try {
            AnchorPane root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("mainSample.fxml")));
            Node child = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("converter.fxml")));
            Stage stage = (Stage) numberSystemConverterButton.getScene().getWindow();
            AnchorPane.setTopAnchor(child, 52.0);
            root.getChildren().add(child);
            Scene scene = new Scene(root, 350, 375);
            stage.setScene(scene);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    public void loadUnitConverter() {
        try {
            AnchorPane root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("mainSample.fxml")));
            Node child = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("unitConverter.fxml")));
            Stage stage = (Stage) unitConverterButton.getScene().getWindow();
            AnchorPane.setTopAnchor(child, 52.0);
            root.getChildren().add(child);
            Scene scene = new Scene(root, 350, 375);
            stage.setScene(scene);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    public void close(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    public void author(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Objects.requireNonNull(getClass().getClassLoader().getResource("author.fxml")));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.DECORATED);
            stage.setResizable(false);
            stage.setTitle("Author");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    public void history(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Objects.requireNonNull(getClass().getClassLoader().getResource("history.fxml")));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.DECORATED);
            stage.setResizable(false);
            stage.setTitle("History");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public static void main(String[] args) {
        launch(MainController.class);
    }

}