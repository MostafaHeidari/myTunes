package MyTunes.dal.DAO;

import MyTunes.be.NewPlaylist;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class PlaylistDAO {

    public PlaylistDAO() throws IOException {
    }

    public NewPlaylist createPlaylist(String name) throws SQLException {
        /*String sql = "INSERT INTO Playlist (Name) VALUES(?);";
        Connection con = connectionPool.checkOut(); // <<< Using the object pool here <<<
        try (PreparedStatement st = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            st.setString(1,name);
            st.executeUpdate();
            ResultSet rs = st.getGeneratedKeys();
            int id = 0;
            if (rs.next()){
                id = rs.getInt(1);
            }
            Playlist playlist = new Playlist(name,id);
            return playlist;
        } catch (SQLException ex) {
            throw new SQLException("Could not create playlist", ex);
        } finally {
            connectionPool.checkIn(con);
        }*/
        return null;

    }

    public List<NewPlaylist> getAllPlaylists() {
        return null;
    }
}
