package mytunes.be;

public class Songs {

    private final int ID;
    private String artist;
    private String title;
    private String Genre;
    private int playtime;
    private String location;
    private String Text;

    // klassen bliver brugt til at oprette en sang og fortælle hvad den skal indeholde
    public Songs(String title, String artist, String genre, String location, int playtime, int id) {
        this.artist = artist;
        this.title = title;
        this.Genre = genre;
        this.playtime = playtime;
        this.location = location;
        ID = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }





    public String getTitle() {
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

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String category) {
        this.Genre = Genre;
    }

    public int getPlaytime() {
        return playtime;
    }

    public int getID() {
        return ID;
    }

    public String toString() {
        return this.getTitle() + "" + this.getArtist();
    }

    public String getText() {
        return Text;
    }

    public String setText(String text) {
        Text = text;
        return text;
    }

}

