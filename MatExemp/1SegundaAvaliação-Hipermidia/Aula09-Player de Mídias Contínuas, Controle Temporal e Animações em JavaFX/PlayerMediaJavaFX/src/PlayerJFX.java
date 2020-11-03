
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class PlayerJFX extends BorderPane 
{
    Media video;
    MediaPlayer player;
    MediaView visualizador;
    Pane painel;
    MediaBar barraControle;

    public PlayerJFX(String arquivo) { 
        video = new Media(arquivo);
        player = new MediaPlayer(video);
        visualizador = new MediaView(player);
        
        painel = new Pane();
        painel.getChildren().add(visualizador); 
        setCenter(painel);

        barraControle = new MediaBar(player); 
        setBottom(barraControle); 
        setStyle("-fx-background-color:#afa2a7");
        
        player.play(); 
    }
}
