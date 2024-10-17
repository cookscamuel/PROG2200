package ca.nscc.assignment3;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.util.Calendar;
import java.util.GregorianCalendar;

/*
 * ClockPane.java
 * Author: Samuel Cook
 * Date: October 15, 2024
 * Purpose: Class that holds all instructions for creating the clock.
 */

public class ClockPane extends Pane {

    private int hour;
    private int minute;
    private int second;

    private boolean hourHandVisible;
    private boolean minuteHandVisible;
    private boolean secondHandVisible;

    // this is used to create clocks. It's like a constructor, but it just calls the setCurrentTime method.
    public ClockPane() {
        setCurrentTime();
    }


    //////////////// GETTERS //////////////////

    public String getHour() {
        if (hour <= 9) {
            return "0" + hour;
        }
        else {
            return "" + hour;
        }
    }

    public String getMinute() {
        if (minute <= 9) {
            return "0" + minute;
        }
        else {
            return "" + minute;
        }
    }

    public String getSecond() {
        if (second <= 9) {
            return "0" + second;
        }
        else {
            return "" + second;
        }
    }
    // the extra logic checks to see if the number is a single digit. if it is, a zero is placed in front of it.
    // it's just for style.

    //////////////// SETTERS //////////////////

    public void setHour(int hour) {
        this.hour = hour;
        paintClock();
    }

    public void setMinute(int minute) {
        this.minute = minute;
        paintClock();
    }


    public void setSecond(int second) {
        this.second = second;
        paintClock();
    }

    // used to create a clock. calls the paintClock method, and assigns time.
    public void setCurrentTime() {
        Calendar calendar = new GregorianCalendar();

        this.hour = calendar.get(Calendar.HOUR_OF_DAY);
        this.minute = calendar.get(Calendar.MINUTE);
        this.second = calendar.get(Calendar.SECOND);
        this.hourHandVisible = true;
        this.minuteHandVisible = true;
        this.secondHandVisible = true;

        paintClock();
    }

    // Getters for visibility attributes. These go unused in this project.
    public boolean isHourHandVisible() {
        return hourHandVisible;
    }

    public boolean isMinuteHandVisible() {
        return minuteHandVisible;
    }

    public boolean isSecondHandVisible() {
        return secondHandVisible;
    }

    // Setters for visibility attributes. I made them toggle methods for fun, but it would be just as easy to
    // make them accept to choose true or false.
    public void setHourHandVisible() {
        hourHandVisible = !hourHandVisible;
    }

    public void setMinuteHandVisible() {
        minuteHandVisible = !minuteHandVisible;
    }

    public void setSecondHandVisible() {
        secondHandVisible = !secondHandVisible;
    }
    // this is the only used setter method in this project.

