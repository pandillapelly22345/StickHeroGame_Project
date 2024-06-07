package com.example.cproject;

import java.io.Serializable;
import java.util.Map;

public class Player implements Serializable{
    int noOfCherries;
    int highestScore;
    int score;
    int position;

    public void tapSticks(){
    }

    private Map<Long, Game> savedGamesMap;

    public void IncreaseScore(){
    }

    public int getNoOfCherries() {
        return noOfCherries;
    }

    public void setNoOfCherries(int noOfCherries) {
        this.noOfCherries = noOfCherries;
    }

    public int getHighestScore() {
        return highestScore;
    }

    public void setHighestScore(int highestScore) {
        this.highestScore = highestScore;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getPosition(){
        return position;
    }

    public Map<Long, Game> getSavedGamesMap() {
        return savedGamesMap;
    }

    public void saveGame(){
    }

    public void deleteGame(){
    }
}
