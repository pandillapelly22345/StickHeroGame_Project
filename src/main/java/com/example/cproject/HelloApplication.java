package com.example.cproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class HelloApplication extends Application {

    private Game activeGame;
    private int cherry;

    public void tapStickSound(){
    }

    public void fallingSound(){
    }

    public void gameOverSound(){
    }

    public void pickingCherrySound(){
    }

    public void backgroundMusic(){
    }

    public void startGame(){
    }

    public void exitGame(){
    }

    public void openSavedGames(){
    }

    public void updateCherry(int Cherry){
    }

    public Game getActiveGame() {
        return activeGame;
    }

    public void setActiveGame(Game activeGame) {
        this.activeGame = activeGame;
    }

    public void about(){
    }

    public void viewStatistics(){
    }

    @Override
    public void start(Stage stage){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Scene1.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Stick Hero");
            stage.setScene(scene);
            stage.show();
            String audioFilePath = "path/to/your/audio/file.mp3"; // Replace with the path to your audio file

//             Create a Media object
            Media media = new Media(new File("src/main/resources/com/example/cproject/cruising-down-8bit-lane-159615.mp3").toURI().toString());


            MediaPlayer mediaPlayer = new MediaPlayer(media);
            mediaPlayer.play();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}