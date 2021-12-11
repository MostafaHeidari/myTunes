package MyTunes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class main extends Application {
private static int bredde = 800;
private static int højde = 650;


    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("gui/view/myTunes.fxml")));
        primaryStage.setTitle("MyTunes");
        primaryStage.setScene(new Scene(root, bredde, højde));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
