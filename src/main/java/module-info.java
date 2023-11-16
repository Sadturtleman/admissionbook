module com.sadturtleman {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.sadturtleman to javafx.fxml;
    exports com.sadturtleman;
}
