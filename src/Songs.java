public class Songs {


    public String artist;
    public String title;
    public String categori;
    public int time;

    public Songs(String title, String Artist, String categori, int time)
    {
        this.title = title;
        this.artist = this.artist;
        this.categori= categori;
        this.time= time;
    }

    public Songs(String title, Object artist, Object categori, Object time, String artist1) {
        this.artist = artist1;
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
        artist = artist;
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

