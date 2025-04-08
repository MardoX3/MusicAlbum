package pl.gornik.musicalbum;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Button btn,arrowRight,arrowLeft;

    @FXML
    private Label txtNumberDownoload;

    @FXML
    private Label Txttitle;

    @FXML
    private Label txtAlbum;

    @FXML
    private Label txtdate;

    File file = new File("/data.txt");
    Image left = new Image(String.valueOf(getClass().getResource("/obraz3.png")));
    Image right = new Image(String.valueOf(getClass().getResource("/obraz2.png")));
    List<MusicAlbum> albumList;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ImageView imgLeft = new ImageView(left);
        imgLeft.setFitHeight(70);
        arrowLeft.setGraphic(imgLeft);
        ImageView imgRight = new ImageView(right);
        imgRight.setFitHeight(70);
        arrowRight.setGraphic(imgRight);
        MusicAlbumManager.readAlbumFromFile();
        albumList = MusicAlbumManager.albums;
        for(MusicAlbum album: albumList) System.out.println(album);
    }
}
