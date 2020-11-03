
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
import javafx.util.Duration;

public class MediaBar extends HBox {

    Slider controleTempoVideo, controleVolumeAudio;
    Button botaoPlay;
    Button botaoPosiciona;
    Label labelVolume;
    TextField comando;
    Duration pontoTempoVideo;
    MediaPlayer player;
    HBox painelControle;

    public MediaBar(MediaPlayer objetoPlayerVideo) {
        controleTempoVideo = new Slider();
        controleVolumeAudio = new Slider();
        botaoPlay = new Button("||");
        botaoPosiciona = new Button("Posiciona");
        labelVolume = new Label("Volume ");
        comando = new TextField("");

        controleVolumeAudio.setPrefWidth(70);
        controleVolumeAudio.setMinWidth(30);
        controleVolumeAudio.setValue(100);
        controleTempoVideo.setValue(0);

        painelControle = new HBox(5);
        painelControle.getChildren().addAll(botaoPlay, controleTempoVideo,
                labelVolume, controleVolumeAudio,
                comando, botaoPosiciona);

        player = objetoPlayerVideo;
        setAlignment(Pos.CENTER);
        getChildren().add(painelControle);

        botaoPlay.setOnAction((ActionEvent evento) -> {
            Status status = player.getStatus();
            // Vídeo em execução
            if (status == Status.PLAYING) {
                // Atingiu o final do vídeo
                if (player.getCurrentTime().greaterThanOrEqualTo(player.getTotalDuration())) {
                    player.seek(player.getStartTime());
                    player.play();
                } else {
                    // Pausar o vídeo
                    player.pause();
                    botaoPlay.setText(">");
                }
            }
            // Se o vídeo estiver pausado
            if (status == Status.HALTED
                    || status == Status.STOPPED
                    || status == Status.PAUSED) {
                player.play();
                botaoPlay.setText("||");
            }
        });

        botaoPosiciona.setOnAction((ActionEvent event) -> {
            if (comando.getText().equals("geladeira")) {
                pontoTempoVideo = new Duration(75000);
                pontoTempoVideo.toSeconds();
            }
            if (comando.getText().equals("roupas")) {
                pontoTempoVideo = new Duration(240000);
                pontoTempoVideo.toSeconds();
            }
            if (comando.getText().equals("fim")) {
                pontoTempoVideo = new Duration(320000);
                pontoTempoVideo.toSeconds();
            }
            player.seek(pontoTempoVideo);
        });
        
        //coloca o slider de tempo no mesmo ponto que o video esta tocando
        player.currentTimeProperty().addListener((obs, oldTime, newTime) -> {
            //ele não perde a posição certa mesmo se for clicado para pular em uma parte do video
            if (!controleTempoVideo.isPressed()) {
                controleTempoVideo.setValue(newTime.toSeconds() / player.getTotalDuration().toSeconds()*100 );
            }
        });

        // Posicionar em um ponto específico do vídeo
        controleTempoVideo.valueProperty().addListener((Observable observador) -> {
            // Movimento do slider de tempo para um ponto de clique
            if (controleTempoVideo.isPressed()) {
                player.seek(player.getMedia().getDuration().multiply(controleTempoVideo.getValue() / 100));
            }
        });

        // Controlador do slider de volume
        controleVolumeAudio.valueProperty().addListener((Observable observador) -> {
            if (controleVolumeAudio.isPressed()) {
                player.setVolume(controleVolumeAudio.getValue() / 100);
            }
        });
    }
}
