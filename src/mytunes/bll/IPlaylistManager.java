package mytunes.bll;

import mytunes.be.NewPlaylist;

import java.util.List;

public interface IPlaylistManager {
    public NewPlaylist addPlaylist(String playlistName);

    public List<NewPlaylist> getPlaylist();
}
