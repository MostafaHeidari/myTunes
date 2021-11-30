package MyTunes.controller;

public class Songs {

    public String artist;
    public String title;
    public String category;
    public int time;

    public Songs(String title, String artist, String category, int time)
    {
        this.artist = artist;
        this.title = title;
        this.category = category;
        this.time= time;
    }

    public Songs(String title, Object artist, Object category, Object time, String artist1) {
        this.artist = artist1;
    }

    public static void remove(Songs song) {
    }

    public static void add(Songs song) {
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
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}

