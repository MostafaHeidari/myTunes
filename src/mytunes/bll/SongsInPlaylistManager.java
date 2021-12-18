package mytunes.bll;

import javafx.collections.FXCollections;
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

    public Collection<Object> AllSongsOnPlaylist() {

    }

    public List<SongsInPlaylist> getSongsInPlaylist(){
    List<SongsInPlaylist> AllSongsOnPlaylist = dalManager.;
    }

    public static SongsInPlaylist addSongToPlaylist(int playlistId, int songId) {
       return dalManager.addSongPlaylist(playlistId, songId);
    }
}
