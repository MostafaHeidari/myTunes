public class Songs {


    public final String artist;
    public String title;
    public String Artist;
    public String categori;
    public int time;

    public Songs(String title, String Artist, String artist, String categori, int time)
    {
        this.title = title;
        this.artist = artist;
        this.Artist = this.artist;
        this.categori= categori;
        this.time= time;
    }

    public Songs(String title, Object artist, Object categori, Object time, String artist1) {
        this.artist = artist1;
    }

    public static void add(Songs song) {
    }

    public static void remove(Songs song) {
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

