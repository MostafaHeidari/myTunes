package mytunes.gui.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import mytunes.be.NewPlaylist;
import mytunes.bll.PlaylistManager;

import java.io.IOException;

public class PlaylistModel {
    private ObservableList<mytunes.be.NewPlaylist> AllPlaylists = FXCollections.observableArrayList();
    private final PlaylistManager playlistManager = new PlaylistManager();


    public PlaylistModel() throws IOException {
    }
    public ObservableList<mytunes.be.NewPlaylist> getAllPlaylists() {
        AllPlaylists = FXCollections.observableArrayList();
        AllPlaylists.addAll(playlistManager.getPlaylist());
        return AllPlaylists;
    }


//metoden bliver brugt til at tilføje en playliste til brugergrænsefladen
    public void addPlaylist(String playlistName) {
        NewPlaylist p = playlistManager.addPlaylist(playlistName); //db

        AllPlaylists.add(p); // brugergrænsefladen
    }
// Metoden bliver brugt til at tilføje en sang på en playliste
    public void addSongToPlaylist(int playlistId, int songId){
        playlistManager.addSongToPlaylist(playlistId, songId);
    }
}
