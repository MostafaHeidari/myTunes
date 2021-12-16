package mytunes.dal;

import mytunes.be.NewPlaylist;
import mytunes.be.Songs;
import mytunes.dal.dao.PlaylistDAO;
import mytunes.dal.dao.SongsDAO;
import mytunes.dal.db.DatabaseConnector;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import mytunes.be.NewPlaylist;
import mytunes.be.Songs;
import mytunes.dal.IDALManager;
import mytunes.dal.dao.PlaylistDAO;
import mytunes.dal.dao.SongsDAO;
import mytunes.dal.db.DatabaseConnector;

import java.io.IOException;
import java.util.List;

public class DALManager implements IDALManager {

    private SongsDAO songsDAO;
    private DatabaseConnector connector;

    private PlaylistDAO playlistDAO;

    public DALManager() {

        try {
            connector = new DatabaseConnector();
            songsDAO = new SongsDAO(connector.getConnection());
            playlistDAO = new PlaylistDAO(connector.getConnection());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLServerException throwables) {
            throwables.printStackTrace();
        }
    }

    public NewPlaylist addPlaylist(String playlistName) {
        return playlistDAO.addPlaylist(playlistName);
    }

    //getPlaylist
    @Override
    public List<NewPlaylist> getPlaylist() {
        return playlistDAO.getAllPlaylist();
    }


    @Override
    public Songs addSong(String title, String artist, String genre, String playtime, String location) {
        return songsDAO.addSong(title, artist, genre, playtime, location);
    }

    @Override
    public Songs updateSong(Songs song, String title, String artist, String genre, String playtime, String location) {
        return null;
    }

    @Override
    public boolean deleteSong(Songs songDelete) {
        return songsDAO.deleteSong(songDelete);
    }

    @Override
    public List<Songs> getSongs() {
        return songsDAO.getAllsongs();
    }
}
