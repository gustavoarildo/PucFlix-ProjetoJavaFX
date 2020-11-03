package tocadorvideo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class TocadorVideo extends Application {

    private String URLVIDEO = "file:///c:/temp/televideo02.mp4";
    Button botaoInfo;
    
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage plano) throws Exception {

        Media video = new Media(URLVIDEO);
        final MediaPlayer mediaPlayer = new MediaPlayer(video);
        MediaView mediaView = new MediaView(mediaPlayer);
        
        botaoInfo = new Button("Informação");        
        botaoInfo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                System.out.println("Duração em segundos = " +
                        mediaPlayer.getMedia().getDuration().toMinutes());
                System.out.println("Tempo decorrido = " +
                        mediaPlayer.getCurrentTime().toSeconds());
                System.out.println("Quantidade de Metadados = " +
                        mediaPlayer.getMedia().getMetadata().size());            }
        });

        StackPane painel = new StackPane();
        painel.getChildren().addAll(mediaView, botaoInfo);
        Scene cena = new Scene(painel, 600, 400);
        plano.setTitle("Tocando Video com JavaFX");
        plano.setScene(cena);
        plano.show();

        mediaPlayer.play();
    }
}
