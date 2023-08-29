module com.hou.javafxproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.poi.poi;
    requires org.apache.poi.ooxml;


    opens com.hou.javafxproject to javafx.fxml;
    exports com.hou.javafxproject;
}