/*
    Author: Samuel Cook
    Date: October 3, 2024
    Filename: SortedSet.java
    Purpose: Use sorted sets for practice.
 */

package ca.nscc;

import java.util.Scanner;
import java.util.TreeSet;

public class SortedSet {
    public static void main(String[] args) {

    // create a new treeset array which utilizes the sortedset interface
    java.util.SortedSet<String> namesArray = new TreeSet<>();

        for (int i = 0; i < 10; i++) {
        System.out.println("Enter a name (Duplicate names will NOT be tolerated): ");
        Scanner scanner = new Scanner(System.in);
        String newName = scanner.nextLine();
        namesArray.add(newName);
    }
    // this just loops and lets the user enter names, duplicate names are not counted.

        // the array of names is automatically sorted alphabetically, with no duplicates
        System.out.println("Your names, sir:\n" + namesArray);

        // I did not iterate because I didn't feel it was necessary.

    }
}
