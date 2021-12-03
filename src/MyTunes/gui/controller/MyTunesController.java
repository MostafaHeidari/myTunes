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

import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.SwipeEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import jdk.jfr.Label;


import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MyTunesController implements Initializable {
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
    private TableView<Songs> tableAllsongs;
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

    private java.awt.Label SearchTextField;


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
        tableAllPlaylists.setItems(playlistModel.getAllPlaylists());
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
        if (tableOfSongs.getSelectionModel().getSelectedIndex() != -1){
            if (currentSongPlaying -1 == -1){
                currentSongPlaying = 0;
            }
            else {
                currentSongPlaying --;
            }
            play();
        }
    }



    public void NextSong(MouseEvent mouseEvent)
    {if(tableOfSongs.getSelectionModel().getSelectedIndex()!= -1){
        mediaPlayer.stop();
        if(currentSongPlaying +1 == tableOfSongs.getItems().size()){
            currentSongPlaying = 0;
        }
        else {
            currentSongPlaying++;
        }
        play();
    }
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
        if(tableOfSongs.getSelectionModel().getSelectedIndex() != -1)
        {
            songModel.deleteSong((Songs) tableOfSongs.getSelectionModel().getSelectedItem());
        }
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

    public void stopSong(MouseEvent mouseEvent) {
        if(mediaPlayer == null){
            mediaPlayer.stop();
            lblCurrentSong.setText("No song is playing");
            mediaPlayer = null;
        }
    }

    private void play(){
        mediaPlayer = new MediaPlayer(new Media(new File(tableOfSongs.getItems().get(currentSongPlaying).getTitle().toString)));
        mediaPlayer.play();
        mediaPlayer.setVolume(50);
        lblCurrentSong.setText(tableOfSongs.getItems().get(currentSongPlaying).getTitle.toString);
    }

    public void searchSong(ActionEvent actionEvent) {
        if (SearchTextField.getText() == null || SearchTextField.getText().length() <= 0){
            tableOfSongs.setItems(songModel.getAllSongs());
        }
        else {
            ObservableList<Songs> songSearcher = songModel.searchSongs(songModel.getAllSongs(),SearchTextField.getText());
            tableOfSongs.setItems(songSearcher);
        }
    }

    public void handleMusicForward(ActionEvent actionEvent) {
    }
}
