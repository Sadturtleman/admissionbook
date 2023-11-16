module com.sadturtleman {
    requires transitive javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;

    opens com.sadturtleman to javafx.fxml;
    exports com.sadturtleman;
}
