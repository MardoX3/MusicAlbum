module pl.gornik.musicalbum {
    requires javafx.controls;
    requires javafx.fxml;


    opens pl.gornik.musicalbum to javafx.fxml;
    exports pl.gornik.musicalbum;
}