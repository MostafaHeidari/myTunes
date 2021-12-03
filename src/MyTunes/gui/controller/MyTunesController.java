package MyTunes.gui.controller;

import MyTunes.be.NewPlaylist;
import MyTunes.be.Songs;
import MyTunes.gui.model.PlaylistModel;
import MyTunes.gui.model.SongModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.SwipeEvent;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MyTunesController implements Initializable {
    public Button newSong;
    public TableView tableOfSongs;
    public TableView SongsOnPlaylist;
    public TableView TabelOfPlaylist;
    public TableColumn songTitleCol;
    public TableColumn songArtistCol;
    public TableColumn songCatCol;
    public TableColumn songDurationCol;
    public ImageView musicRewind;
    private MediaPlayer mediaPlayer;
    private int currentSongPlaying;
    private SongModel songModel;
    private final PlaylistModel playlistModel = new PlaylistModel();

    private ObservableList<NewPlaylist> allPlaylists = FXCollections.observableArrayList();
    private ObservableList<Songs> allSongs = FXCollections.observableArrayList();


    public MyTunesController() throws IOException {
        songModel = new SongModel();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        allSongs = songModel.getAllSongs();
        songTitleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        songArtistCol.setCellValueFactory(new PropertyValueFactory<>("artist"));
        songCatCol.setCellValueFactory(new PropertyValueFactory<>("genre"));
        songDurationCol.setCellValueFactory(new PropertyValueFactory<>("playtime"));
        tableOfSongs.setItems(allSongs);

        playlistName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tableAllPlaylist.setItems(playlistModel.getAllPlaylists());
    }


    public void handleNewSong(ActionEvent actionEvent) throws IOException {
        Parent root1;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MyTunes/gui/view/newSong.fxml"));
        root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.setTitle("Songs");
        stage.centerOnScreen();
        stage.show();
    }


    public void handleMusicRewind(ActionEvent actionEvent) {
    }

    public void handleMoveSongToPL(ActionEvent actionEvent) {
    }

    public void PreviousSong(MouseEvent mouseEvent) {
    }

    public void handleMusicForward(ActionEvent actionEvent) {
    }

    public void NextSong(MouseEvent mouseEvent) {
    }

    public void volumeDown(SwipeEvent swipeEvent) {
    }

    public void volumeUp(SwipeEvent swipeEvent) {
    }

    public void handleNewPlaylist(ActionEvent actionEvent) throws IOException {
        Parent root2;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MyTunes/gui/view/newPlaylist.fxml"));
        root2 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root2));
        stage.setTitle("Playlist");
        stage.centerOnScreen();
        stage.show();
    }

    public void handleDeletePlaylist(ActionEvent actionEvent) {
    }

    public void handleEditPlaylist(ActionEvent actionEvent) {
    }

    public void handleMoveSongUp(ActionEvent actionEvent) {
    }

    public void handleMoveSongDown(ActionEvent actionEvent) {
    }


    public void handleDeleteSong(ActionEvent actionEvent) {
    }

    public void handleEditSong(ActionEvent actionEvent) {
    }

    public void handleMusicPlayPause(ActionEvent actionEvent) {
    }

    public void PlaySong(MouseEvent mouseEvent) {
        if(mediaPlayer == null && tableOfSongs.getSelectionModel().getSelectedIndex() != -1){
            currentSongPlaying = tableOfSongs.getSelectionModel().getSelectedIndex();
            mediaPlayer.play();
        }
    }

    public void handleDeleteSongOnPL(ActionEvent actionEvent) {
    }
@FXML
    public void closeButton(MouseEvent mouseEvent) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
}
