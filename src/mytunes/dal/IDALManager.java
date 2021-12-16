package mytunes.dal;

import mytunes.be.NewPlaylist;
import mytunes.be.Songs;

import java.util.List;

public interface IDALManager {
    public Songs addSong(String title, String artist, String genre, String playtime, String location);


    public boolean deleteSong(Songs songDelete);


    public List<Songs> getSongs();

    NewPlaylist addPlaylist(String playlistName);

    public List<NewPlaylist> getPlaylist();
}
