package tocadoraudio;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TocadorAudio extends Application {

    private final String URLAUDIO = "file:///c:/temp/audio.mp3";

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage plano) throws Exception {
        final AudioClip audio = new AudioClip(URLAUDIO);

        StackPane painel = new StackPane();
        painel.getChildren().add(new Text("Tocando áudio"));
        Scene cena = new Scene(painel, 600, 100);
        plano.setTitle("Tocando Audio com JavaFX");
        plano.setScene(cena);
        audio.play();
        plano.show();
    }
}
