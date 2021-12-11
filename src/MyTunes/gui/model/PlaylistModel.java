package MyTunes.gui.model;

import MyTunes.bll.IPlaylistManager;
import MyTunes.bll.PlaylistManager;
import MyTunes.be.NewPlaylist;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;

public class PlaylistModel {
    private ObservableList<NewPlaylist> AllPlaylists= FXCollections.observableArrayList();
    private final IPlaylistManager playlistManager;


    public PlaylistModel() throws IOException {
        playlistManager = new PlaylistManager();
    }

    public ObservableList<NewPlaylist>getAllPlaylists(){
        AllPlaylists = FXCollections.observableArrayList();
        AllPlaylists.addAll(playlistManager.getPlaylist());
        return AllPlaylists;
    }


    public void addPlaylist(String playlistName, int id){
        NewPlaylist p = playlistManager.addPlaylist(playlistName, id); //db

        AllPlaylists.add(p); // brugerflade
    }
}
