package MyTunes.be;

public class Songs {

    private final int id;
    public String title;
    private String artist;
    private int time;
    private String category;
    private int duration;


    // constructors en nye song.
    public Songs(int id, String title, String artist, String category,int time)
    {

        this.id = id;
        this.title = title;
        this.artist = artist;
        this.category = category;
        this.time= time;

    }

    public static void remove(Songs song) {

    }

    public static void add(Songs song) {
    }


    /* jeg kommenter for at vi kan kigge på den tilfælles
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

     */

    public int getId(){
        return id;
    }

    public String getTitle(){
        return title;
    }

    // @param title to set.
    public void setTitle(String title){
        this.title = title;
    }

    public String getArtist(){
        return artist;
    }

    // @param the artist to set.
    public void setArtist(String artist){
        this.artist = artist;
    }

    public String getCategory(){
        return category;
    }

    // @param stringTime
    public void setCategory(String category){
        this.category = category;
    }

    public int getTime(){
        return time;
    }

    public int getDuration(){
        return duration;
    }

}

