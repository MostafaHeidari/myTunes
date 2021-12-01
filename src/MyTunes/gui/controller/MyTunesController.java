package MyTunes.gui.controller;

import MyTunes.gui.model.SongModel;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class MyTunesController implements Initializable {

    public TableView tableViewSongs;
    public TableColumn songDurationCol;
    public TableView tableViewPlaylists;
    public TableColumn songCatCol;
    public TableColumn songTitleCol;
    public TextField filterSearch;
    public Button newSongBtn;
    public Button Delete3;
    public Button musicPlayPause;

    private ObservableList observableListSongs;
    private SongModel mediaPlayer;

    public TableColumn songArtistCol;
    public TableColumn col_PName;
    public TableColumn col_PSongs;
    public TableColumn col_PTime;



    public Button musicRewind;
    public TableView table_View_Songs_on_Playlists;
    public Button newPlaylist;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    public void handleMoveSongToPL(ActionEvent actionEvent) {
    }

    public void handleMusicRewind(ActionEvent actionEvent) {
    }

    public void handleMusicForward(ActionEvent actionEvent) {
    }

    public void handleNewPlaylist(ActionEvent actionEvent) {
    }

    public void handleDeletePlaylist(ActionEvent actionEvent) {
    }

    public void handleEditPlaylist(ActionEvent actionEvent) {
    }

    public void handleMoveSongUp(ActionEvent actionEvent) {
    }

    public void handleMoveSongDown(ActionEvent actionEvent) {
    }

    public void handleCloseApp(ActionEvent actionEvent) {
    }

    public void handleNewSong(ActionEvent actionEvent) {
    }

    public void handleDeleteSong(ActionEvent actionEvent) {
    }

    public void handleEditSong(ActionEvent actionEvent) {
    }

    public void handleMusicPlayPause(ActionEvent actionEvent) {
    }

    public void handleDeleteSongOnPL(ActionEvent actionEvent) {
    }
}
