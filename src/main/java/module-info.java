module sio.tp1 {
    requires javafx.controls;
    requires javafx.fxml;
    opens sio.tp1 to javafx.fxml;
    exports sio.tp1;
    opens sio.tp1.Model;
}