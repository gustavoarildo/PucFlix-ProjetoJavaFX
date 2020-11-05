/*
 * Alunos: Gustavo Arildo Felix, Ronaldo Carvalho e Adriano Oliveira
 * SISTEMAS MULTIMÍDIA E HIPERMÍDIA - Ciencias da Computação - PUC Poços de Caldas 
 * PucFlixPlus - Trailers de filmes

Links de videos utilizados do YouTube
https://www.youtube.com/watch?v=HqOSLZl9GUo    //indianajones trailer //aventura
https://www.youtube.com/watch?v=WEctnzPOr_I    //mazzarop trailer  //comedia
https://www.youtube.com/watch?v=5-_wIaTtsLM   //o acampamento trailer // suspence
https://www.youtube.com/watch?v=ahxc2fv1Zcc  //contigo para sempre//romance
https://www.youtube.com/watch?v=gTEDClDGr5A  //amizade maldita//terror
https://www.youtube.com/watch?v=6ZfuNTqbHE8  //guerra infinita //ficção
 */
package pucflixplus;
//Importaçoes

import java.awt.event.MouseEvent;
import java.net.URL;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.SVGPath;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class PucflixPlus extends Application {

    //Atributos
    Pane painel;
    Scene cena;
    WebView webVideo;
    ObservableList<String> opcoesUm;
    ComboBox comboUm;
    Image imagem;
    ImageView imagemLOGO;
    ImageView imagemLOGO2;
    Button botao;
    Button botaoAventura1;
    Label labelAventura1;
    Button botaoAventura2;
    Label labelAventura2;
    Button botaoComedia1;
    Label labelComedia1;
    Button botaoComedia2;
    Label labelComedia2;
    String lista[];
    String svgPathBluray = "m213.9 1041.2c-57.433 0-104.03 46.598-104.03 104.03 0 57.433 46.598 104.06 104.03 104.06 57.433 0 104.06-46.629 104.06-104.06 0-57.433-46.629-104.03-104.06-104.03zm0 76.906c14.981 0.0001 27.156 12.144 27.156 27.125 0.00001 14.981-12.175 27.156-27.156 27.156s-27.125-12.175-27.125-27.156c-0.00001-14.981 12.144-27.125 27.125-27.125z";
    String svgPathChapel = "m128.52 0c-20.48 0.54764-31.783 2.6636-49.472 11.562-6.029 3.034-12.079 10.265-3.625 8.657 10.99-2.091 20.071-9.962 29.817-13.532 5.04-1.847 23.28-6.687 23.28-6.687zm13.781 2c-3.6329 0.0905-7.0503 0.43471-9.8125 1.0625-6.8409 1.5548-26.805 6.8585-22.188 18.25 2.0136 4.9676 5.3892 4.9354 12.094 7.0312 16.7 5.2205 39.079 0.1269 48.031-11.719 7.79-10.306-12.38-15.016-28.12-14.624zm-54.096 2.3125c-10.675 2.5285-23.439 10.292-28.312 18.625 0 0-3.25 4.3425-3.25 10.844 0 3.7467 1.7565 25.855 3.2812 44.469-18.427 6.1517-28.361 10.781-44.406 24.156-6.9906 5.827-11.247 12.238-14.406 20.625-2.0953 5.5628-1.006 11.192 1.4375 15.812 3.0336 5.7359 8.4081 10.822 14.156 12.5 3.3372 0.97413 6.0822 1.3438 13.594 1.3438 7.5636 0 29.956-3.517 50.125-10s79.227-23.408 103.72-29.531c24.492-6.1229 57.269-15.855 63.031-17.656 3.8407-1.2002 6.7197-2.0844 8.2188-2.5312 0.77209-0.23013 1.2455-0.68182 1.5938-1.25 0.20081-0.32762 0.16348-0.67504 0.0937-0.9375-0.097-0.3653-0.51231-0.53125-2.2812-0.53125-3.0399 0-9.1233 1.5167-21.5-0.4375s-25.569-5.2544-32.688-7.4688c-2.5037-0.77884-4.6204-2.0706-5.5625-2.6875-0.20675-0.87686-8.2542-35.032-13.781-61.062-6.6066 18.23-22.982 24.543-48.406 23.844-17.8-0.488-38.709-8.677-36.843-22.936 0.87083-6.6543 8.125-11 8.125-11s-11.384 6.6833-17.344 10.656c-6.041 3.9187-13.443 5.3115-20.656 4.75-3.221-0.768-1.724-3.241-0.719-4.437 5.494-6.541 12.452-11.503 22.781-15.156zm106.88 76.219c3.49 1.8717 6.541 2.8824 10.5 3.9062 4.198 1.0857 22.65 5.5065 31.625 6.375 8.9749 0.86854 15.157-0.0705 17.188-0.25 0.8507-0.0752 1.9925-0.0383 2.375 0.15625 0.12013 0.0611 0.28481 0.28952 0.15625 0.5625-0.61917 1.3148-1.8773 1.0398-3.1875 1.0625-5.0236 0.087-15.388 0.83379-25.281 2.8125-14.407 2.8814-33.138 4.6748-48.625 10.438-15.487 5.7627-29.906 13.334-44.312 17.656-14.407 4.322-31.65 10.501-57.062 18-23.554 6.9502-51.427 10.932-60.906 8.5312-5.2375-1.3268-10.192-3.6539-14.281-10.875-2.2277-3.9342-3.3332-8.5243-1.4062-14.156 3.4671-10.133 15.145-17.51 25.031-23.094 10.192-5.756 19.459-9.4528 33.719-9.8125 0.15475-0.004 0.2855 0.003 0.4375 0 0.5888 7.0612 1.0312 12.188 1.0312 12.188s1.6062 4.426 17.5 4.6875c29.443 0.48449 75.957-10.238 109.44-22.562 4.8111-1.771 5.8608-4.8208 6.0625-5.625zm2.625 4.1562c-17.725 12.835-46.784 18.227-79.469 24.531-13.464 2.597-35.974 4.2016-44.281 2.9375-8.3071-1.2641-12.781-5.0625-12.781-5.0625 2.8804 11.596 43.926 5.9796 52.875 4.3438 12.873-2.3531 22.646-4.2671 35.094-7.0625 14.966-3.361 40.834-10.313 48.562-19.688z";
    String svgPathBluraycomedia = "m213.9 1041.2c-57.433 0-104.03 46.598-104.03 104.03 0 57.433 46.598 104.06 104.03 104.06 57.433 0 104.06-46.629 104.06-104.06 0-57.433-46.629-104.03-104.06-104.03zm0 76.906c14.981 0.0001 27.156 12.144 27.156 27.125 0.00001 14.981-12.175 27.156-27.156 27.156s-27.125-12.175-27.125-27.156c-0.00001-14.981 12.144-27.125 27.125-27.125z";
    String svgPathChapelcomedia = "m128.52 0c-20.48 0.54764-31.783 2.6636-49.472 11.562-6.029 3.034-12.079 10.265-3.625 8.657 10.99-2.091 20.071-9.962 29.817-13.532 5.04-1.847 23.28-6.687 23.28-6.687zm13.781 2c-3.6329 0.0905-7.0503 0.43471-9.8125 1.0625-6.8409 1.5548-26.805 6.8585-22.188 18.25 2.0136 4.9676 5.3892 4.9354 12.094 7.0312 16.7 5.2205 39.079 0.1269 48.031-11.719 7.79-10.306-12.38-15.016-28.12-14.624zm-54.096 2.3125c-10.675 2.5285-23.439 10.292-28.312 18.625 0 0-3.25 4.3425-3.25 10.844 0 3.7467 1.7565 25.855 3.2812 44.469-18.427 6.1517-28.361 10.781-44.406 24.156-6.9906 5.827-11.247 12.238-14.406 20.625-2.0953 5.5628-1.006 11.192 1.4375 15.812 3.0336 5.7359 8.4081 10.822 14.156 12.5 3.3372 0.97413 6.0822 1.3438 13.594 1.3438 7.5636 0 29.956-3.517 50.125-10s79.227-23.408 103.72-29.531c24.492-6.1229 57.269-15.855 63.031-17.656 3.8407-1.2002 6.7197-2.0844 8.2188-2.5312 0.77209-0.23013 1.2455-0.68182 1.5938-1.25 0.20081-0.32762 0.16348-0.67504 0.0937-0.9375-0.097-0.3653-0.51231-0.53125-2.2812-0.53125-3.0399 0-9.1233 1.5167-21.5-0.4375s-25.569-5.2544-32.688-7.4688c-2.5037-0.77884-4.6204-2.0706-5.5625-2.6875-0.20675-0.87686-8.2542-35.032-13.781-61.062-6.6066 18.23-22.982 24.543-48.406 23.844-17.8-0.488-38.709-8.677-36.843-22.936 0.87083-6.6543 8.125-11 8.125-11s-11.384 6.6833-17.344 10.656c-6.041 3.9187-13.443 5.3115-20.656 4.75-3.221-0.768-1.724-3.241-0.719-4.437 5.494-6.541 12.452-11.503 22.781-15.156zm106.88 76.219c3.49 1.8717 6.541 2.8824 10.5 3.9062 4.198 1.0857 22.65 5.5065 31.625 6.375 8.9749 0.86854 15.157-0.0705 17.188-0.25 0.8507-0.0752 1.9925-0.0383 2.375 0.15625 0.12013 0.0611 0.28481 0.28952 0.15625 0.5625-0.61917 1.3148-1.8773 1.0398-3.1875 1.0625-5.0236 0.087-15.388 0.83379-25.281 2.8125-14.407 2.8814-33.138 4.6748-48.625 10.438-15.487 5.7627-29.906 13.334-44.312 17.656-14.407 4.322-31.65 10.501-57.062 18-23.554 6.9502-51.427 10.932-60.906 8.5312-5.2375-1.3268-10.192-3.6539-14.281-10.875-2.2277-3.9342-3.3332-8.5243-1.4062-14.156 3.4671-10.133 15.145-17.51 25.031-23.094 10.192-5.756 19.459-9.4528 33.719-9.8125 0.15475-0.004 0.2855 0.003 0.4375 0 0.5888 7.0612 1.0312 12.188 1.0312 12.188s1.6062 4.426 17.5 4.6875c29.443 0.48449 75.957-10.238 109.44-22.562 4.8111-1.771 5.8608-4.8208 6.0625-5.625zm2.625 4.1562c-17.725 12.835-46.784 18.227-79.469 24.531-13.464 2.597-35.974 4.2016-44.281 2.9375-8.3071-1.2641-12.781-5.0625-12.781-5.0625 2.8804 11.596 43.926 5.9796 52.875 4.3438 12.873-2.3531 22.646-4.2671 35.094-7.0625 14.966-3.361 40.834-10.313 48.562-19.688z";

    int indice;

    @Override
    public void start(Stage plano) {

        //Lista vai receber os links dos videos da plataforma Youtube, um para cada indice
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

        //As opçoes disponiveis no comboBox de seleção de genero
        opcoesUm = FXCollections.observableArrayList(
                "Aventura", "Comedia", "Suspence", "Romance", "Terror", "Ficção");
        comboUm = new ComboBox(opcoesUm);

        //Recupera a imagem matricial de logotipo da pasta de recursos do projeto, com largura em 600 e aspecto de proporçoes preservado
        URL url = getClass().getResource("/PucFlixImagem.png");
        imagem = new Image(url.toString());
        imagemLOGO = new ImageView(imagem);
        imagemLOGO.setFitWidth(600);
        imagemLOGO.setPreserveRatio(true);

        //A imagem matricial de logotipo é utilizada novamente em tamanho menor no menu superior assim valorizando a interface grafica
        imagemLOGO2 = new ImageView(imagem);
        imagemLOGO2.setFitWidth(100);
        imagemLOGO2.setPreserveRatio(true);

        //A imagem vetorial que sra usada como icone tem seus valores ajustados
        SVGPath bluray;
        bluray = new SVGPath();
        bluray.setContent(svgPathBluray);
        bluray.setFill(Color.BLUE);
        bluray.setScaleX(0.5);
        bluray.setScaleY(0.5);
        bluray.setOpacity(1.0);
        bluray.setStrokeWidth(2);
        bluray.setStroke(Color.BLACK);

        SVGPath chapel;
        chapel = new SVGPath();
        chapel.setContent(svgPathChapel);
        chapel.setFill(Color.CHOCOLATE);
        chapel.setScaleX(0.5);
        chapel.setScaleY(0.5);
        chapel.setOpacity(1.0);
        chapel.setStrokeWidth(2);
        chapel.setStroke(Color.BLACK);

        SVGPath bluraycomedia;
        bluraycomedia = new SVGPath();
        bluraycomedia.setContent(svgPathBluraycomedia);
        bluraycomedia.setFill(Color.BLUE);
        bluraycomedia.setScaleX(0.5);
        bluraycomedia.setScaleY(0.5);
        bluraycomedia.setOpacity(1.0);
        bluraycomedia.setStrokeWidth(2);
        bluraycomedia.setStroke(Color.BLACK);

        SVGPath chapelcomedia;
        chapelcomedia = new SVGPath();
        chapelcomedia.setContent(svgPathChapelcomedia);
        chapelcomedia.setFill(Color.CHOCOLATE);
        chapelcomedia.setScaleX(0.5);
        chapelcomedia.setScaleY(0.5);
        chapelcomedia.setOpacity(1.0);
        chapelcomedia.setStrokeWidth(2);
        chapelcomedia.setStroke(Color.BLACK);

        ///*
        //Um botao responsavel pelo texto na tela de aventura tem a imagem vetorial anexada a ele, assim se tornando o novo icone clicavel 
        Group graphic = new Group(bluray);
        botaoAventura1 = new Button();
        botaoAventura1.setGraphic(graphic);

        Group graphic2 = new Group(chapel);
        botaoAventura2 = new Button();
        botaoAventura2.setGraphic(graphic2);

        Group graphic3 = new Group(bluraycomedia);
        botaoComedia1 = new Button();
        botaoComedia1.setGraphic(graphic3);

        Group graphic4 = new Group(chapelcomedia);
        botaoComedia2 = new Button();
        botaoComedia2.setGraphic(graphic4);
        //*/

        //O texto que sera exibido ao clicar no botaoAventura1, assim como suas configuraçoes
        labelAventura1 = new Label("For the first time ever, own all 4 Indiana Jones movies individually on Blu-ray™ & Digital HD! \n"
                + "Also available as The Complete Adventures on Blu-ray™ & Digital HD.");
        Font font = Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 14);
        labelAventura1.setFont(font);
        labelAventura1.setTextFill(Color.BROWN);

        labelAventura2 = new Label("Henry Jones, Jr., ou simplesmente Indiana Jones, \né um personagem da série de filmes Indiana Jones, \ncriado por George Lucas e Steven Spielberg, \nGeorge lucas criou o personagem em homenagem aos heróis \nde séries e filmes de ação dos anos 1930. \nO personagem apareceu pela primeira vez em 1981 \nem Indiana Jones e Os Caçadores da Arca Perdida, \ndirigido por Steven Spielberg e vivido por Harrison Ford. \nO personagem também aparece em séries de televisão.");
        Font font2 = Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 14);
        labelAventura2.setFont(font2);
        labelAventura2.setTextFill(Color.BROWN);

        labelComedia1 = new Label("For the first time ever, own all 4 Indiana Jones movies individually on Blu-ray™ & Digital HD! \n"
                + "Also available as The Complete Adventures on Blu-ray™ & Digital HD.");
        Font font3 = Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 14);
        labelComedia1.setFont(font3);
        labelComedia1.setTextFill(Color.BROWN);

        labelComedia2 = new Label("Henry Jones, Jr., ou simplesmente Indiana Jones, \né um personagem da série de filmes Indiana Jones, \ncriado por George Lucas e Steven Spielberg, \nGeorge lucas criou o personagem em homenagem aos heróis \nde séries e filmes de ação dos anos 1930. \nO personagem apareceu pela primeira vez em 1981 \nem Indiana Jones e Os Caçadores da Arca Perdida, \ndirigido por Steven Spielberg e vivido por Harrison Ford. \nO personagem também aparece em séries de televisão.");
        Font font4 = Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 14);
        labelComedia2.setFont(font4);
        labelComedia2.setTextFill(Color.BROWN);

        //O botao de confirmação de troca de canal apos o genero ser selecionado no comboBox, o primeiro passo na execução da aplicaçao
        botao = new Button("Mudar Canal");
        webVideo = new WebView();//WebView para o YouTube

        //Painel da aplicação, cor personalizada e imagem de logo adicionada para enrriquecer a experiencia visual
        painel = new Pane();
        painel.setStyle("-fx-background-color: #" + "FF0000");
        painel.getChildren().add(imagemLOGO);
        imagemLOGO.setTranslateX(100);
        imagemLOGO.setTranslateY(100);

        //ComboBox adicionado ao painel com a primeira opção selecionada por padrão, cordenada X e Y determinadas
        painel.getChildren().add(comboUm);
        comboUm.getSelectionModel().selectFirst();
        comboUm.setTranslateX(100);
        comboUm.setTranslateY(0);

        //O botão de mudar canal é adicionado ao painel nas cordenadas 0,0
        painel.getChildren().add(botao);
        botao.setTranslateX(0);
        botao.setTranslateY(0);

        //Cena em tamanho 800x600 titulo da aplicação definido
        cena = new Scene(painel, 800, 600);
        plano.setTitle("PucFlixPlus - Trailers de filmes");
        plano.setScene(cena);
        plano.show();

        //Açoes que o botão mudar canal acionara
        indice = 0;
        botao.setOnAction((ActionEvent event) -> {

            //Ele limpa a tela de alguns elementos graficos para evitar o empilhamento destes 
            if (painel.getChildren().contains(webVideo)) {
                painel.getChildren().remove(webVideo);
            }
            if (painel.getChildren().contains(imagemLOGO)) {
                painel.getChildren().remove(imagemLOGO);
            }
            if (painel.getChildren().contains(imagemLOGO2)) {
                painel.getChildren().remove(imagemLOGO2);
            }
            if (painel.getChildren().contains(botaoAventura1)) {
                painel.getChildren().remove(botaoAventura1);
            }
            if (painel.getChildren().contains(labelAventura1)) {
                painel.getChildren().remove(labelAventura1);
            }
            if (painel.getChildren().contains(botaoAventura2)) {
                painel.getChildren().remove(botaoAventura2);
            }
            if (painel.getChildren().contains(labelAventura2)) {
                painel.getChildren().remove(labelAventura2);
            }
            if (painel.getChildren().contains(bluray)) {
                painel.getChildren().remove(bluray);
            }
            if (painel.getChildren().contains(chapel)) {
                painel.getChildren().remove(chapel);
            }
            
            if (painel.getChildren().contains(botaoComedia1)) {
                painel.getChildren().remove(botaoComedia1);
            }
            if (painel.getChildren().contains(labelComedia1)) {
                painel.getChildren().remove(labelComedia1);
            }
            if (painel.getChildren().contains(botaoComedia2)) {
                painel.getChildren().remove(botaoComedia2);
            }
            if (painel.getChildren().contains(labelComedia2)) {
                painel.getChildren().remove(labelComedia2);
            }
            if (painel.getChildren().contains(bluraycomedia)) {
                painel.getChildren().remove(bluraycomedia);
            }
            if (painel.getChildren().contains(chapelcomedia)) {
                painel.getChildren().remove(chapelcomedia);
            }

            //Conjunto de ifs que verificam o conteudo selecionado no comboBox e definem um indice para lista de trailers com base na seleçao
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

            //WebVideo usa a engine do Youtube para reprodução do video, é passado o link do video que estava na lista
            webVideo.getEngine().loadContent(lista[indice], "text/html");
            webVideo.setTranslateX(50);
            webVideo.setTranslateY(50);
            painel.getChildren().add(webVideo);

            //Adicionado o logotipo em miniatura no canto superior direito
            painel.getChildren().add(imagemLOGO2);
            imagemLOGO2.setTranslateX(700);
            imagemLOGO2.setTranslateY(0);

            //Ifs que serão acionados de acordo com o valor atual de indice,
            if (indice == 0) {

                ///*
                //Se indice igual a 0, aventura foi selecionado e o botão de aventura estara disponivel
                painel.getChildren().add(botaoAventura1);
                botaoAventura1.setTranslateX(650);
                botaoAventura1.setTranslateY(100);

                painel.getChildren().add(botaoAventura2);
                botaoAventura2.setTranslateX(650);
                botaoAventura2.setTranslateY(250);

                //Se o botao de aventura for precionado uma informação textual é exibida atravez de um label, caso o label ja esteja no painel ele é retirado
                botaoAventura1.setOnAction((ActionEvent e) -> {
                    //System.out.println("botao funciona");
                    if (painel.getChildren().contains(labelAventura2)) {
                        painel.getChildren().remove(labelAventura2);
                        chapel.setFill(Color.BURLYWOOD);
                    }
                    if (painel.getChildren().contains(labelAventura1)) {
                        painel.getChildren().remove(labelAventura1);
                        bluray.setFill(Color.CORNFLOWERBLUE);
                    } else {
                        painel.getChildren().add(labelAventura1);
                        labelAventura1.setTranslateX(60);
                        labelAventura1.setTranslateY(400);
                        bluray.setFill(Color.BLUE);
                    }
                });

                botaoAventura2.setOnAction((ActionEvent e) -> {
                    //System.out.println("botao funciona");
                    if (painel.getChildren().contains(labelAventura1)) {
                        painel.getChildren().remove(labelAventura1);
                        bluray.setFill(Color.CORNFLOWERBLUE);
                    }
                    if (painel.getChildren().contains(labelAventura2)) {
                        painel.getChildren().remove(labelAventura2);
                        chapel.setFill(Color.BURLYWOOD);
                    } else {
                        painel.getChildren().add(labelAventura2);
                        labelAventura2.setTranslateX(60);
                        labelAventura2.setTranslateY(400);
                        chapel.setFill(Color.CHOCOLATE);
                    }
                });
                //*/

                /*
                //
                //
                //
                painel.getChildren().add(cavalo);
                cavalo.setTranslateX(1750);
                cavalo.setTranslateY(-100);
                //
                //
                //

                //cavalo.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                //  @Override
                //public void handle(MouseEvent e) {
                //}
                //}
                //cavalo.setOnMouseClicked((ActionEvent e2) -> {
                //});
                //cavalo.setPickOnBounds(true); // allows click on transparent areas
                //cavalo.setOnMouseClicked((MouseEvent e) -> {
                //    System.out.println("Clicked!"); // change functionality
                //});
                // Mouse presssed handler
                //cavalo.setOnMousePressed(new EventHandler<MouseEvent>() {
                //  public void handle(MouseEvent me) {
                // Store initial position
                //}
                //});
                //imagemSVGclickavel = new ImageView(cavalo);
                //*/
            }
            if (indice == 1) {

                ///*
                //Se indice igual a 0, aventura foi selecionado e o botão de aventura estara disponivel
                painel.getChildren().add(botaoComedia1);
                botaoComedia1.setTranslateX(650);
                botaoComedia1.setTranslateY(100);

                painel.getChildren().add(botaoComedia2);
                botaoComedia2.setTranslateX(650);
                botaoComedia2.setTranslateY(250);

                //Se o botao de aventura for precionado uma informação textual é exibida atravez de um label, caso o label ja esteja no painel ele é retirado
                botaoComedia1.setOnAction((ActionEvent e) -> {
                    //System.out.println("botao funciona");
                    if (painel.getChildren().contains(labelComedia2)) {
                        painel.getChildren().remove(labelComedia2);
                        chapelcomedia.setFill(Color.BURLYWOOD);
                    }
                    if (painel.getChildren().contains(labelComedia1)) {
                        painel.getChildren().remove(labelComedia1);
                        bluraycomedia.setFill(Color.CORNFLOWERBLUE);
                    } else {
                        painel.getChildren().add(labelComedia1);
                        labelComedia1.setTranslateX(60);
                        labelComedia1.setTranslateY(400);
                        bluraycomedia.setFill(Color.BLUE);
                    }
                });

                botaoComedia2.setOnAction((ActionEvent e) -> {
                    //System.out.println("botao funciona");
                    if (painel.getChildren().contains(labelComedia1)) {
                        painel.getChildren().remove(labelComedia1);
                        bluraycomedia.setFill(Color.CORNFLOWERBLUE);
                    }
                    if (painel.getChildren().contains(labelComedia2)) {
                        painel.getChildren().remove(labelComedia2);
                        chapelcomedia.setFill(Color.BURLYWOOD);
                    } else {
                        painel.getChildren().add(labelComedia2);
                        labelComedia2.setTranslateX(60);
                        labelComedia2.setTranslateY(400);
                        chapelcomedia.setFill(Color.CHOCOLATE);
                    }
                });
                //*/

            }
            if (indice == 2) {

            }
            if (indice == 3) {

            }
            if (indice == 4) {

            }
            if (indice == 5) {

            }

        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
