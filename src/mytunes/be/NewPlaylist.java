package mytunes.be;

import java.util.List;

public class NewPlaylist {

    private List<Songs> playlist;
    private String playlistName;
    private int ID;

    public NewPlaylist(String playlistName, int id){
        this.playlistName = playlistName;
        this.ID = ID;

        setplaylistName(playlistName);
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

    public void setplaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

}
