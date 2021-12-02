package MyTunes.gui.model;

import MyTunes.Bll.PlaylistManager;
import MyTunes.be.NewPlaylist;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;

public class PlaylistModel {
    private ObservableList<NewPlaylist> allPlaylists;
    private final PlaylistManager playlistManager;


    public PlaylistModel() throws IOException {
        playlistManager = new PlaylistManager();
    }

    public ObservableList<NewPlaylist>getAllPlaylists(){
        allPlaylists = FXCollections.observableArrayList();
        allPlaylists.addAll(playlistManager.getAllPlaylists());
        return allPlaylists;
    }

    public void createPlaylist(String name){
        playlistManager.createNewPlaylist(name);
    }
}
