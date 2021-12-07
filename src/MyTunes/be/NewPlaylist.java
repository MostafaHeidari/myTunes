package MyTunes.be;

import javafx.scene.Parent;

import java.util.List;

public class NewPlaylist {

    private List<Songs> playlist;
    private String playlistName;
    private int ID;

    public NewPlaylist(int id,String name){
        this.playlistName = name;
        this.ID = ID;
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

    public void setID(int ID) {
        this.ID = ID;
    }
}
