package mytunes.dal.dao;

import mytunes.be.NewPlaylist;
import mytunes.be.Songs;
import mytunes.be.SongsInPlaylist;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SongsInPlaylistDAO {


    private Connection con;

    public SongsInPlaylistDAO (Connection connection) {
        con = connection;

    }

    //Den finder sangene i databasen og så får programmet dem som output
    public List<Songs> getAllPlaylistSongs(int playlistId) throws SQLException{
        ArrayList<Songs> allSongs = new ArrayList<>();
        try{
            String sql = "SELECT * FROM Song INNER JOIN SongsInPlaylist ON SongsInPlaylist.SongId = Song.id where SongsInPlaylist.PlaylistId = ?;";
            PreparedStatement preparedStatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, playlistId);
            if (preparedStatement.execute()){
                ResultSet resultSet = preparedStatement.getResultSet();
                while(resultSet.next()){
                    int id = resultSet.getInt("songid");
                    String title = resultSet.getString("title");
                    String genre = resultSet.getString("genre");
                    int playTime = resultSet.getInt("playTime");
                    String artistName = resultSet.getString("artistName");
                    String location = resultSet.getString("location");
                    Songs song = new Songs(title, artistName, genre, location, playTime, id);
                    allSongs.add(song);
                }

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }
        return allSongs;
    }

    // Metoden tilføjer sange til playlisten
    public SongsInPlaylist addSongToPlaylist(int playlistId, int songId){
        try{
            String sql = "INSERT INTO SongsInPlaylist(PlaylistID, SongID) VALUES (?,?);";
            PreparedStatement preparedStatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, playlistId);
            preparedStatement.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        SongsInPlaylist songsInPlaylist = new SongsInPlaylist(1, 1);
        return songsInPlaylist;    }

}
