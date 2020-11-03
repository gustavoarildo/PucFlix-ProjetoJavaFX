package webviewstreaming;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class WebViewStreaming extends Application {

    Pane painel;
    Scene cena;
    WebView webVideo;
    Button botao;
    String lista[];
    int indice;

    @Override
    public void start(Stage plano) {

        lista = new String[3];
        lista[0] = "<iframe width=\"560\""
                + "height=\"315\""
                + "src=\"https://www.youtube.com/embed/qjH42oXes1M\""
                + "frameborder=\"0\" allow=\"accelerometer;"
                + "autoplay; encrypted-media; gyroscope;"
                + "picture-in-picture\" allowfullscreen></iframe>"
                + "";
        lista[1] = "<iframe width=\"560\""
                + "height=\"315\""
                + "src=\"https://www.youtube.com/embed/uxT-Ee9byeA\""
                + "frameborder=\"0\" allow=\"accelerometer;"
                + "autoplay; encrypted-media; gyroscope;"
                + "picture-in-picture\" allowfullscreen></iframe>"
                + "";
        lista[2] = "<iframe width=\"560\""
                + "height=\"315\""
                + "src=\"https://www.youtube.com/embed/rdcuOytxjKY\""
                + "frameborder=\"0\" allow=\"accelerometer;"
                + "autoplay; encrypted-media; gyroscope;"
                + "picture-in-picture\" allowfullscreen></iframe>"
                + "";

        botao = new Button("Mudar Canal");
        webVideo = new WebView();

        painel = new Pane();
        painel.getChildren().add(botao);
        botao.setTranslateX(0);
        botao.setTranslateY(0);

        cena = new Scene(painel, 640, 480);
        plano.setTitle("Streaming da Plataforma YouTube");
        plano.setScene(cena);
        plano.show();

        indice = 0;
        botao.setOnAction((ActionEvent event) -> {
            if (painel.getChildren().contains(webVideo))
                painel.getChildren().remove(webVideo);
            webVideo.getEngine().loadContent(lista[indice], "text/html");
            webVideo.setTranslateX(50);
            webVideo.setTranslateY(50);            
            painel.getChildren().add(webVideo);
            
            if (indice < 2)
                indice++;
            else
                indice = 0;
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
