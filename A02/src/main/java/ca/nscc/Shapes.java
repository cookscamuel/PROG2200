/*
    Author: Samuel Cook
    Date: October 3, 2024
    Filename: Shapes.java
    Purpose: Experiment with hash maps and enums.
 */

package ca.nscc;

import java.util.HashMap;
import java.util.Scanner;

class Graphic {
    // I made a graphic class to hold the pieces together. The hashmap will hold the objects together.

    private Shapes.Shape shape;

    private Shapes.Size size;

    private Shapes.Color color;

    private int x;

    private int y;

    public Graphic(Shapes.Shape shape, Shapes.Size size, Shapes.Color color, int x, int y) {
        this.shape = shape;
        this.size = size;
        this.color = color;
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "\nGRAPHIC: " + shape + "\nSIZE: " + size + "\nCOLOR: " + color + "\nX: " + x + "\nY: " + y + "\n";
    }
    // this is used to print the information about the graphic to the screen.

}

public class Shapes {
    enum Shape {
        SQUARE,
        CIRCLE,
        TRIANGLE,
        RECTANGLE,
        PENTAGON,
        TRAPEZOID
    }

    enum Color {
        RED,
        ORANGE,
        YELLOW,
        GREEN,
        BLUE,
        PURPLE
    }

    enum Size {
        MASSIVE,
        LARGE,
        MEDIUM,
        SMALL,
        TINY,
        MICROSCOPIC
    }
    // I did this rather than calculating anything because
    // these are different shapes, and therefore I would need
    // to implement different calculations depending on the
    // shape to accurately calculate the surface area.


    public static void main(String[] args) {

        HashMap<Integer, Graphic> graphicHashMap = new HashMap<>();
        // hashmap to hold the graphic objects, PK is a regular integer.

        System.out.println("How many Graphics would you like to generate?");
        Scanner scanner = new Scanner(System.in);

        try {

            int userNum = scanner.nextInt();

            for (int i = 0; i < userNum; i++) {

                int x_pos = (int)(Math.random() * 101);
                int y_pos = (int)(Math.random() * 101);
                // these simply generate random integers from 0 to 100, made up values.

                Shape shape = Shape.values()[(int)(Math.random() * 6)];
                Size size = Size.values()[(int)(Math.random() * 6)];
                Color color = Color.values()[(int)(Math.random() * 6)];
                // these generate random values and use them to grab indexes of the enums,
                // the results are stored in these variables.

                Graphic graphic = new Graphic(shape, size, color, x_pos, y_pos);
                // using the generated numbers, I create a new object holding the graphic attributes

                graphicHashMap.put(i, graphic);
                // the graphic is stored in the hashmap

                System.out.println("===== #" + (i + 1) + " ======" + graphicHashMap.get(i).toString());
                // I was going to do this in a separate for loop, but didn't see a point.
                // It would just be an extra line of code for the same result.
                // This just prints the current hashmap index.
            }
        }
        catch (Exception e) {
                System.out.println("Invalid Input.\nExiting...");
        }
        // basic try/catch statement that handles user incompetence.
    }
}
