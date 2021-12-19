package mytunes.dal.dao;

import mytunes.be.NewPlaylist;
import mytunes.be.Songs;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlaylistDAO {

    private Connection con;
    private SongsInPlaylistDAO songsInPlaylistDAO;

    public PlaylistDAO (Connection connection) {
        con = connection;
        songsInPlaylistDAO = new SongsInPlaylistDAO(con);

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

                NewPlaylist somePlaylist = new NewPlaylist(title, id);
                somePlaylist.setPlaylist(songsInPlaylistDAO.getAllPlaylistSongs(id));

                allNewPlaylist.add(somePlaylist);
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
        NewPlaylist newPlaylist = new NewPlaylist(playlistName, 1);
        return newPlaylist;    }




}
