package mytunes.gui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.MediaPlayer;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import mytunes.gui.model.SongModel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class NewSongController implements Initializable {
    @FXML
    public TextField titleField;
    @FXML
    public TextField artistField;
    @FXML
    public TextField timeField;
    @FXML
    public TextField urlField;
    @FXML
    public TextField categoryField;
    @FXML
    public Button saveButton;
    @FXML
    public TextField idField;
    @FXML
    public Button cancelButton;

    private final SongModel songModel = new SongModel();
    private final MyTunesController myTunesController = new MyTunesController();
    private MediaPlayer mediaPlayer;
    private Object contentHandler;
    private Runtime.Version parser;


    public NewSongController() throws IOException {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
// Metoden bliver brugt til at man skal kunne tilføje en fill så man kan få en sang ind i programmet
    public void chooseFileMethod(ActionEvent actionEvent) throws FileNotFoundException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Song");
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")+ System.getProperty("file.separator") +"Desktop"));
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.aac"),
                new FileChooser.ExtensionFilter("All Files", "*.*")
        );

        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {
            //insert data from file
            urlField.setText(selectedFile.getAbsolutePath());
        }

    }

    // knappen gør så man kan lukke programmet

    private void cancelButtonAction() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

// Metoden gør så man ved hjælp af save kan gemme en sang i programmet
    public void saveSong(ActionEvent actionEvent) {
        String title = titleField.getText();
        String artist = artistField.getText();
        String genre = categoryField.getText();
        int playtime = Integer.parseInt(timeField.getText());
        String location = urlField.getText();

        this.songModel.addSong(title, artist, genre, playtime, location);
    }


}


