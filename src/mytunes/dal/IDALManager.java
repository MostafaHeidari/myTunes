package mytunes.dal;

import mytunes.be.NewPlaylist;
import mytunes.be.Songs;
import mytunes.be.SongsInPlaylist;

import java.sql.SQLException;
import java.util.List;

public interface IDALManager {
    public Songs addSong(String title, String artist, String genre, int playtime, String location);


    public boolean deleteSong(Songs songDelete);


    public List<Songs> getSongs();

    public NewPlaylist addPlaylist(String playlistName);

    public List<NewPlaylist> getPlaylist();

    public void addSongToPlaylist(int playlistId, int songId);

}
