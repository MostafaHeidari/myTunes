package mytunes.gui.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import mytunes.be.NewPlaylist;
import mytunes.be.Songs;
import mytunes.bll.PlaylistManager;

import java.io.IOException;

public class PlaylistModel {
    private ObservableList<NewPlaylist> AllPlaylists = FXCollections.observableArrayList();
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

// Adds songs to a playlist
    public void addSongToPlaylist(NewPlaylist playlistToAdd, Songs songToAdd) {

        // Add the song to playlist in the database
        playlistManager.addSongToPlaylist(playlistToAdd, songToAdd);
        // find the playlist inside the arraylist
        int index = AllPlaylists.indexOf(playlistToAdd);
        NewPlaylist foundPlaylist = AllPlaylists.get(index);
        // add the song to the found playlist
        foundPlaylist.addToPlaylist(songToAdd);
        //replace the old playlist with the newly modified playlist
        AllPlaylists.set(index, foundPlaylist);
    }



}
