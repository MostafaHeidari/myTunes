package mytunes.gui.controller;

import mytunes.be.NewPlaylist;
import mytunes.be.Songs;
import mytunes.gui.model.PlaylistModel;
import mytunes.gui.model.SongModel;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.SwipeEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import mytunes.be.NewPlaylist;
import mytunes.be.Songs;
import mytunes.gui.model.PlaylistModel;
import mytunes.gui.model.SongModel;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MyTunesController implements Initializable {
    public Label songTextPlaying;
    public TableView songsInPlaylistTable;
    private TableView<Songs> SongTable;

    @FXML
    public Button pauseBtn;

    @FXML
    public Label lblCurrentSong;
    @FXML
    public Button btnPlay;



    @FXML
    private javafx.scene.control.Button closeButton;
    @FXML
    private TableView<Songs> tableAllSongs;
    @FXML
    private TableView<NewPlaylist> tableAllPlaylists;
    @FXML
    private TableColumn<Songs, String> songTitle;
    @FXML
    private TableColumn<Songs, String> songArtist;
    @FXML
    private TableColumn<Songs, String> songCategory;
    @FXML
    private TableColumn<Songs, Integer> songTime;
    @FXML
    private TableColumn<Songs, String> playlistName;
    private MediaPlayer mediaPlayer;
    private int currentSongPlaying = 0;
    private SongModel songModel;
    private PlaylistModel playlistModel;
    //private final PlaylistModel = new PlaylistModel();


    public MyTunesController() throws IOException {
        songModel = new SongModel();
        playlistModel = new PlaylistModel();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        songTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        songArtist.setCellValueFactory(new PropertyValueFactory<>("artist"));
        songCategory.setCellValueFactory(new PropertyValueFactory<>("genre"));
        songTime.setCellValueFactory(new PropertyValueFactory<>("playtime"));
        tableAllSongs.setItems(songModel.getAllSongs());

        //playlist
        playlistName.setCellValueFactory(new PropertyValueFactory<>("playlistName"));
        tableAllPlaylists.setItems(playlistModel.getAllPlaylists());
// indlæs den valgte playliste
       // songsInPlaylistTable.setItems(playlistModel.addSongToPlaylist());

    }

// Metoden bliver brugt til at indsætte en ny sang ved hjælp af knappen der hedder newsong
    public void handleNewSong(ActionEvent actionEvent) throws IOException {
        Parent root1;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/MyTunes/gui/view/newSong.fxml"));
        root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.setTitle("Songs");
        stage.centerOnScreen();
        stage.show();
    }


// Metoden bliver brugt til at flytte en sang over på playlisten ved hjælp af knappen der hedder MoveSongToPL
    public void handleMoveSongToPL(ActionEvent actionEvent) {
        Songs song = tableAllSongs.getSelectionModel().getSelectedItem();
        NewPlaylist playlist = tableAllPlaylists.getSelectionModel().getSelectedItem();
        playlistModel.addSongToPlaylist(playlist.getID(), song.getID());
    }


    //Metoden bliver brugt til at åbne et vindue så man kan tilføje en ny sang

    public void handleNewPlaylist(ActionEvent actionEvent) throws IOException {
        Parent root2;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/MyTunes/gui/view/newPlaylist.fxml"));
        root2 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root2));
        stage.setTitle("Playlist");
        stage.centerOnScreen();
        stage.show();
    }



    public void handleDeleteSong(ActionEvent actionEvent) {
        if (tableAllSongs.getSelectionModel().getSelectedIndex() != -1) {
            songModel.deleteSong((Songs) tableAllSongs.getSelectionModel().getSelectedItem());
        }
    }



    // new mediaPlay
    public void mediaPlay() {
        if (mediaPlayer == null) {
            Media pick = new Media(new File(tableAllSongs.getSelectionModel().getSelectedItem().getLocation()).toURI().toString());
            mediaPlayer = new MediaPlayer(pick);
            mediaPlayer.play();
            songTextPlaying.setText(tableAllSongs.getSelectionModel().getSelectedItem().getTitle());
            btnPlay.setDisable(true);
            mediaPlayer.setOnEndOfMedia(() -> {
                mediaPlayer.stop();
                mediaPlayer = null;
            });
        }else {
            mediaPlayer.pause();
            mediaPlayer = null;
        }
        System.out.println(mediaPlayer.getStatus());
    }

    public void mediaPause(){
        mediaPlayer.pause();
    }



    @FXML
    public void closeButton(MouseEvent mouseEvent) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    public void stopSong(MouseEvent mouseEvent) {
        if (mediaPlayer == null) {
            mediaPlayer.stop();
            lblCurrentSong.setText("No song is playing");
            mediaPlayer = null;
        }
    }



    public void handleCloseApp() {
        System.exit(0);
    }


    public void handlePlay(ActionEvent actionEvent) {
        if (mediaPlayer == null && tableAllSongs.getSelectionModel().getSelectedIndex() != -1) {
            currentSongPlaying = tableAllSongs.getSelectionModel().getSelectedIndex();
            mediaPlay();
        }

    }
}
