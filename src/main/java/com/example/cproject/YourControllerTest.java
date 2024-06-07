package com.example.cproject;

import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;

public class YourControllerTest {
    @Test
    public void testMoveCharacterToNextPlatform() {
        YourController controller = new YourController();

        // Initialize platformAnchorPane
        controller.platformAnchorPane = new AnchorPane();

        // Initialize other required components
        controller.initialize(null, null);
        controller.firstPlatform = new Platform(0, 288, 50, 241, Color.BLACK);
        controller.secondPlatform = new Platform(100, 288, 50, 241, Color.BLACK);
        controller.platformAnchorPane.getChildren().addAll(controller.firstPlatform, controller.secondPlatform);

        controller.moveCharacterToNextPlatform();
        assertEquals(0, controller.secondPlatform.getLayoutX());
        assertEquals(0, controller.secondPlatform.getX());
        assertFalse(controller.firstPlatform.isVisible());
    }

    @Test
    public void testFun1() {
        YourController controller = new YourController();

        Line line = new Line();
        controller.platformAnchorPane.getChildren().add(line);

        // Simulate a mouse release event to trigger the fun1 method
        MouseEvent releaseEvent = new MouseEvent(MouseEvent.MOUSE_RELEASED, 0, 0, 0, 0, MouseButton.PRIMARY, 1, false, false, false, false, true, false, false, true, false, false, null);
        controller.fun1(releaseEvent);

    }




//    @Test
//    void testFallCharacter(){
//        YourController controller = new YourController();
//        controller.initialize(null, null);
//        controller.line = new Line();
//        controller.platformAnchorPane.getChildren().add(controller.line);
//
//        // Set up a sample hero
//        controller.hero = new Hero();
//        controller.platformAnchorPane.getChildren().add(controller.hero);
//
//        // Call fallCharacter method
//        controller.fallCharecter();
//
//        // Assertions
//        assertEquals(3000, controller.fallCharecter().getDuration().toMillis());
//        assertEquals(500, controller.fallDownTransition.getDuration().toMillis());
//        assertEquals(0, controller.hero.getTranslateX());
//        assertEquals(controller.platformAnchorPane.getHeight(), controller.fallDownTransition.getToY());


//    }


}
