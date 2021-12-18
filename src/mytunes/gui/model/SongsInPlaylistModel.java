package mytunes.gui.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import mytunes.be.NewPlaylist;
import mytunes.be.SongsInPlaylist;
import mytunes.bll.SongsInPlaylistManager;

public class SongsInPlaylistModel {
    private ObservableList<mytunes.be.SongsInPlaylist> AllSongsOnPlaylist = FXCollections.observableArrayList();

    public ObservableList addSongToPlaylist() {
        addSongToPlaylist().clear();
        addSongToPlaylist().addAll(SongsInPlaylistManager.AllSongsOnPlaylist().toArray(new NewPlaylist[0]));
        return addSongToPlaylist();
    }

    public void addSongToPlaylist(int playlistId, int songId){
        SongsInPlaylist I = SongsInPlaylistManager.addSongToPlaylist(playlistId, songId);
    }


}
