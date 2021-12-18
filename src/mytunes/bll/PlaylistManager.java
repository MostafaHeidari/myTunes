package mytunes.bll;

import mytunes.be.NewPlaylist;
import mytunes.be.Songs;
import mytunes.dal.DALManager;
import mytunes.dal.IDALManager;
import mytunes.dal.dao.PlaylistDAO;

import java.io.IOException;
import java.util.List;
// Klassen bruges til at oprette en playliste
public class PlaylistManager implements IPlaylistManager {
    private IDALManager dalManager;

    public PlaylistManager() throws IOException {
        dalManager = new DALManager();
    }



    public NewPlaylist addPlaylist(String playlistName) {
        return dalManager.addPlaylist(playlistName);

    }


    //getPlaylist
    @Override
    public List<NewPlaylist> getPlaylist() {
        List<NewPlaylist> AllPlaylists = dalManager.getPlaylist();
        return AllPlaylists;
    }


}
