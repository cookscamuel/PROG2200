package ca.nscc.assignment3;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

/*
 * ClockAnimation.java
 * Author: Samuel Cook
 * Date: October 15, 2024
 * Purpose: Give life to a clock.
 */

public class ClockAnimation extends Application {
    @Override
    public void start(Stage primaryStage) {
        ClockPane clock = new ClockPane();

        EventHandler<ActionEvent> eventHandler = e -> {
            clock.setCurrentTime();
        };

        Timeline animation = new Timeline(new KeyFrame(Duration.millis(100), eventHandler));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();

        Scene scene = new Scene(clock, 250, 250);
        primaryStage.setTitle("ClockAnimation");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
