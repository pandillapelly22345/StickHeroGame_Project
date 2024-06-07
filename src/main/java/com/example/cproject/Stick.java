package com.example.cproject;

import javafx.animation.RotateTransition;
import javafx.geometry.Point3D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

class Stick extends Line implements Collidable, Rotatable {
    int length;
    private static Stick instance;

    public Stick(double startX, double startY) {
//        super(startX, startY, endX, endY);
//        this.setStroke(color);
        this.setStartX(-50);
        this.setStartY(0);
        this.setEndX(-50);
        this.setEndY(0);

    }

    @Override
    public int hasCollided(Stick s) {
        return 0;
    }

    @Override
    public void rotate() {

    }
}

class Hero extends Pane {
    private ImageView heroImageView;
    private Rectangle rec;
    private static Stick stick;


    public Hero() {
//        heroImageView = new ImageView(new Image("src/main/resources/com/example/cproject/StickHero.png"));
        Image im = new Image(getClass().getResource("StickHero.png").toExternalForm());
        heroImageView = new ImageView(im);
        heroImageView.setFitWidth(70);
        heroImageView.setFitHeight(54);
        heroImageView.setLayoutX(0);
        heroImageView.setLayoutY(240);


        getChildren().add(heroImageView);
    }

    public static Stick getStick() {
        return stick;
    }
}
