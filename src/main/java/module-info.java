module com.example.loginconcept {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.testng;
    requires junit;


    opens com.example.loginconcept to javafx.fxml;
    exports com.example.loginconcept;
}