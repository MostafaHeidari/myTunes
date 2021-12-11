package MyTunes.dal.DAO;

import MyTunes.be.Songs;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class SongsDAO< AllSongs> {

    private Connection con;

    public SongsDAO(Connection connection) {
        con = connection;
    }

    public List<Songs> getAllsongs() {
        List<Songs> allSongs = new ArrayList<>();
        try{
            String sqlStatment = "SELECT * FROM [Song].[dbo].[Song]";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sqlStatment);
            while(rs.next()){
                String title = rs.getString("title");

                String artist = rs.getString("artist");

                String genre = rs.getString("genre");

                String playtime = rs.getString("playtime");

                String location = rs.getString("location");

                int id = rs.getInt("id");
                allSongs.add(new Songs(title,artist , genre, location, playtime, id));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return allSongs;
    }




    public Songs addSong(String title, String artist, String genre, String playtime, String location) {

        int insertedId = -1;
        try{
            String sqlStatment = "INSERT INTO Song (title,genre,playtime,artist,location) VALUES (?, ?, ?, ?, ?);";
            PreparedStatement statement = con.prepareStatement(sqlStatment, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1,title);
            statement.setString(2,genre);
            statement.setString(3,playtime);
            statement.setString(4,artist);
            statement.setString(5,location);
            statement.execute();
            ResultSet rs =statement.getGeneratedKeys();
            rs.next();
            insertedId = rs.getInt(1);
            } catch (SQLException e) {
            e.printStackTrace();
        }
        return new Songs(title,artist , genre, location, playtime, insertedId);
    }

    public Songs updateSong(Songs song, String title, String artist, String genre, int playtime, String location) {
        return song;
    }

    public boolean deleteSong(Songs songDelete) {
        try{
            String sqlStatment = "DELETE FROM Song WHERE id=?";
            PreparedStatement statement = con.prepareStatement(sqlStatment);
            statement.setInt(1,songDelete.getID());
            statement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Songs getSongById(int id) {
        return null;
    }
}
