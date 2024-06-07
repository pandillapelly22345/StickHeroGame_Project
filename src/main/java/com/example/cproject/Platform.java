package com.example.cproject;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Platform extends Rectangle implements Collidable{
    public Platform(double x, double y, double width, double height, Color color) {
        super(width, height, color);
        this.setX(x);
        this.setY(y);
    }

//    float x;
//    float y;
//    int width;
//    int height;
//    private Color color;
//
//    public Platform(int x, int y, int width, int height, Color color){
//        this.x = x;
//        this.y = y;
//        this.width = width;
//        this.height = height;
//        this.color = color;
//    }

    @Override
    public int hasCollided(Stick s) {
        return 0;
    }

//    public float getX() {
//        return x;
//    }
//
//    public float getY() {
//        return y;
//    }
//
//    public int getHeight() {
//        return height;
//    }
//
//    public void setHeight(int height) {
//        this.height = height;
//    }
//
//    public int getWidth() {
//        return width;
//    }
//
//    public void setWidth(int width) {
//        this.width = width;
//    }
//
//    public void setY(float y) {
//        this.y = y;
//    }
//
//    public void setX(float x) {
//        this.x = x;
//    }
}
