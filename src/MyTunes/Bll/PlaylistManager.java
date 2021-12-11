package MyTunes.bll;
import MyTunes.be.Songs;
import MyTunes.dal.DALManager;
import MyTunes.be.NewPlaylist;
import MyTunes.dal.DAO.PlaylistDAO;
import MyTunes.dal.IDALManager;

import java.io.IOException;
import java.util.List;

public class PlaylistManager implements IPlaylistManager {
    private IDALManager dalManager;

    public PlaylistManager() throws IOException {
        dalManager = new DALManager();
    }
    public NewPlaylist addPlaylist(String playlistName, int id) {
        return dalManager.addPlaylist(playlistName);

    }
    @Override
    public NewPlaylist updatePlaylist(NewPlaylist playlist, String playlistName) {
        return null;
    }
    @Override
    public boolean deletePlaylist(NewPlaylist playlist) {
        return false;
    }


    @Override
    public List<NewPlaylist> getPlaylist() {
        List<NewPlaylist> AllPlaylists = dalManager.getPlaylist();
        return AllPlaylists;
    }
}
