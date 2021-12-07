package MyTunes.bll;

import MyTunes.be.NewPlaylist;
import MyTunes.dal.DAO.PlaylistDAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class PlaylistManager<PlaylistDao> {
    private final PlaylistDAO playlistDao;

    public PlaylistManager () throws IOException{
        playlistDao =  new PlaylistDAO();
    }

    public NewPlaylist createNewPlaylist(String name){
        try {
            return playlistDao.createPlaylist(name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<NewPlaylist>getAllPlaylists(){
        return playlistDao.getAllPlaylists();
    }

    public void createPlaylist(String name) {
    }
}
