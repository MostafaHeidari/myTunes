package mytunes.be;

import mytunes.gui.model.SongsInPlaylistModel;

public class SongsInPlaylist {
    private int playlistId;
    private int songId;
    private int playlistID;
    private int songID;

    public SongsInPlaylist(int playlistID, int songID){
        this.playlistId = playlistID;
        this.songId = songID;
    }



    public int getPlaylistID() {
        return playlistID;
    }

    public int getSongID() {
        return songID;
    }

    public void setPlaylistID(int playlistID) {
        this.playlistID = playlistID;
    }

    public void setSongID(int songID) {
        this.songID = songID;
    }
}
