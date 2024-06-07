package com.example.cproject;

public class Cherry implements Collidable {
    int x;
    int y;

    @Override
    public int hasCollided(Stick s) {
        return 0;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
