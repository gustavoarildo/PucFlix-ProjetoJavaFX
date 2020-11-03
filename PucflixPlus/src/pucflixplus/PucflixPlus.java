/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
https://www.youtube.com/watch?v=HqOSLZl9GUo    //indianajones trailer //aventura
https://www.youtube.com/watch?v=WEctnzPOr_I    //mazzarop trailer  //comedia
https://www.youtube.com/watch?v=5-_wIaTtsLM   //o acampamento trailer // suspence
https://www.youtube.com/watch?v=ahxc2fv1Zcc  contigo para sempre//romance
https://www.youtube.com/watch?v=gTEDClDGr5A  amizade maldita//terror
https://www.youtube.com/watch?v=6ZfuNTqbHE8  guerra infinita //ficção
 */
package pucflixplus;

import java.net.URL;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 *
 * @author gusta
 */
public class PucflixPlus extends Application {

    Pane painel;
    Scene cena;
    WebView webVideo;
    ObservableList<String> opcoesUm;
    ComboBox comboUm;
    Image imagem;
    ImageView imagemOriginal;
    Button botao;
    String lista[];
    int indice;

    @Override
    public void start(Stage plano) {

        lista = new String[6];
        lista[0] = "<iframe width=\"560\""
                + "height=\"315\""
                + "src=\"https://www.youtube.com/embed/HqOSLZl9GUo\""//aventura
                + "frameborder=\"0\" allow=\"accelerometer;"
                + "autoplay; encrypted-media; gyroscope;"
                + "picture-in-picture\" allowfullscreen></iframe>"
                + "";
        lista[1] = "<iframe width=\"560\""
                + "height=\"315\""
                + "src=\"https://www.youtube.com/embed/WEctnzPOr_I\""//comedia
                + "frameborder=\"0\" allow=\"accelerometer;"
                + "autoplay; encrypted-media; gyroscope;"
                + "picture-in-picture\" allowfullscreen></iframe>"
                + "";
        lista[2] = "<iframe width=\"560\""
                + "height=\"315\""
                + "src=\"https://www.youtube.com/embed/5-_wIaTtsLM\""//suspence
                + "frameborder=\"0\" allow=\"accelerometer;"
                + "autoplay; encrypted-media; gyroscope;"
                + "picture-in-picture\" allowfullscreen></iframe>"
                + "";
        lista[3] = "<iframe width=\"560\""
                + "height=\"315\""
                + "src=\"https://www.youtube.com/embed/ahxc2fv1Zcc\"" // romance
                + "frameborder=\"0\" allow=\"accelerometer;"
                + "autoplay; encrypted-media; gyroscope;"
                + "picture-in-picture\" allowfullscreen></iframe>"
                + "";
        lista[4] = "<iframe width=\"560\""
                + "height=\"315\""
                + "src=\"https://www.youtube.com/embed/gTEDClDGr5A\"" //terror
                + "frameborder=\"0\" allow=\"accelerometer;"
                + "autoplay; encrypted-media; gyroscope;"
                + "picture-in-picture\" allowfullscreen></iframe>"
                + "";
        lista[5] = "<iframe width=\"560\""
                + "height=\"315\""
                + "src=\"https://www.youtube.com/embed/6ZfuNTqbHE8 \"" //ficção
                + "frameborder=\"0\" allow=\"accelerometer;"
                + "autoplay; encrypted-media; gyroscope;"
                + "picture-in-picture\" allowfullscreen></iframe>"
                + "";

        opcoesUm = FXCollections.observableArrayList(
                "Aventura", "Comedia", "Suspence", "Romance", "Terror", "Ficção");
        comboUm = new ComboBox(opcoesUm);

        URL url = getClass().getResource("/PucFlixImagem.png");
        imagem = new Image(url.toString());
        imagemOriginal = new ImageView(imagem);
        imagemOriginal.setFitWidth(500);
        imagemOriginal.setPreserveRatio(true);

        botao = new Button("Mudar Canal");
        webVideo = new WebView();

        painel = new Pane();
        painel.setStyle("-fx-background-color: #" + "FF0000");
        painel.getChildren().add(imagemOriginal);
        imagemOriginal.setTranslateX(100);
        imagemOriginal.setTranslateY(100);
        
        painel.getChildren().add(comboUm);
        comboUm.getSelectionModel().selectFirst();
        comboUm.setTranslateX(100);
        comboUm.setTranslateY(0);
        
        painel.getChildren().add(botao);
        botao.setTranslateX(0);
        botao.setTranslateY(0);

        cena = new Scene(painel, 640, 480);
        plano.setTitle("PucFlix - Trailers de filmes");
        plano.setScene(cena);
        plano.show();

        indice = 0;
        botao.setOnAction((ActionEvent event) -> {
            if (painel.getChildren().contains(webVideo)) {
                painel.getChildren().remove(webVideo);
            }
            if (painel.getChildren().contains(imagemOriginal)) {
                painel.getChildren().remove(imagemOriginal);
            }

            if (((String) comboUm.getSelectionModel().getSelectedItem()).equals("Aventura")) {
                indice = 0;
            }
            if (((String) comboUm.getSelectionModel().getSelectedItem()).equals("Comedia")) {
                indice = 1;
            }
            if (((String) comboUm.getSelectionModel().getSelectedItem()).equals("Suspence")) {
                indice = 2;
            }
            if (((String) comboUm.getSelectionModel().getSelectedItem()).equals("Romance")) {
                indice = 3;
            }
            if (((String) comboUm.getSelectionModel().getSelectedItem()).equals("Terror")) {
                indice = 4;
            }
            if (((String) comboUm.getSelectionModel().getSelectedItem()).equals("Ficção")) {
                indice = 5;
            }

            webVideo.getEngine().loadContent(lista[indice], "text/html");
            webVideo.setTranslateX(50);
            webVideo.setTranslateY(50);
            painel.getChildren().add(webVideo);

            /*
            if (indice < 5) {
                indice++;
            } else {
                indice = 0;
            }
             */
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
