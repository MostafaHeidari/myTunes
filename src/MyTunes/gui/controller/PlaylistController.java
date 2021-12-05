package sample.gui.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import MyTunes.be.NewPlaylist;
import MyTunes.be.Songs;
import MyTunes.Bll.PlaylistManager;

import java.io.IOException;

public class PlaylistModel {

    private ObservableList<NewPlaylist> allPlaylists;

    private final PlaylistManager playlistManager;

    public PlaylistModel() throws IOException {
        playlistManager = new PlaylistManager();
    }

    /**
     * Method for getting the playlists
     * @return
     */
    public ObservableList<NewPlaylist> getAllPlaylists() {
        allPlaylists = FXCollections.observableArrayList();
        allPlaylists.addAll(playlistManager.getAllPlaylists());
        return allPlaylists;
    }

    /**
     * Method to create a new playlist
     * @param name
     */
    public void createPlaylist (String name) {
        playlistManager.createPlaylist(name);
    }

}