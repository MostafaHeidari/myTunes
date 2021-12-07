package MyTunes.gui.controller;

import MyTunes.be.Songs;
import MyTunes.gui.model.SongModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.media.MediaPlayer;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.*;
import java.lang.invoke.MethodHandles;
import java.net.ContentHandler;
import java.net.URL;
import java.net.URLConnection;
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
        public TextField genreField;
        @FXML
        public Button saveButton;
        @FXML
        public TextField idField;
        @FXML
        public javafx.scene.control.Button cancelButton;

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

        public void chosseFileMethod(javafx.event.ActionEvent actionEvent) throws FileNotFoundException{
            Stage stage = (Stage) cancelButton.getScene().getWindow();
            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showOpenDialog(stage);
            if (file.toString()!=null){
                String location = file.toString().replaceAll("\\\\", "/");
                try{
                    InputStream inputStream = new FileInputStream(new File(location));
                    Metadata metadata = new Metadata();
                    parser.parse(inputStream,contentHandler,metadata,parserContext);
                    inputStream.close();
                    String [] metadataName = metadata.names();

                    titleField.setText(metadata.get("title"));
                    artistField.setText(metadata.get("artist"));
                    genreField.setText(metadata.get("genre"));

                        } catch (Exception e){
                    e.printStackTrace();

                    }
                urlField.setText(location);

                }

            }


private void cancelButtonAction() {
    Stage stage = (Stage) cancelButton.getScene().getWindow();
    stage.close();
}
public void cancelCliked(MouseEvent mouseEvent){

}

public void saveSong(javafx.event.ActionEvent actionEvent){
        String title = titleField.getText();
        String artist = artistField.getText();
        String genre = genreField.getText();
        int playtime = Integer.parseInt(timeField.getText());
        String location = urlField.getText();
        int id = Integer.parseInt(idField.getText());

    Songs newSong = new Songs(title, artist, genre, location,playtime, id);
    newSong.setLocation(location);

    this.songModel.addSong(title,artist,genre,playtime,location,id);
}


    }


