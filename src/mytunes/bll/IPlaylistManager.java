package mytunes.bll;

import mytunes.be.NewPlaylist;

import java.util.List;

public interface IPlaylistManager<addSongToPlaylist> {
    public NewPlaylist addPlaylist(String playlistName);

public void addSongToPlaylist (int playlistId, int songId);

    public List<NewPlaylist> getPlaylist();
}
