package com.example.cproject;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

public class YourController implements Initializable{
    private PlatformFactory platformFactory = new CPlatformFactory();
    @FXML
    private Label scoreLabel;

    private int score = 0;
    @FXML
    public void increaseScore(){
        score++;
        scoreLabel.setText(""+ score);
    }

    @FXML
    AnchorPane platformAnchorPane;
    @FXML
    private Button b;
    private ArrayList<Platform> platformList;
    Platform mPlatform;
    Hero hero;
    Line line;
    private Timeline t;
    private Stick stick;

//    public void addPlatform(Platform platform) {
//        platformAnchorPane.getChildren().add(platform);
//    }
    private Timeline stickIncreaseAnimation;

    int secondPlatformX;
    int secondPlatformWidth;

    public void print(ActionEvent e){
        System.out.println("hygtfrde");
    }
    private void mid(){
        System.out.println("mid");
        line.setEndY(line.getEndY()-10);
    }

    public void fun1(MouseEvent e) {
        t.stop();

        double midPointY = (line.getStartY()+line.getEndY()) / 2;
        RotateTransition rotateTransition = new RotateTransition(Duration.millis(500), line);
        rotateTransition.setByAngle(90);


        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(500), line);
        translateTransition.setByY(midPointY - line.getEndY());
        translateTransition.setByX(-((line.getStartY()+line.getEndY())/2));


        ParallelTransition parallelTransition = new ParallelTransition(rotateTransition, translateTransition);
        parallelTransition.setOnFinished(event -> {
            double ln = Math.abs(line.getStartY()+ line.getEndY());
            double coord = firstPlatform.getLayoutX()+firstPlatform.getWidth()-hero.getLayoutX();
            System.out.println(ln+coord);
            System.out.println(secondPlatform.getX());
            if(ln+coord >=secondPlatform.getX() && (ln+coord)<=secondPlatform.getX()+secondPlatform.getWidth()){
                System.out.println("true s");
                moveCharacterToNextPlatform();
            }
            else{
                System.out.println("false s");
                fallCharecter();
            }
//            if (isStickTouchingSecondPlatform()) {
//                moveCharacterToNextPlatform();
//            }

//            if(ln > (secondPlatform.getLayoutX()+secondPlatform.getWidth())){
//                System.out.println("ksjfkdfh");
////                moveCharacterToNextPlatform();
//                TranslateTransition fallTransition = new TranslateTransition(Duration.seconds(1), hero);
//                fallTransition.setToY(platformAnchorPane.getHeight()); // fall to the bottom of the pane
//                fallTransition.play();
//            }
//            else if(isStickTouchingSecondPlatform()){
//                moveCharacterToNextPlatform();
//            }
//            else {
//                double length = firstPlatform.getLayoutX()/2;
//
//                System.out.println("false");
//                TranslateTransition translate = new TranslateTransition();
//                translate.setNode(hero);
//                translate.setDuration(Duration.millis(3000));
//                translate.setByX(-line.getEndY() + line.getStartY() + length);
//
//// Set up a sequential transition to make it move horizontally first and then fall down
//                SequentialTransition sequentialTransition = new SequentialTransition(translate);
//
//// Add a new translate transition for the falling down part
//                TranslateTransition fallDownTransition = new TranslateTransition();
//                fallDownTransition.setNode(hero);
//                fallDownTransition.setToY(platformAnchorPane.getHeight());
//                fallDownTransition.setDuration(Duration.millis(500));  // Adjust the duration as needed
//
//                sequentialTransition.getChildren().add(fallDownTransition);
//
//                sequentialTransition.play();
//
////                TranslateTransition fallTransition = new TranslateTransition(Duration.seconds(1), hero);
////                fallTransition.setToY(platformAnchorPane.getHeight()); // fall to the bottom of the pane
////                fallTransition.play();
//            }
        });

        parallelTransition.play();
    }

//    private Hero hero ;



    Platform firstPlatform;
    Platform secondPlatform;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Random random = new Random();

        // Generate the first platform with random x and width
        int firstPlatformX = random.nextInt(141) + 10; // Random number between 10 and 150
        int firstPlatformWidth = random.nextInt(141) + 10; // Random number between 10 and 150 (inclusive)
        firstPlatform = platformFactory.createPlatform(0, 288, firstPlatformWidth, 241, Color.BLACK);

        // Generate the second platform with random x and width, ensuring it does not overlap with the first one

