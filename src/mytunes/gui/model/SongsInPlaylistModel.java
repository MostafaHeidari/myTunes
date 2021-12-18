package mytunes.gui.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import mytunes.be.NewPlaylist;
import mytunes.be.SongsInPlaylist;
import mytunes.bll.SongsInPlaylistManager;

import java.io.IOException;

public class SongsInPlaylistModel {
    private ObservableList<mytunes.be.SongsInPlaylist> AllSongsOnPlaylist = FXCollections.observableArrayList();
    private final SongsInPlaylistManager songsInPlaylistManager = new SongsInPlaylistManager();

    public SongsInPlaylistModel () throws IOException {
    }
       public ObservableList<SongsInPlaylist> allSongsOnPlaylist(){
        AllSongsOnPlaylist = FXCollections.observableArrayList();
        AllSongsOnPlaylist.addAll(SongsInPlaylistManager.getSongsInPlaylist());
        return AllSongsOnPlaylist;
    }


/*
    public ObservableList getSongToPlaylist() {
        getSongToPlaylist().clear();
        getSongToPlaylist().addAll(SongsInPlaylistManager.AllSongsOnPlaylist().toArray(new NewPlaylist[0]));
        return addSongToPlaylist();
    }
*/

    public void addSongToPlaylist(int playlistId, int songId){
        SongsInPlaylist I = SongsInPlaylistManager.addSongToPlaylist(playlistId, songId);
        AllSongsOnPlaylist.add(I);
    }


}
