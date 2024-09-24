package ca.nscc;

public class Students {

    private int studentID;
    private String name;

    public Students(int studentID, String name) {
        this.studentID = studentID;
        this.name = name;
    }

    public int getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Student ID: " + studentID + ", Name: " + name;
    }
}