//        int xCord = 20;

        secondPlatformX = random.nextInt((int) (firstPlatform.getLayoutX()+firstPlatform.getWidth()+1),150); // Random number between 10 and 150 (inclusive)
        secondPlatformWidth = random.nextInt(141) + 10;

        secondPlatform = new Platform(secondPlatformX, 288, secondPlatformWidth, 241, Color.BLACK);


        platformAnchorPane.getChildren().addAll(firstPlatform, secondPlatform);

        platformAnchorPane.setOnMousePressed(this::handleMousePressed);
        t = new Timeline(new KeyFrame(Duration.seconds(0.4), e -> mid()));
        t.setCycleCount(Timeline.INDEFINITE);
        platformAnchorPane.setOnMouseReleased(this::fun1);
        System.out.println("kjhgfd");



        double bich_ka_point = firstPlatform.getLayoutX()+firstPlatform.getWidth();
        bich_ka_point=bich_ka_point/2;
        System.out.println(firstPlatform.getWidth()+"w");
        System.out.println(firstPlatform.getLayoutX()+"w");
        System.out.println(bich_ka_point+"point");
        hero = new Hero();
        hero.setLayoutX(bich_ka_point-35);
        platformAnchorPane.getChildren().add(hero);
    }

    private void handleMousePressed(MouseEvent event) {
        System.out.println("clicked");
        t.play();
        line=new Line();
        line.setLayoutX(firstPlatform.getLayoutX()+100+firstPlatform.getWidth());
        line.setLayoutY(288);
        line.setStartX(-100);
        line.setStartY(0);
        line.setEndX(-100);
        line.setEndY(0);
        line.setId("stick");
        platformAnchorPane.getChildren().add(line);

    }

    private void handleMouseReleased(MouseEvent event) {
        t.stop();
        System.out.println("end");
//        Hero.getStick().rotate();
    }
    private Platform generateRandomPlatform() {
        Random random = new Random();
        int x = random.nextInt(141) + 10;
        int width = random.nextInt(141) + 10;
        return new Platform(x, 288, width, 241, Color.BLACK);
    }

    private boolean isStickTouchingSecondPlatform() {
        Bounds stickBounds = line.localToScene(line.getBoundsInLocal());
        Bounds secondPlatformBounds = secondPlatform.localToScene(secondPlatform.getBoundsInLocal());
        boolean isTouching = stickBounds.intersects(secondPlatformBounds);

        if (isTouching) {
            moveCharacterToNextPlatform();
        }
        return isTouching;
    }
    void moveCharacterToNextPlatform() {
        double target = Math.abs(line.getEndY()+line.getStartY());
        double rightX = firstPlatform.getLayoutX()+firstPlatform.getWidth();
        rightX=rightX-hero.getLayoutX();
        TranslateTransition translate = new TranslateTransition();
        translate.setNode(hero);
        translate.setDuration(Duration.millis(3000));
        translate.setByX(target+rightX-30);
        translate.play();
        translate.setOnFinished(event -> {
            secondPlatform.setLayoutX(0);
            secondPlatform.setX(0);
            platformAnchorPane.getChildren().remove(firstPlatform);


            firstPlatform = secondPlatform;

            Random random = new Random();
            int secondPlatformX2 = random.nextInt((int) (firstPlatform.getLayoutX() + firstPlatform.getWidth() + 1), 150);
            int secondPlatformWidth2 = random.nextInt(141) + 10;

            mPlatform = new Platform(secondPlatformX2, 288, secondPlatformWidth2, 241, Color.BLACK);

            platformAnchorPane.getChildren().remove(secondPlatform);

            // Add the new platforms
            platformAnchorPane.getChildren().addAll(firstPlatform, mPlatform);

            platformAnchorPane.getChildren().remove(hero);

            Hero h = new Hero();
            double bich_ka_point = secondPlatform.getLayoutX()+secondPlatform.getX()+secondPlatform.getWidth();
            bich_ka_point=bich_ka_point/2;
            System.out.println(secondPlatform.getWidth()+"w");
            System.out.println(secondPlatform.getLayoutX()+"w");
            System.out.println(bich_ka_point+"point");
            hero.setLayoutX(bich_ka_point-35);
            platformAnchorPane.getChildren().add(h);
            platformAnchorPane.getChildren().removeIf(node -> node.getId() != null && node.getId().equals("stick"));
            increaseScore();
            hero = h;
            secondPlatform = mPlatform;

        });
    }

    void fallCharecter(){
        double length = firstPlatform.getLayoutX()/2;

        System.out.println("false");
        TranslateTransition translate = new TranslateTransition();
        translate.setNode(hero);
        translate.setDuration(Duration.millis(3000));
        translate.setByX(-line.getEndY() + line.getStartY() + length);


        SequentialTransition sequentialTransition = new SequentialTransition(translate);

        TranslateTransition fallDownTransition = new TranslateTransition();
        fallDownTransition.setNode(hero);
        fallDownTransition.setToY(platformAnchorPane.getHeight());
        fallDownTransition.setDuration(Duration.millis(500));

        sequentialTransition.getChildren().add(fallDownTransition);
        sequentialTransition.play();
        sequentialTransition.setOnFinished(event -> {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("Scene3.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage)platformAnchorPane.getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }



}