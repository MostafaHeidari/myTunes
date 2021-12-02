package MyTunes.Bll;

import MyTunes.Dal.PlaylistDao;
import MyTunes.be.NewPlaylist;
import java.io.IOException;
import java.util.List;

public class PlaylistManager {
    private final PlaylistDao playlistDao;

    public PlaylistManager () throws IOException{
        playlistDao = new PlaylistDao();
    }

    public NewPlaylist createNewPlaylist(String name){
        return playlistDao.createPlaylist(name);
    }

    public List<NewPlaylist>getAllPlaylists(){
        return playlistDao.getAllPlaylists();
    }
}
