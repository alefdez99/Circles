module es.ieslosmontecillos.circle {
    requires javafx.controls;
    requires javafx.fxml;


    opens es.ieslosmontecillos.circle to javafx.fxml;
    exports es.ieslosmontecillos.circle;
}