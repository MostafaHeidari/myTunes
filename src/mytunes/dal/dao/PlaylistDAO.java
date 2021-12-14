package mytunes.dal.dao;

import mytunes.be.NewPlaylist;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlaylistDAO {

    private Connection con;

    public PlaylistDAO (Connection connection) {
        con = connection;

    }
// getAllPlaylist
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
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return allNewPlaylist;
    }


    //NewPlaylist

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
        return newPlaylist;

    }

}
