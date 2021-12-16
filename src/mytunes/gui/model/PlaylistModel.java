package mytunes.gui.model;

import mytunes.bll.IPlaylistManager;
import mytunes.bll.PlaylistManager;
import mytunes.be.NewPlaylist;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;

public class PlaylistModel {
    private ObservableList<mytunes.be.NewPlaylist> AllPlaylists = FXCollections.observableArrayList();
    private final mytunes.bll.IPlaylistManager playlistManager;


    public PlaylistModel() throws IOException {
        playlistManager = (mytunes.bll.IPlaylistManager) new mytunes.bll.PlaylistManager();
    }
    public ObservableList<mytunes.be.NewPlaylist> getAllPlaylists() {
        AllPlaylists = FXCollections.observableArrayList();
        AllPlaylists.addAll(playlistManager.getPlaylist());
        return AllPlaylists;
    }

  /* public ObservableList<NewPlaylist> getAllPlaylists() {
        AllPlaylists.clear();
        AllPlaylists.addAll(playlistManager.getPlaylist());
        return AllPlaylists;
    }

   */

//getPlaylist
    public void addPlaylist(String playlistName) {
        NewPlaylist p = playlistManager.addPlaylist(playlistName); //db

        AllPlaylists.add(p); // brugerflade
    }
}
