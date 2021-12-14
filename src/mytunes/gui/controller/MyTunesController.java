package mytunes.gui.controller;

import mytunes.be.NewPlaylist;
import mytunes.be.Songs;
import mytunes.gui.model.PlaylistModel;
import mytunes.gui.model.SongModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.SwipeEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MyTunesController implements Initializable {
    public Label songTextPlaying;
    private TableView<Songs> SongTable;
    @FXML
    public Slider volumeSlider;
    @FXML
    public Button btnStop;
    @FXML
    public TextField searchTextField;
    @FXML
    public Button btnSearch;
    @FXML
    public Label lblCurrentSong;
    @FXML
    public Button btnPlay;
    @FXML
    public Button btnForward;
    @FXML
    public Button btnBack;

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
    //private final PlaylistModel playlistModel = new PlaylistModel();


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

    }


    public void handleNewSong(ActionEvent actionEvent) throws IOException {
        Parent root1;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/mytunes/gui/view/newSong.fxml"));
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
        if (tableAllSongs.getSelectionModel().getSelectedIndex() != -1) {
            if (currentSongPlaying - 1 == -1) {
                currentSongPlaying = 0;
            } else {
                currentSongPlaying--;
            }
            mediaPlay();
        }
    }


    public void NextSong(MouseEvent mouseEvent) {
        if (tableAllSongs.getSelectionModel().getSelectedIndex() != -1) {
            mediaPlayer.stop();
            if (currentSongPlaying + 1 == tableAllSongs.getItems().size()) {
                currentSongPlaying = 0;
            } else {
                currentSongPlaying++;
            }
            mediaPlay();
        }
    }

    public void volumeDown(SwipeEvent swipeEvent) {
    }

    public void volumeUp(SwipeEvent swipeEvent) {
    }

    //handleNewPlaylist window

    public void handleNewPlaylist(ActionEvent actionEvent) throws IOException {
        Parent root2;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/mytunes/gui/view/newPlaylist.fxml"));
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
        if (tableAllSongs.getSelectionModel().getSelectedIndex() != -1) {
            songModel.deleteSong((Songs) tableAllSongs.getSelectionModel().getSelectedItem());
        }
    }

    public void handleEditSong(ActionEvent actionEvent) {
    }

    public void handleMusicPlayPause(ActionEvent actionEvent) {
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



    public void handleDeleteSongOnPL(ActionEvent actionEvent) {
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



    public void searchSong(ActionEvent actionEvent) {
        /*if (SearchTextField.getText() == null || SearchTextField.getText().length() <= 0){
            tableAllSongs.setItems(songModel.getAllSongs());
        }
        else {
            ObservableList<Songs> songSearcher = songModel.searchSongs(songModel.getAllSongs());
            tableAllSongs.setItems(songSearcher);
        }*/
    }

    public void handleMusicForward(ActionEvent actionEvent) {
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
