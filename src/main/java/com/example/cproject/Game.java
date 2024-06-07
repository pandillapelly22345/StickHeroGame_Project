package com.example.cproject;

import javafx.scene.paint.Color;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game implements Serializable{
    private Player player;
    private Color platformColor = Color.BLUE;
    private int score;
    private Hero charecter;
    private ArrayList<Cherry> cherry= new ArrayList<>();
    private List<Platform> platform = new ArrayList<Platform>();
    private String dateTime;
    public Game(){
//        platform.add(new Platform(100,10,200, 100, Color.BLACK));
//        platform.add(new Platform(90,10,100,100,Color.BLACK));
//        platform.add(new Platform(10,10,50,100,Color.BLACK));
//        platform.add(new Platform(50,10,150,100,Color.BLACK));
//        platform.add(new Platform(20,10,80,100,Color.BLACK));
    }

//    private Cherry generateCherry(){
//
//    }

    private void newPlatform(){
        Random random = new Random();
        Platform randomPlatform = platform.get(random.nextInt(platform.size()));

    }

    public int getScore(){
        return score;
    }
    public void setScore(){

    }
    private Cherry generateCherry(){
        return null;
    }

    public void playGame(){
    }

    public void exitGame(){

    }

    public void gameOver(){
    }

    public void Sound(){
    }

    public void pause(){
    }

    public void resume(){
    }

    public void updateScore(){
    }

    public void savedGames(){
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
