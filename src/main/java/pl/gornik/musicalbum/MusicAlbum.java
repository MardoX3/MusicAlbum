package pl.gornik.musicalbum;

public class MusicAlbum {
    private String artist;
    private String album;
    private int records;
    private int year;
    private long number;

    public MusicAlbum(String artist, String album, int records, int year, long number) {
        this.artist = artist;
        this.album = album;
        this.records = records;
        this.year = year;
        this.number = number;
    }

    public String getArtist() {
        return artist;
    }

    public String getAlbum() {
        return album;
    }

    public int getRecords() {
        return records;
    }

    public int getYear() {
        return year;
    }

    public long getNumber() {
        return number;
    }

    public long incrementDownload(){
        return ++number;
    }

    @Override
    public String toString() {
        return "MusicAlbumManager{" +
                "artist='" + artist + '\'' +
                ", album='" + album + '\'' +
                ", records=" + records +
                ", year=" + year +
                ", number=" + number +
                '}';
    }


}
