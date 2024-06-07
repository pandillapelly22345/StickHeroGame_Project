package com.example.cproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class ApplicationController {
    private Stage stage;
    private Scene scene;
    private Parent root;



    public void switchToScene2(ActionEvent event) throws IOException {


        Parent root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
       // YourController controller = new YourController();
        Platform platform = new Platform(100, 200, 150, 20, Color.GREEN);
       // controller.addPlatform(platform);

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }


    public void exitGame(ActionEvent event){
        javafx.application.Platform.exit();
    }





}
