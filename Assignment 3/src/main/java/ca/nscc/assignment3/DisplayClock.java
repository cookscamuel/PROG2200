package ca.nscc.assignment3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/*
 * DisplayClock.java
 * Author: Samuel Cook
 * Date: October 15, 2024
 * Purpose: Used to actually display the clock.
 */

public class DisplayClock extends Application {

    @Override
    public void start(Stage primaryStage)  {

        // create two clocks
        ClockPane clock1 = new ClockPane();
        ClockPane clock2 = new ClockPane();

        // define the size of both clocks
        clock1.setPrefSize(800, 800);
        clock2.setPrefSize(800, 800);

        // manually set the fixed time on both clocks
        clock1.setHour(4);
        clock1.setMinute(20);
        clock1.setSecond(45);

        clock2.setHour(22);
        clock2.setMinute(46);
        clock2.setSecond(15);


        // create strings holding the current time for each clock
        String timeString1 = "Current Time: " + clock1.getHour() + ":" + clock1.getMinute() + ":" + clock1.getSecond();
        String timeString2 = "Current Time: " + clock2.getHour() + ":" + clock2.getMinute() + ":" + clock2.getSecond();

        // convert the strings into actual labels
        Label lblCurrentTime1 = new Label(timeString1);
        Label lblCurrentTime2 = new Label(timeString2);

        BorderPane pane1 = new BorderPane(); // create the first pane for the first clock and its time
        pane1.setCenter(clock1); // set the clock to be in the center of the first pane
        lblCurrentTime1.setFont(new Font("Consolas", 40)); // alter the font and font size of the label
        lblCurrentTime1.paddingProperty().set(new Insets(30, 0, 120, 0)); // add some top and bottom padding for style
        VBox vbox1 = new VBox(clock1, lblCurrentTime1); // add the first clock and label to a vertical box for alignment
        pane1.setCenter(vbox1); // set the vertical box to be bound to the center of the screen
        vbox1.setAlignment(Pos.CENTER); // center the contents of the vertical box

        // literally the same thing above, but for the second clock and label
        BorderPane pane2 = new BorderPane();
        pane2.setCenter(clock2);
        lblCurrentTime2.setFont(new Font("Consolas", 40));
        lblCurrentTime2.paddingProperty().set(new Insets(30, 0, 120, 0));
        VBox vbox2 = new VBox(clock2, lblCurrentTime2);
        pane2.setCenter(vbox2);
        vbox2.setAlignment(Pos.CENTER);

        // create a horizontal box to store the panes in to display them side-by-side
        HBox hbox = new HBox(pane1, pane2);
        hbox.setAlignment(Pos.CENTER); // align it in the center of the window

        Scene scene = new Scene(hbox, 1200, 800); // use the hbox containing both panes for the scene
        primaryStage.setTitle("Two Detailed Clocks");
        primaryStage.setScene(scene);
        primaryStage.show();


        // Clock with hidden second hand
        ClockPane hideClock = new ClockPane(); // create a new clock for random values and no second hand

        int randHour = ((int) (Math.random() * 12)); // generate a random number between 0 and 11
        int randMinute;

        if (((int) (Math.random() * 2)) == 0) { // generate a random number (either 0 or 1)
            randMinute = 0;
        }
        else {
            randMinute = 30;
        }
        // it will either set the minute hand to 0 or 30

        hideClock.setHour(randHour); // set the hour hand to the first randomly generated number
        hideClock.setMinute(randMinute); // set the minute hand to the second RNG number
        hideClock.setSecond(0); // set the second value to 0

        String detailString = "Current Time: " + hideClock.getHour() + ":" + hideClock.getMinute() + ":" + hideClock.getSecond(); // set up the string for the label
        Label lblHideClock = new Label(detailString); // set up the label to display the time
        hideClock.setPrefSize(800, 800); // set the clock size

        hideClock.setSecondHandVisible(); // this toggles the visibility of the second hand.
        // if this method is called again, the second hand will be visible again.

        BorderPane detailPane = new BorderPane();
        detailPane.setCenter(hideClock);
        lblHideClock.setFont(new Font("Consolas", 40));
        lblHideClock.paddingProperty().set(new Insets(30, 0, 120, 0));
        VBox detailVbox = new VBox(hideClock, lblHideClock);
        detailPane.setCenter(detailVbox);
        detailVbox.setAlignment(Pos.CENTER);
        // set up the pane content (stored in a vbox like the ones that came before)


        Scene detailScene = new Scene(detailPane, 800, 800);
        Stage secondStage = new Stage();
        secondStage.setTitle("Random Hour and Minute Hands");
        secondStage.setScene(detailScene);
        secondStage.show();
        // set up the second scene (it will appear in a different window)

    }
}