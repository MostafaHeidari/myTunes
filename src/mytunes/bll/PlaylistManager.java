package mytunes.bll;

import mytunes.be.NewPlaylist;
import mytunes.dal.DALManager;
import mytunes.dal.IDALManager;

import java.io.IOException;
import java.util.List;

public class PlaylistManager implements IPlaylistManager {
    private IDALManager dalManager;

    public PlaylistManager() throws IOException {
        dalManager = new mytunes.dal.DALManager();
    }

    public NewPlaylist addPlaylist(String playlistName) {
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

    //getPlaylist
    @Override
    public List<NewPlaylist> getPlaylist() {
        List<NewPlaylist> AllPlaylists = dalManager.getPlaylist();
        return AllPlaylists;
    }
}
