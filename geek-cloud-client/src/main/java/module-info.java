module com.geekbrains.geekcloudclient {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.geekbrains.geekcloudclient to javafx.fxml;
    exports com.geekbrains.geekcloudclient;
}