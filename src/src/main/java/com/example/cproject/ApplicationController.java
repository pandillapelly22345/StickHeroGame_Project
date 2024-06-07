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
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

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

//    @FXML
//    ImageView myImageView;
//    Button myButton;
//
//    Image myImage = new Image(getClass().getResourceAsStream("stickhero.png"));
//
//    public void displayImage(){
//        myImageView.setImage(myImage);
//    }

//    @FXML
//    private ImageView myImageView;
//
//    public void initialize() {
//        // Load image from the resources folder (assuming it's in the same package as the class)
//        Image myImage = new Image(new FileInputStream("C:\\Users\\P.Harshvardhini\\CProject\\src\\pxfuel.jpg"));
//
//        // Set the loaded image to the ImageView
//        myImageView.setImage(myImage);
//    }

//    public ApplicationController() {
//        try {
//            myImage = new Image(new FileInputStream("C:\\Users\\P.Harshvardhini\\CProject\\src\\pxfuel.jpg"));
//            if (myImage != null) {
//                myImageView.setImage(myImage);
//            } else {
//                // Handle the case where the image is not loaded successfully.
//                System.out.println("Image not loaded.");
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//            // Handle the exception (e.g., display an error message) based on your application's requirements.
//        }
//    }

//    public void displayImage() {
//        if (myImage != null) {
//            myImageView.setImage(myImage);
//        } else {
//            // Handle the case where the image is not loaded successfully.
//            System.out.println("Image not loaded.");
//        }
//    }





    public void switchToScene2(ActionEvent event) throws IOException {


        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Scene2.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
        stage.setScene(scene);
//        Level l = new Level();
//        l.generateRandomPlatform();
//        Scene2Controller s = new Scene2Controller();
//        s.generatePlatforms();
        stage.show();
    }





}
