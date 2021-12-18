package mytunes.be;

import java.util.List;

public class NewPlaylist {

    private List<Songs> playlist;
    private String playlistName;
    private int ID;
// klassen bliver brugt til at oprette en playliste og fortælle hvad der er på den
    public NewPlaylist(String playlistName, int id){
        this.playlistName = playlistName;
        this.ID = id;
    }

    public List<Songs>getPlaylist(){
        return playlist;
    }

    public void setPlaylist(List<Songs> playlist) {
        this.playlist = playlist;
    }

    public String getPlaylistName()
    {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    public int getID() {
        return ID;
    }

    public void setID(int id) {
        this.ID = id;
    }

}
