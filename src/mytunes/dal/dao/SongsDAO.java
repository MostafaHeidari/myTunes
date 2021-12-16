package mytunes.dal.dao;

import mytunes.be.Songs;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class SongsDAO< AllSongs> {

    private Connection con;

    public SongsDAO(Connection connection) {
        con = connection;
    }

    //Den conekter programmet til databasen og får sangene som output
    public List<Songs> getAllsongs() {
        List<Songs> allSongs = new ArrayList<>();
        try{
            String sqlStatement = "SELECT * FROM [Song].[dbo].[Song]";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sqlStatement);
            while(rs.next()){
                String title = rs.getString("title");

                String artist = rs.getString("artist");

                String genre = rs.getString("genre");

                int playtime = rs.getInt("playtime");

                String location = rs.getString("location");

                int id = rs.getInt("songid");
                allSongs.add(new Songs(title,artist , genre, location, playtime, id));
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }


        return allSongs;
    }



// Den tilføjer sange til listen over sange
    public Songs addSong(String title, String artist, String genre, int playtime, String location) {

        int insertedId = -1;
        try{
            String sqlStatement = "INSERT INTO Song (title,genre,playtime,artist,location) VALUES (?, ?, ?, ?, ?);";
            PreparedStatement statement = con.prepareStatement(sqlStatement, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1,title);
            statement.setString(2,genre);
            statement.setInt(3,playtime);
            statement.setString(4,artist);
            statement.setString(5,location);
            statement.execute();
            ResultSet rs =statement.getGeneratedKeys();
            rs.next();
            insertedId = rs.getInt(1);
            } catch (SQLException e) {
            e.printStackTrace();
        }
        return new Songs(title, artist, genre, location, playtime, insertedId);
    }

// Den sletter en sang fra listen med sange
    public boolean deleteSong(Songs songDelete) {
        try{
            String sqlStatement = "DELETE FROM Song WHERE id=?";
            PreparedStatement statement = con.prepareStatement(sqlStatement);
            statement.setInt(1,songDelete.getID());
            statement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


}
