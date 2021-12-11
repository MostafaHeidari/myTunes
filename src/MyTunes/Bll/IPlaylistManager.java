package MyTunes.bll;

import MyTunes.be.NewPlaylist;
import MyTunes.be.Songs;

import java.util.List;

public interface IPlaylistManager {
    public NewPlaylist addPlaylist(String playlistName, int id);

    public NewPlaylist updatePlaylist(NewPlaylist playlist, String playlistName);

    public boolean deletePlaylist(NewPlaylist playlist);

    public List<NewPlaylist> getPlaylist();


}
