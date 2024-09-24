package ca.nscc;

import java.util.HashMap;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        HashMap<Integer, Students> studentMap = new HashMap<>();

        Students student1 = new Students(543, "Frank");
        Students student2 = new Students(432, "Mary");
        Students student3 = new Students(321, "Jack");
        Students student4 = new Students(215, "Cliff");
        Students student5 = new Students(154, "Danny");

        studentMap.put(student1.getStudentID(), student1);
        studentMap.put(student2.getStudentID(), student2);
        studentMap.put(student3.getStudentID(), student3);
        studentMap.put(student4.getStudentID(), student4);
        studentMap.put(student5.getStudentID(), student5);

        System.out.println("=========================");
        while (true) {
            System.out.println("=== STUDENT DIRECTORY ===");
            System.out.println("1 - View All Students\n2 - Add Student\n3 - Student ID Lookup\n4 - Exit");
            System.out.println("Please enter your selection: ");
            Scanner input = new Scanner(System.in);
            String selection = input.nextLine();
            switch (selection) {
                case "1":

                    System.out.println("\nSTUDENTS:");
                    for (Students student : studentMap.values()) {
                        System.out.println(student);
                    }
                    System.out.println("\n=========================");
                    continue;

                case "2":

                    System.out.println("\nPlease Enter Student ID: ");
                    Scanner addID = new Scanner(System.in);
                    Scanner addName = new Scanner(System.in);
                    int newID = addID.nextInt();
                    System.out.println("\nPlease Enter Student Name: \n");
                    String newName = addName.nextLine();

                    Students student = new Students(newID, newName);
                    studentMap.put(student.getStudentID(), student);
                    System.out.println("\nStudent Added:\nID: " + newID + "\nName: " + newName + "\n\n=========================");

                    continue;


                case "3":
                    Scanner stud = new Scanner(System.in);

                    System.out.println("\nEnter Student ID: ");

                    int id = stud.nextInt(); // this is the scanner for integer input.
                    System.out.println(studentMap.get(id) + "\n\n=========================");
                    continue;
                case "4":
                    System.out.println("\nExiting...");
                    break;
                default:
                    System.out.println("\nInvalid selection.\n");
                    continue;
            }
            break;
        }
    }
}