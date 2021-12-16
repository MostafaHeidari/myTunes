package mytunes.dal;

import mytunes.be.NewPlaylist;
import mytunes.be.Songs;
import mytunes.dal.dao.PlaylistDAO;
import mytunes.dal.dao.SongsDAO;
import mytunes.dal.db.DatabaseConnector;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.io.IOException;
import java.util.List;

public class DALManager implements IDALManager {

    private SongsDAO songsDAO;
    private DatabaseConnector connector;

    private PlaylistDAO playlistDAO;

    // Den her metode før så databasen bliver coneketet med dao'erne
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

    // Denne metode opretter en playliste
    public NewPlaylist addPlaylist(String playlistName) {
        return playlistDAO.addPlaylist(playlistName);
    }

    //getPlaylist
    @Override
    public List<NewPlaylist> getPlaylist() {
        return playlistDAO.getAllPlaylist();
    }

// Den her metode hjælper med at oprette en sang
    public Songs addSong(String title, String artist, String genre, int playtime, String location) {
        return songsDAO.addSong(title, artist, genre, playtime, location);
    }

// Den her metode hjælper med at slette en sang
    @Override
    public boolean deleteSong(Songs songDelete) {
        return songsDAO.deleteSong(songDelete);
    }

    // Den her metode bliver brugt til at tilføje en sang til playlisten
    @Override
    public List<Songs> getSongs() {
        return songsDAO.getAllsongs();
    }
    public void addSongToPlaylist(int playlistId, int songId){
        playlistDAO.addSongToPlaylist(playlistId, songId);
    }
}
