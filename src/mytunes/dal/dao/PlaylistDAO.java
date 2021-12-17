package mytunes.dal.dao;

import mytunes.be.NewPlaylist;
import mytunes.be.Songs;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlaylistDAO {

    private Connection con;

    public PlaylistDAO (Connection connection) {
        con = connection;

    }
// getAllPlaylist bliver brugt til at indsætte en playliste i databsen den conekter derfor programmet til databasen
    public List<NewPlaylist> getAllPlaylist() {
        List<NewPlaylist> allNewPlaylist = new ArrayList<>();
        try {
            String sqlStatement = "SELECT * FROM [Song].[dbo].[playlist]";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sqlStatement);
            while (rs.next()) {
                String title = rs.getString("playlistName");
                int id = rs.getInt("id");
                allNewPlaylist.add(new NewPlaylist(title, id));
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return allNewPlaylist;
    }


    //addPlaylist bliver brugt til at tilføje en playliste

    public NewPlaylist addPlaylist(String playlistName) {
        int insertedId = -1;
        try {
            String sqlStatement = "INSERT INTO playlist (playlistName) VALUES (?);";
            PreparedStatement statement = con.prepareStatement(sqlStatement, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, playlistName);
            statement.execute();
            ResultSet rs = statement.getGeneratedKeys();
            rs.next();
            insertedId = rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        NewPlaylist newPlaylist = new NewPlaylist(playlistName,0);
        return newPlaylist;    }


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
