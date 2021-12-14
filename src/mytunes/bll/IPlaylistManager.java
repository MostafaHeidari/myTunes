package mytunes.bll;

import mytunes.be.NewPlaylist;

import java.util.List;

public interface IPlaylistManager {
    public NewPlaylist addPlaylist(String playlistName);

    public NewPlaylist updatePlaylist(NewPlaylist playlist, String playlistName);

    public boolean deletePlaylist(NewPlaylist playlist);

    public List<NewPlaylist> getPlaylist();
}
