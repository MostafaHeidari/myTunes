package mytunes.bll;

import javafx.collections.FXCollections;
import mytunes.be.NewPlaylist;
import mytunes.be.SongsInPlaylist;
import mytunes.dal.DALManager;
import mytunes.dal.IDALManager;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

public class SongsInPlaylistManager {
    private IDALManager dalManager;

    public SongsInPlaylistManager()throws IOException{
        dalManager = new DALManager();
    }


    public SongsInPlaylist getSongsInPlaylist() {
        SongsInPlaylist allPlaylistSongs = dalManager.getSongsInPlaylist();
        return allPlaylistSongs;
    }

    public SongsInPlaylist addSongToPlaylist(int playlistId, int songId) {
        return (SongsInPlaylist) dalManager.addSongToPlaylist(playlistId,songId);
    }

}
