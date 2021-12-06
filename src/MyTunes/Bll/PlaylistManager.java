package MyTunes.Bll;

import MyTunes.be.NewPlaylist;
import java.io.IOException;
import java.util.List;
import MyTunes.Dal.PlaylistDAO;

public class PlaylistManager<PlaylistDao> {
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

    public void createPlaylist(String name) {
    }
}
