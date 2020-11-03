
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;

public class PlayerMediaJavaFX extends Application {
    PlayerJFX player;
    private final String URLVIDEO = "file:///c:/temp/midias/vidro.mp4";

    @Override
    public void start(Stage plano) throws Exception {
        player = new PlayerJFX(URLVIDEO);
        
        StackPane painel = new StackPane();
        painel.getChildren().add(player);
        
        Scene cena = new Scene(painel, 600, 420);
        
        plano.setTitle("Player de Vídeo com JavaFX");
        plano.setScene(cena);
        plano.show();
    }
    
    public static void main(String[] args) {
        launch();
    }
}