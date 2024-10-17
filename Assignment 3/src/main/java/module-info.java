module ca.nscc.assignment3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens ca.nscc.assignment3 to javafx.fxml;
    exports ca.nscc.assignment3;
}