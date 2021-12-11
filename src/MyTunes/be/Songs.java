package MyTunes.be;

public class Songs {

    private final int ID;
    private String artist;
    private String title;
    private String Genre;
    private String playtime;
    private String Location;
    private String Text;

    public Songs(String title, String artist, String genre,String location, String playtime, int id)
    {
        this.artist = artist;
        this.title = title;
        this.Genre = genre;
        this.playtime= playtime;
        ID = id;

        setTitle(title);
        setArtist(artist);
        setLocation(location);
        setGenre(genre);

    }



    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }



    public Songs(String title, Object artist, Object category, Object time, int id, String artist1) {
        ID = id;
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
    public String getGenre() {
        return Genre;
    }

    public void setGenre(String category) {
        this.Genre = Genre;
    }

    public String getPlaytime() {
        return playtime;
    }

    public int getID() {
        return ID;
    }
    public String toString(){
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