    // this is where the entire clock is made.
    private void paintClock() {

        String[] clockNums = {"12", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"};
        // this is an array for holding the numbers that will go on the clock.

        double clockRadius = Math.min(getWidth(), getHeight()) * 0.8 * 0.5;
        double centerX = getWidth() / 2;
        double centerY = getHeight() / 2;
        // getters for the clock radius and center X and Y coordinates

        Circle circle = new Circle(centerX, centerY, clockRadius);
        circle.setFill(Color.SNOW);
        circle.setStroke(Color.BLACK);
        circle.setStrokeWidth(10);
        // this circle is the background for each clock.

        // first circle for hiding lines later.
        Circle inCircle1 = new Circle(centerX, centerY, clockRadius - 20);
        inCircle1.setFill(Color.SNOW);

        // second circle to serve the same purpose.
        Circle inCircle2 = new Circle(centerX, centerY, clockRadius - 35);
        inCircle2.setFill(Color.SNOW);

        double hLength = clockRadius * 0.4;
        double hourX = centerX + hLength * Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
        double hourY = centerY - hLength * Math.cos((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
        Line hLine = new Line(centerX, centerY, hourX, hourY);
        hLine.setStrokeWidth(3);
        if (hourHandVisible) {
            hLine.setStroke(Color.GREEN);
        }
        else {
            hLine.setStroke(Color.TRANSPARENT);
        }
        // if statement to check if the clock hand is supposed to be visible or not.
        // the hands are always drawn, it's just a matter of visibility.

        double mLength = clockRadius * 0.65;
        double minuteX = centerX + mLength * Math.sin(minute * (2 * Math.PI / 60));
        double minuteY = centerY - mLength * Math.cos(minute * (2 * Math.PI / 60));
        Line mLine = new Line(centerX, centerY, minuteX, minuteY);
        mLine.setStrokeWidth(3);
        if (minuteHandVisible) {
            mLine.setStroke(Color.BLUE);
        }
        else {
            mLine.setStroke(Color.TRANSPARENT);
        }
        // same if statement as the previous one.

        double sLength = clockRadius * 0.8;
        double secondX = centerX + sLength * Math.sin(second * (2 * Math.PI /60));
        double secondY = centerY - sLength * Math.cos(second * (2 * Math.PI / 60));
        Line sLine = new Line(centerX, centerY, secondX, secondY);
        sLine.setStrokeWidth(3);
        if (secondHandVisible) {
            sLine.setStroke(Color.RED);
        }
        else {
            sLine.setStroke(Color.TRANSPARENT);
        }
        // last one, for seconds.



        getChildren().clear();
        getChildren().add(circle); // the first circle is drawn as the base for the clock.

        for (int i=0; i<30; i++) { // for all 60 ticks on the clock, make 30 diameter-length lines
            Line detailLine = new Line(centerX + clockRadius - 10, centerY, centerX - clockRadius + 10, centerY);
            detailLine.setStroke(Color.BLACK);
            getChildren().add(detailLine); // add each line to the clock
            detailLine.rotateProperty().set(i * 6); // rotate the line by the angle difference between the ticks
        }
        // this for loop will create a line in the spot of each second (and minute) tick on the clock.

        getChildren().add(inCircle1); // cover up the length of lines that do not need to be displayed with the first "hiding" circle

        for (int i=0; i<6; i++) {

            Line detailLine = new Line(centerX + clockRadius - 10, centerY, centerX - clockRadius + 10, centerY);
            detailLine.setStroke(Color.BLACK);
            detailLine.setStrokeWidth(2);
            getChildren().add(detailLine); // add the hour line
            detailLine.rotateProperty().set(i * 30); // rotate the line by the distance between the hours
            // create 6 diameter-length lines to represent the hours
        }

        getChildren().addAll(inCircle2, sLine, mLine, hLine);
        // add the second "hiding" circle to cover up the new hour lines
        // also add the clock hands.


        for (int i=0; i<12; i++) { // for all 12 numbers on the clock


            // these next three lines were inspired by code I received from ChatGPT.
            // I was struggling to calculate the correct positions the numbers should
            // go to on the circle. This is not the exact same code that was
            // generated, but it is a tweaked version that works for what I needed.
            double numAngle = Math.toRadians(i * 30);
            double numX = centerX + (clockRadius - 60) * Math.sin(numAngle) - 24;
            double numY = centerY - (clockRadius - 60) * Math.cos(numAngle) + 12;
            // that is all the code that was AI assisted.


            Text hourNum = new Text(numX, numY, clockNums[i]); // at each hour position, create the corresponding hour number text object
            hourNum.setFont(new Font("Consolas", 40)); // set the styles for the number
            hourNum.setWrappingWidth(50); // sets a wrapping width to act as a makeshift container to help align 10 11 and 12 with single digit numbers.
            hourNum.setTextAlignment(TextAlignment.CENTER); // center align all numbers within their wrapping width containers.

            getChildren().add(hourNum); // add each number to the clock

        }

    }

    @Override
    public void setWidth(double width) {
        super.setWidth(width);
        paintClock();
    }

    @Override
    public void setHeight(double height) {
        super.setHeight(height);
        paintClock();
    }

}
