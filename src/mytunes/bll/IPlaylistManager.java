package mytunes.bll;

import mytunes.be.NewPlaylist;
import mytunes.be.Songs;

import java.util.List;

public interface IPlaylistManager {
    public NewPlaylist addPlaylist(String playlistName);

    public List<NewPlaylist> getPlaylist();

    public void addSongToPlaylist(NewPlaylist playlistToAdd, Songs songToAdd);
}
