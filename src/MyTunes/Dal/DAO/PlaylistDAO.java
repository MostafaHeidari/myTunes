package MyTunes.dal.DAO;

import MyTunes.be.NewPlaylist;
import MyTunes.be.Songs;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlaylistDAO {

    private Connection con;

    public PlaylistDAO (Connection connection) {
        con = connection;

    }

    public List<NewPlaylist> getAllplaylist() {
        List<NewPlaylist> allNewPlaylist = new ArrayList<>();

        try {
            String sqlStatement = "SELECT * FROM [Song].[dbo].[playlist]";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sqlStatement);
            while (rs.next()) {
                String title = rs.getString("playlistName");
                int id = rs.getInt("id");
                allNewPlaylist.add(new NewPlaylist(id,title));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public NewPlaylist addplaylist(String playlistName) {
        int insertedId = -1;
        try {
            String sqlStatement = "INSERT INTO Song (playlistName) VALUES (?);";
            PreparedStatement statement = con.prepareStatement(sqlStatement, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, playlistName);
            statement.execute();
            ResultSet rs = statement.getGeneratedKeys();
            rs.next();
            insertedId = rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        NewPlaylist newPlaylist = new NewPlaylist(0, playlistName);
        return newPlaylist;
    }

}
