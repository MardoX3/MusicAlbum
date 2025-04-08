package pl.gornik.musicalbum;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class MusicAlbumManager {
    static List<MusicAlbum> albums = new ArrayList<>();

    public static void readAlbumFromFile(){
        try(BufferedReader bReader = new BufferedReader(new FileReader("src/main/resources/Data.txt"))){
            String line;
            String artist;
            String album;
            int records;
            int year;
            long number;
            MusicAlbum album1;
            while((line = bReader.readLine())!= null){
                artist = line;
                album = bReader.readLine();
                records = Integer.parseInt(bReader.readLine());
                year = Integer.parseInt(bReader.readLine());
                number = Integer.parseInt(bReader.readLine());
                MusicAlbum musicAlbum = new MusicAlbum(artist,album,records,year,number);
                albums.add(musicAlbum);
                bReader.readLine();
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
