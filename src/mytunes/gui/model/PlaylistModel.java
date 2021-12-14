package mytunes.gui.model;

import mytunes.bll.IPlaylistManager;
import mytunes.bll.PlaylistManager;
import mytunes.be.NewPlaylist;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;

public class PlaylistModel {
    private ObservableList<NewPlaylist> AllPlaylists = FXCollections.observableArrayList();
    private final IPlaylistManager playlistManager;


    public PlaylistModel() throws IOException {
        playlistManager = new PlaylistManager();
    }
    public ObservableList<NewPlaylist> getAllPlaylists() {
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
