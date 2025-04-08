package pl.gornik.musicalbum;

import javafx.event.ActionEvent;
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
import java.security.PrivateKey;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Button btn,arrowRight,arrowLeft;

    @FXML
    private Label txtNumberSong;

    @FXML
    private Label txtNumberDownoload;
    @FXML
    private Label TxtTitle;

    @FXML
    private Label txtAlbum;

    @FXML
    private Label txtDate;

    File file = new File("/data.txt");
    Image left = new Image(String.valueOf(getClass().getResource("/obraz3.png")));
    Image right = new Image(String.valueOf(getClass().getResource("/obraz2.png")));
    List<MusicAlbum> albumList;
    static int index = 0;
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


        arrowRight.setOnAction(actionEvent -> {
            if(index == albumList.size()){
                index = 0;
                getAlbum(index);
            }
            else getAlbum(index++);

        });

        arrowLeft.setOnAction(actionEvent -> {
            if(index == 0){
                index = albumList.size()-1;
                getAlbum(index);
            }
            else getAlbum(index--);

        });
        btn.setOnAction(actionEvent -> {
            txtNumberDownoload.setText(String.valueOf(albumList.get(index).incrementDownload()));
        });

    }
    //**************************************************
    //nazwa funkcji: GetAlbum
    //opis funkcji: Funkcja pobiera i wyswietla odpowiednie dane wzgledem indeksu
    //parametry index - żadany do wyswietlenia index albumu
    //zwracany typ i opis: brak
    //autor: Wiktor Przyłucki
    //**************************************************
    private void getAlbum(int index){
        txtAlbum.setText(albumList.get(index).getArtist());
        TxtTitle.setText(albumList.get(index).getAlbum());
        txtNumberSong.setText(String.valueOf(albumList.get(index).getRecords()));
        txtDate.setText(String.valueOf(albumList.get(index).getYear()));
        txtNumberDownoload.setText(String.valueOf(albumList.get(index).getNumber()));

    }
}
