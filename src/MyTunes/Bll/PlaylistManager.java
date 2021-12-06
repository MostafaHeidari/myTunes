package MyTunes.Bll;

import MyTunes.be.NewPlaylist;
import MyTunes.Dal.PlaylistDAO;
import java.io.IOException;
import java.util.List;

public class PlaylistManager<PlaylistDao> {
    private final PlaylistDao playlistDao;

    public PlaylistManager () throws IOException{
        playlistDao = (PlaylistDao) new PlaylistDAO();
    }

    public NewPlaylist createNewPlaylist(String name){
        return PlaylistDAO.createPlaylist(name);
    }

    public List<NewPlaylist>getAllPlaylists(){
        return PlaylistDAO.getAllPlaylists();
    }

    public void createPlaylist(String name) {
    }
}
