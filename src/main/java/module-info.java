module com.sadturtleman {

    requires javafx.controls;    
    requires transitive javafx.graphics;
    requires javafx.fxml;
    requires java.sql;
    opens com.sadturtleman to javafx.fxml;
    opens com.sadturtleman.controller to javafx.fxml;
    exports com.sadturtleman;
}
