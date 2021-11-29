public class Songs {


    private final String artist;
    private String title;
    private String Artist;
    private String categori;
    private int time;

    public Songs(String title, String Artist, String artist, String categori, int time)
    {
        this.title = title;
        this.artist = artist;
        this.Artist = this.artist;
        this.categori= categori;
        this.time= time;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        Artist = artist;
    }

    public String getCategori() {
        return categori;
    }

    public void setCategori(String categori) {
        this.categori = categori;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}

