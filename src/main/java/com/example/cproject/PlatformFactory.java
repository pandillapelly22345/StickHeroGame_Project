package com.example.cproject;

import javafx.scene.paint.Color;

public interface PlatformFactory {
    Platform createPlatform(double x, double y, double width, double height, Color color);
}
