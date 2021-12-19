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
        ArrayList<Songs> allPlaylistSongs = new ArrayList<>();
        try{
            String sql = "SELECT * FROM Song INNER JOIN SongsInPlaylist ON SongsInPlaylist.SongId = Song.songid where SongsInPlaylist.PlaylistId = ?;";
            PreparedStatement preparedStatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, playlistId);
            if (preparedStatement.execute()){
                ResultSet resultSet = preparedStatement.getResultSet();
                while(resultSet.next()){
                    String title = resultSet.getString("title");

                    String artist = resultSet.getString("artist");

                    String genre = resultSet.getString("genre");

                    int playtime = resultSet.getInt("playtime");

                    String location = resultSet.getString("location");

                    int id = resultSet.getInt("songid");

                    Songs song = new Songs(title, artist, genre, location, playtime, id);
                    allPlaylistSongs.add(song);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return allPlaylistSongs;
    }

    // Metoden tilføjer sange til playlisten
    public void addSongToPlaylist(int playlistId, int songId){
        try{
            String sql = "INSERT INTO SongsInPlaylist(PlaylistID, SongID) VALUES (?,?);";
            PreparedStatement preparedStatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, playlistId);
            preparedStatement.setInt(2, songId);
            preparedStatement.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
