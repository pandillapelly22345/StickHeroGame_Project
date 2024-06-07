package com.example.cproject;

import javafx.scene.paint.Color;

public class CPlatformFactory implements PlatformFactory{
    @Override
    public Platform createPlatform(double x, double y, double width, double height, Color color) {
        return new Platform(x, y, width, height, color);
    }
}
