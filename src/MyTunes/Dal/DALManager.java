package MyTunes.dal;

import MyTunes.be.Songs;
import MyTunes.dal.DAO.SongsDAO;
import MyTunes.dal.db.DatabaseConnector;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.util.List;

public class DALManager implements IDALManager {

    private SongsDAO songsDAO;
    private DatabaseConnector connector;


    public DALManager() {

        try {
            connector = new DatabaseConnector();
            songsDAO = new SongsDAO(connector.getConnection());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLServerException throwables) {
            throwables.printStackTrace();
        }
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
    public Songs deleteSong(Songs songDelete) {
        return null;
    }

    @Override
    public List<Songs> getSongs() {
        return songsDAO.getAllsongs();
    }

}
