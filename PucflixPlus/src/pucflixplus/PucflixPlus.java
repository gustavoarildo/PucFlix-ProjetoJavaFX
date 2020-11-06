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
    Button botaoSuspence1;
    Label labelSuspence1;
    Button botaoSuspence2;
    Label labelSuspence2;
    String lista[];
    String svgPathBluray = "m213.9 1041.2c-57.433 0-104.03 46.598-104.03 104.03 0 57.433 46.598 104.06 104.03 104.06 57.433 0 104.06-46.629 104.06-104.06 0-57.433-46.629-104.03-104.06-104.03zm0 76.906c14.981 0.0001 27.156 12.144 27.156 27.125 0.00001 14.981-12.175 27.156-27.156 27.156s-27.125-12.175-27.125-27.156c-0.00001-14.981 12.144-27.125 27.125-27.125z";
    String svgPathChapel = "m128.52 0c-20.48 0.54764-31.783 2.6636-49.472 11.562-6.029 3.034-12.079 10.265-3.625 8.657 10.99-2.091 20.071-9.962 29.817-13.532 5.04-1.847 23.28-6.687 23.28-6.687zm13.781 2c-3.6329 0.0905-7.0503 0.43471-9.8125 1.0625-6.8409 1.5548-26.805 6.8585-22.188 18.25 2.0136 4.9676 5.3892 4.9354 12.094 7.0312 16.7 5.2205 39.079 0.1269 48.031-11.719 7.79-10.306-12.38-15.016-28.12-14.624zm-54.096 2.3125c-10.675 2.5285-23.439 10.292-28.312 18.625 0 0-3.25 4.3425-3.25 10.844 0 3.7467 1.7565 25.855 3.2812 44.469-18.427 6.1517-28.361 10.781-44.406 24.156-6.9906 5.827-11.247 12.238-14.406 20.625-2.0953 5.5628-1.006 11.192 1.4375 15.812 3.0336 5.7359 8.4081 10.822 14.156 12.5 3.3372 0.97413 6.0822 1.3438 13.594 1.3438 7.5636 0 29.956-3.517 50.125-10s79.227-23.408 103.72-29.531c24.492-6.1229 57.269-15.855 63.031-17.656 3.8407-1.2002 6.7197-2.0844 8.2188-2.5312 0.77209-0.23013 1.2455-0.68182 1.5938-1.25 0.20081-0.32762 0.16348-0.67504 0.0937-0.9375-0.097-0.3653-0.51231-0.53125-2.2812-0.53125-3.0399 0-9.1233 1.5167-21.5-0.4375s-25.569-5.2544-32.688-7.4688c-2.5037-0.77884-4.6204-2.0706-5.5625-2.6875-0.20675-0.87686-8.2542-35.032-13.781-61.062-6.6066 18.23-22.982 24.543-48.406 23.844-17.8-0.488-38.709-8.677-36.843-22.936 0.87083-6.6543 8.125-11 8.125-11s-11.384 6.6833-17.344 10.656c-6.041 3.9187-13.443 5.3115-20.656 4.75-3.221-0.768-1.724-3.241-0.719-4.437 5.494-6.541 12.452-11.503 22.781-15.156zm106.88 76.219c3.49 1.8717 6.541 2.8824 10.5 3.9062 4.198 1.0857 22.65 5.5065 31.625 6.375 8.9749 0.86854 15.157-0.0705 17.188-0.25 0.8507-0.0752 1.9925-0.0383 2.375 0.15625 0.12013 0.0611 0.28481 0.28952 0.15625 0.5625-0.61917 1.3148-1.8773 1.0398-3.1875 1.0625-5.0236 0.087-15.388 0.83379-25.281 2.8125-14.407 2.8814-33.138 4.6748-48.625 10.438-15.487 5.7627-29.906 13.334-44.312 17.656-14.407 4.322-31.65 10.501-57.062 18-23.554 6.9502-51.427 10.932-60.906 8.5312-5.2375-1.3268-10.192-3.6539-14.281-10.875-2.2277-3.9342-3.3332-8.5243-1.4062-14.156 3.4671-10.133 15.145-17.51 25.031-23.094 10.192-5.756 19.459-9.4528 33.719-9.8125 0.15475-0.004 0.2855 0.003 0.4375 0 0.5888 7.0612 1.0312 12.188 1.0312 12.188s1.6062 4.426 17.5 4.6875c29.443 0.48449 75.957-10.238 109.44-22.562 4.8111-1.771 5.8608-4.8208 6.0625-5.625zm2.625 4.1562c-17.725 12.835-46.784 18.227-79.469 24.531-13.464 2.597-35.974 4.2016-44.281 2.9375-8.3071-1.2641-12.781-5.0625-12.781-5.0625 2.8804 11.596 43.926 5.9796 52.875 4.3438 12.873-2.3531 22.646-4.2671 35.094-7.0625 14.966-3.361 40.834-10.313 48.562-19.688z";
    String svgPathBolaFutebol = "M4650 8775 l0 -75 -450 0 -450 0 0 -75 0 -75 -150 0 -150 0 0 -75 0 -75 -150 0 -150 0 0 -75 0 -75 -75 0 -75 0 0 -75 0 -75 -150 0 -150 0 0 -75 0 -75 -75 0 -75 0 0 -75 0 -75 -75 0 -75 0 0 -75 0 -75 -75 0 -75 0 0 -75 0 -75 -75 0 -75 0 0 -75 0 -75 -75 0 -75 0 0 -75 0 -75 -75 0 -75 0 0 -150 0 -150 -75 0 -75 0 0 -75 0 -75 -75 0 -75 0 0 -225 0 -225 -75 0 -75 0 0 -225 0 -225 -75 0 -75 0 0 -300 0 -300 -75 0 -75 0 0 -375 0 -375 75 0 75 0 0 -375 0 -375 75 0 75 0 0 -300 0 -300 75 0 75 0 0 -150 0 -150 75 0 75 0 0 -150 0 -150 75 0 75 0 0 -75 0 -75 75 0 75 0 0 -75 0 -75 75 0 75 0 0 -75 0 -75 75 0 75 0 0 -75 0 -75 75 0 75 0 0 -75 0 -75 75 0 75 0 0 -75 0 -75 75 0 75 0 0 -75 0 -75 75 0 75 0 0 -75 0 -75 150 0 150 0 0 -75 0 -75 150 0 150 0 0 -75 0 -75 150 0 150 0 0 -75 0 -75 225 0 225 0 0 -75 0 -75 975 0 975 0 0 75 0 75 150 0 150 0 0 75 0 75 225 0 225 0 0 75 0 75 150 0 150 0 0 75 0 75 75 0 75 0 0 75 0 75 150 0 150 0 0 75 0 75 75 0 75 0 0 75 0 75 75 0 75 0 0 75 0 75 75 0 75 0 0 75 0 75 75 0 75 0 0 75 0 75 75 0 75 0 0 150 0 150 75 0 75 0 0 75 0 75 75 0 75 0 0 150 0 150 75 0 75 0 0 150 0 150 75 0 75 0 0 225 0 225 75 0 75 0 0 975 0 975 -75 0 -75 0 0 225 0 225 -75 0 -75 0 0 150 0 150 -75 0 -75 0 0 150 0 150 -75 0 -75 0 0 150 0 150 -75 0 -75 0 0 75 0 75 -75 0 -75 0 0 150 0 150 -75 0 -75 0 0 75 0 75 -75 0 -75 0 0 75 0 75 -150 0 -150 0 0 75 0 75 -75 0 -75 0 0 75 0 75 -75 0 -75 0 0 75 0 75 -150 0 -150 0 0 75 0 75 -150 0 -150 0 0 75 0 75 -150 0 -150 0 0 75 0 75 -225 0 -225 0 0 75 0 75 -675 0 -675 0 0 -75z m450 -900 l0 -375 -75 0 -75 0 0 -150 0 -150 -75 0 -75 0 0 -150 0 -150 -75 0 -75 0 0 -150 0 -150 -75 0 -75 0 0 -75 0 -75 -450 0 -450 0 0 -75 0 -75 -150 0 -150 0 0 -300 0 -300 -75 0 -75 0 0 -300 0 -300 -75 0 -75 0 0 -75 0 -75 -75 0 -75 0 0 -75 0 -75 -150 0 -150 0 0 -75 0 -75 -75 0 -75 0 0 -75 0 -75 -75 0 -75 0 0 -75 0 -75 -150 0 -150 0 0 75 0 75 -75 0 -75 0 0 75 0 75 -75 0 -75 0 0 450 0 450 75 0 75 0 0 225 0 225 75 0 75 0 0 225 0 225 75 0 75 0 0 150 0 150 225 0 225 0 0 -75 0 -75 150 0 150 0 0 -75 0 -75 75 0 75 0 0 -75 0 -75 150 0 150 0 0 75 0 75 -75 0 -75 0 0 75 0 75 -75 0 -75 0 0 75 0 75 -150 0 -150 0 0 75 0 75 -75 0 -75 0 0 150 0 150 75 0 75 0 0 75 0 75 75 0 75 0 0 75 0 75 75 0 75 0 0 75 0 75 150 0 150 0 0 75 0 75 75 0 75 0 0 75 0 75 150 0 150 0 0 75 0 75 225 0 225 0 0 75 0 75 450 0 450 0 0 -375z m1650 -450 l0 -225 75 0 75 0 0 -225 0 -225 75 0 75 0 0 -225 0 -225 75 0 75 0 0 -300 0 -300 -75 0 -75 0 0 -150 0 -150 -75 0 -75 0 0 -75 0 -75 -450 0 -450 0 0 75 0 75 -375 0 -375 0 0 75 0 75 -75 0 -75 0 0 150 0 150 -75 0 -75 0 0 150 0 150 -75 0 -75 0 0 300 0 300 75 0 75 0 0 150 0 150 75 0 75 0 0 150 0 150 75 0 75 0 0 150 0 150 750 0 750 0 0 -225z m600 150 l0 -75 75 0 75 0 0 -75 0 -75 75 0 75 0 0 -75 0 -75 75 0 75 0 0 -75 0 -75 75 0 75 0 0 -150 0 -150 75 0 75 0 0 -75 0 -75 75 0 75 0 0 -150 0 -150 75 0 75 0 0 -150 0 -150 75 0 75 0 0 -150 0 -150 -75 0 -75 0 0 -75 0 -75 -150 0 -150 0 0 75 0 75 -150 0 -150 0 0 75 0 75 -150 0 -150 0 0 75 0 75 -75 0 -75 0 0 225 0 225 -75 0 -75 0 0 300 0 300 -75 0 -75 0 0 225 0 225 -75 0 -75 0 0 75 0 75 225 0 225 0 0 -75z m1200 -2325 l0 -150 75 0 75 0 0 -300 0 -300 -75 0 -75 0 0 -375 0 -375 -75 0 -75 0 0 -150 0 -150 -75 0 -75 0 0 225 0 225 -75 0 -75 0 0 225 0 225 75 0 75 0 0 375 0 375 75 0 75 0 0 150 0 150 75 0 75 0 0 -150z m-3000 -75 l0 -75 450 0 450 0 0 -75 0 -75 150 0 150 0 0 -75 0 -75 75 0 75 0 0 -225 0 -225 75 0 75 0 0 -150 0 -150 -75 0 -75 0 0 -75 0 -75 -75 0 -75 0 0 -75 0 -75 -75 0 -75 0 0 -150 0 -150 -75 0 -75 0 0 -75 0 -75 -75 0 -75 0 0 -75 0 -75 -75 0 -75 0 0 -150 0 -150 -75 0 -75 0 0 -75 0 -75 -450 0 -450 0 0 75 0 75 -150 0 -150 0 0 225 0 225 -75 0 -75 0 0 375 0 375 -75 0 -75 0 0 300 0 300 75 0 75 0 0 75 0 75 75 0 75 0 0 75 0 75 75 0 75 0 0 75 0 75 75 0 75 0 0 75 0 75 225 0 225 0 0 -75z m-2100 -450 l0 -75 225 0 225 0 0 -75 0 -75 150 0 150 0 0 -75 0 -75 75 0 75 0 0 -225 0 -225 75 0 75 0 0 -375 0 -375 75 0 75 0 0 -300 0 -300 -75 0 -75 0 0 -75 0 -75 -75 0 -75 0 0 -75 0 -75 -75 0 -75 0 0 -75 0 -75 -150 0 -150 0 0 -75 0 -75 150 0 150 0 0 -75 0 -75 75 0 75 0 0 -75 0 -75 75 0 75 0 0 -75 0 -75 75 0 75 0 0 -75 0 -75 -300 0 -300 0 0 75 0 75 -225 0 -225 0 0 75 0 75 -150 0 -150 0 0 75 0 75 -75 0 -75 0 0 75 0 75 -75 0 -75 0 0 75 0 75 -150 0 -150 0 0 75 0 75 -75 0 -75 0 0 150 0 150 150 0 150 0 0 -75 0 -75 150 0 150 0 0 -75 0 -75 225 0 225 0 0 75 0 75 -150 0 -150 0 0 75 0 75 -150 0 -150 0 0 75 0 75 -150 0 -150 0 0 75 0 75 -225 0 -225 0 0 75 0 75 -75 0 -75 0 0 375 0 375 75 0 75 0 0 225 0 225 75 0 75 0 0 75 0 75 75 0 75 0 0 75 0 75 75 0 75 0 0 75 0 75 150 0 150 0 0 75 0 75 225 0 225 0 0 -75z m4500 -825 l0 -150 75 0 75 0 0 -225 0 -225 75 0 75 0 0 -150 0 -150 -75 0 -75 0 0 -75 0 -75 -75 0 -75 0 0 -150 0 -150 -75 0 -75 0 0 -75 0 -75 -75 0 -75 0 0 -75 0 -75 -75 0 -75 0 0 -75 0 -75 -75 0 -75 0 0 -75 0 -75 -150 0 -150 0 0 -75 0 -75 -75 0 -75 0 0 -75 0 -75 -300 0 -300 0 0 75 0 75 -75 0 -75 0 0 75 0 75 -75 0 -75 0 0 300 0 300 75 0 75 0 0 75 0 75 75 0 75 0 0 150 0 150 75 0 75 0 0 75 0 75 75 0 75 0 0 75 0 75 75 0 75 0 0 150 0 150 75 0 75 0 0 75 0 75 75 0 75 0 0 75 0 75 75 0 75 0 0 75 0 75 375 0 375 0 0 -150z m-1800 -2325 l0 -75 -75 0 -75 0 0 -75 0 -75 -375 0 -375 0 0 75 0 75 225 0 225 0 0 75 0 75 225 0 225 0 0 -75z";
    String svgPathTesoura = "m46 3.2188c-16.45-0.141-33.368 7.1072-38.312 20.593-7.3485 16.274 4.457 35.266 24.593 41.126 0.064 0.016 0.159-0.018 0.219 0 21.958 7.936 49.296 11.813 73.09 36.442l8.91 9.24-8.03 8.19c-23.869 24.58-51.114 28.35-73.095 36.25-0.048 0.03-0.163-0.02-0.219 0-20.081 5.8-31.74 24.72-24.594 40.97 0.0255 0.05-0.0245 0.14 0.0005 0.19 6.1095 16.44 30.102 23.71 49.376 19.34 0.064-0.01 0.153 0.01 0.218 0 19.741-3.44 35.925-19.48 31.344-35.72-2.26-8.01-5.165-11.75-7.844-13.96-1.339-1.11-2.495-1.8-3.25-2.44-0.03-0.03-0.119-0.07-0.156-0.1-2.603 1.49-6.871 3.92-12.5 7.13 2.023 1.8 3.571 3.99 4.594 6.41 2.803 6.62 1.443 14.7-5.875 20.56-4.879 3.9-12.654 6.09-20 5.75-7.346-0.35-13.955-3.09-17.407-8.38l-0.218-0.15c-4.839-6.17-3.427-13.15 1.312-19 4.739-5.86 12.859-10.2 21.313-10.32v0.04c0.65-0.02 1.331-0.03 1.75 0 4.214 0 7.877 0.93 10.906 2.56l17.125-10.06c0.058-0.04 0.127-0.09 0.188-0.13 2.547-1.62 6.878-3.62 12.437-6 11.285-4.84 27.905-11.66 47.005-22.66 34.52 19.63 79.39 45.05 104.18 59.1 24.8 14.05 50.18 6.97 60.69 0.53l-133-78.06 133.75-78.816c-20.73-12.785-44.4-7.354-60.16 0.344-35.03 19.87-70.18 39.634-105.28 59.437-16-8.749-33.17-16.771-48.06-23.187-4.129-1.78-7.546-3.287-10.094-4.626-0.088-0.046-0.195-0.11-0.281-0.156-0.857-0.457-1.619-0.9-2.25-1.312-0.124-0.081-0.375-0.216-0.531-0.313-0.569-0.332-2.769-1.648-3.906-2.312-3.744-2.185-7.217-4.202-12.907-7.531-2.983 1.558-6.57 2.476-10.687 2.468h-0.219c-8.767 0.406-17.319-3.65-22.406-9.594s-6.547-13.325-1.531-19.687v-0.187c3.472-5.28 10.288-7.844 17.624-8.188 0.459-0.022 0.915-0.028 1.376-0.031 6.9-0.05 13.837 1.953 18.406 5.625 7.301 5.866 8.694 13.936 5.875 20.562-1.057 2.485-2.679 4.733-4.781 6.563l12.874 7.312c1.696-1.474 3.303-3.124 4.626-4.531 2.248-2.394 4.916-5.949 6.437-12.125 4.022-16.331-11.61-32.429-31.344-35.906-3.83-0.8442-7.937-0.968-11.312-1.219l0.031-0.0312z";
    String svgPathPessoas = "m266.59 3.024c8.437-1.598 17.306-3.082 25.773-1.002 6.592 2.037 5.901 10.08 7.006 15.492 1.44 6.623-0.88 13.172-3.858 19.032-2.119 4.053-1.473 9.495 2.545 12.17 8.604 8.137 21.205 7.479 32.037 10.08 3.274 1.754 4.811 5.379 6.569 8.419 4.959 10.081 10.651 19.806 15.166 30.084 3.03 7.093 3.485 14.854 4.97 22.324 0.869 4.951 1.803 9.902 2.301 14.906 0.783 7.656 3.137 15.418 1.069 23.075 0.021 7.834 0.297 15.7-0.625 23.513-0.636 0.281-1.907 0.867-2.543 1.148 0.487-2.381 0.964-4.771 1.229-7.197-1.603 2.611-2.703 5.477-4.039 8.223-0.19-2.988-0.254-5.986-0.668-8.963-0.943 3.488-1.949 7.02-4.26 9.902-0.563-3.469-0.604-6.967-0.754-10.467-1.08 2.643-1.482 5.641-3.306 7.918l-0.976-0.68c0.086-5.045 1.887-9.924 1.875-14.99-1.408 0.889-2.775 1.809-4.144 2.738-0.562-0.389-1.705-1.182-2.269-1.568 1.961-4.053 4.906-7.917 5.236-12.534 0.211-4.889-1.07-9.694-1.009-14.583 0.202-7.762-3.38-14.917-4.492-22.5-0.901-6.79-4.481-12.734-7.481-18.772-0.848-1.703-2.057-3.196-3.508-4.429-1.771 4.241-1.676 8.89-2.576 13.33-1.748 8.711-1.887 17.799 0.117 26.491 0.646 5.149 1.834 10.216 2.563 15.355-0.285 5.588-0.231 11.177 0.233 16.765 0.74 4.158-4.334 6.299-4.176 10.342-0.563 12.816-3.73 25.928-0.254 38.586 0.529 3.764 2.141 7.23 4.121 10.459 3.286 5.473 3.297 12.168 6.518 17.684 4.24 7.438 6.031 15.838 8.554 23.912-1.61 1.064-3.211 2.131-4.779 3.236 1.854 1.902 3.763 3.771 5.649 5.652-1.104 3.594-1.719 7.479-4.02 10.561-4.228 5.652-6.695 12.566-12.111 17.33-2.448 2.33-5.86 3.135-9.114 3.709-0.667-1.285-1.313-2.568-1.938-3.865 2.066-2.57 4.291-5.035 6.02-7.846 3.359-6.414 3.635-13.768 4.98-20.723-2.852-0.535-7.642 1.18-8.5-2.654-1.621-5.537-1.557-11.512-4.186-16.756-3.465-6.414-6.508-13.037-9.739-19.555-2.937-8.598-6.157-17.246-11.679-24.611-0.87 4.932-1.348 9.924-1.729 14.908-1.209 10.801-0.201 21.684-1.039 32.496-0.688 7.416 1.051 14.74 2.09 22.029 0.4 4.221 1.006 8.422 1.685 12.609-1.644 0.74-3.274 1.492-4.897 2.268 1.951 5.826 2.312 12.031 1.804 18.123-0.614 2.717-3.839 2.717-6.073 2.799-3.264 0.271-6.188-1.41-8.85-3.039-5.521-3.363-11.582-6.205-16.065-10.938-0.742-2.693 2.575-3.99 4.779-3.553 2.989 0.053 5.944 1.629 8.924 0.92 1.515-1.086 2.798-2.445 4.153-3.709-2.521-1.879-5.373-3.342-7.693-5.484 0.54-21.174-5.448-41.971-5.034-63.178-5.149 1.129-10.1 2.979-14.879 5.143-3.879 1.086-7.875 1.807-11.614 3.318-1.08 6.646-0.923 13.467-2.767 19.984-3.097 11.449-7.747 22.502-9.729 34.23-0.646 5.068-1.781 10.111-1.875 15.23 0.752 4.49 5.924 5.295 9.687 5.838-1.601 4.086-5.257 7.242-9.517 8.4-2.852 0.188-5.277-1.59-7.801-2.623-0.826 2.496-1.578 5.035-2.648 7.459-2.564-3.291-2.873-7.553-4.176-11.365 5.234-4.951 8.765-11.793 8.935-19.01 0.126-5.561 1.208-11.055 1.048-16.621 0.266-9.609-1.367-19.209-0.273-28.799 0.435-4.398 2.129-8.535 2.936-12.869-2.703 0.113-7.048-1.066-7.473 2.756-1.45 10.416-4.186 20.893-2.775 31.482 0.551 4.297 3.825 8.047 2.999 12.537-0.444 3.76-0.224 7.637-1.453 11.281-0.508-1.682-0.976-3.354-1.42-5.035-0.487 0.072-1.462 0.221-1.949 0.293-0.53 4.084-0.604 9.234-4.727 11.555-2.312 1.963-6.878 3.875-8.001-0.305 1.049-5.619 5.287-10.018 6.464-15.617 2.014-6.309 1.389-12.953 0.509-19.387-1.548-8.23-4.833-16.057-6.02-24.359-0.424-5.453-6.625-7.709-11.256-8.785-1.451-5.537-1.801-11.209-1.397-16.893-1.092 1.422-2.818 2.717-2.713 4.701-0.393 5.936 1.431 11.68 2.183 17.529 1.346 7.688 1.823 15.512 3.35 23.178 0.541 2.33-0.116 4.66-0.201 6.99 1.092 3.801 4.843 7.27 3.189 11.49-2.691 3.236-6.771 4.889-10.905 5.4-2.521 4.627-3.91 10.455-8.88 13.213-3.434 2.539-7.875 2.047-11.88 1.975 0.562-7.459 7.418-11.783 10.206-18.248 1.335-2.779 2.353-5.693 3.37-8.6-2.056-0.572-5.224 0.398-6.22-2.025-0.201-3.133 0.583-6.32-0.233-9.4-0.88-3.342-1.918-6.645-2.596-10.039-0.976-4.646-3.179-8.941-4.165-13.59-1.547-6.414-1.696-13.078-3.657-19.408-2.893 7.93-3.349 16.41-2.427 24.736 1.124 8.908 0.562 17.893 0.996 26.836 0.678 9.359 2.575 18.729 1.388 28.141-0.583 2.006-1.96 3.697-2.564 5.703-0.943 4.096-0.795 8.473-2.522 12.367-2.279 1.996-5.638 2.896-8.637 2.268-2.83-1.014-5.278-2.883-8.213-3.645-2.48-0.941-5.542-1.369-7.026-3.805-1.918-2.799-3.519-5.838-4.567-9.045-0.901-2.287 1.303-5.15 3.762-5.182 3.052 0.793 5.638 2.717 8.648 3.637 1.897-0.43 3.677-1.213 5.489-1.912-2.755-2.402-7.344-4.283-7.015-8.576 0.042-5.965-0.785-11.867-1.071-17.801-0.138-14.363-3.804-28.371-5.542-42.566-5.394 0.344-10.704 2.309-16.13 1.23 1.229 12.463 0.254 25.082 3.042 37.365 2.109 8.65 12.717 13.111 12.527 22.639-1.06 2.684-4.546 1.65-6.316 0.293-4.515-2.445-6.253-7.471-8.743-11.586-1.664-3.029-4.133-5.852-4.26-9.453-0.371-4.115-0.827-8.293-2.363-12.182-1.897-5.41-6.274-9.535-8.108-14.979-1.451-3.541-1.346-7.406-1.346-11.156-2.289 0.055-4.578 0.074-6.868 0.094 0.71 6.051 2.523 11.932 2.734 18.041 0.954 8.867-1.685 17.592-1.431 26.439-0.19 9.838 2.173 19.48 4.461 28.986 2.141 5.484-1.981 10.666-3.009 15.963-1.113-2.299-1.918-4.713-2.756-7.115-2.045 1.631-3.974 3.5-6.433 4.514-1.854-1.045-3.709-2.643-3.953-4.857 0.063-2.611 1.007-5.098 1.717-7.584 1.6 0.262 3.211 0.545 4.812 0.826 1.006-6.33 0.996-12.859-0.922-19.021-2.777-8.859-5.331-17.791-7.8-26.73-2.056-8.064-1.833-16.4-1.643-24.645-4.514 2.246-9.082 4.43-13.819 6.186-3.275 1.422-6.708-0.188-9.909-0.992-4.642-1.432-9.538-0.555-14.232 0.135-5.257 0.867-10.259-2.066-13.862-5.576-0.678-9.213 6.698-16.475 7.556-25.488-3.232 0.031-6.475 0.041-9.707-0.053-0.064-6.289 1.271-12.703 4.313-18.25 6.051-8.324 14.932-13.955 22.351-20.975 3.667-2.256 3.794-6.758 5.214-10.341 1.897-5.307 6.306-9.088 9.74-13.402 2.426-2.873 4.26-6.382 7.587-8.378 2.48-1.295 5.331-1.473 8.033-2.026-0.254-4.847-1.303-9.694-3.444-14.092-3.635-7.208-7.736-14.175-12.061-21.007-3.974 3.28-6.889 7.532-10.291 11.334-5.575 5.526-12.219 9.882-19.023 13.81-2.798 1.661-5.924 2.653-9.083 3.395-2.278-5.714-4.334-11.553-5.458-17.601-1.092-6.174 1.526-12.233 0.837-18.396-0.593-1.891-2.151-3.3-3.296-4.878 1.494-1.985 3.052-3.917 4.652-5.808-2.406-2.068-5.076-4.179-8.319-4.669-2.448-0.053-4.875 0.365-7.302 0.511 1.155-1.191 2.353-2.339 3.561-3.468 0.095-0.261 0.286-0.794 0.371-1.055-2.851-0.689-5.712-1.493-8.298-2.904 2.162-0.784 4.408-1.274 6.655-1.745-2.878-0.973-6.11-1.715-7.551-4.66 2.819 0.261 5.617 0.731 8.404 1.211-1.706-1.942-3.434-3.886-4.939-5.996 5.363 0.814 9.739 4.053 14 7.103-0.317-2.967-1.282-6.142 0.265-8.942 0.424 0.178 1.272 0.543 1.707 0.731 1.356 3.322 2.162 6.905 4.122 9.976 1.918 3.312 4.812 6.383 4.918 10.415 0.688 4.627 0.985 9.296-0.265 13.861 0.667 6.382 2.925 12.557 4.144 18.876 3.37-2.225 6.995-4.512 8.87-8.2 1.675-3.176 3.265-6.571 6.211-8.827 6.21-4.69 9.686-12.19 16.575-16.097 4.356-2.59 9.792-2.978 13.841-6.111 3.836-3.51 5.479-8.764 5.702-13.809-5.639 0.616-11.849 1.796-17.074-1.066-5.224-2.946-7.069-9.297-6.867-14.896 1.145-2.173 3.413-3.458 5.289-4.952 0.339 2.477 0.413 4.962 0.413 7.459 1.102 0.104 2.204 0.208 3.317 0.303 1.737-7.72 0.498-16.17 4.62-23.274 3.73-3.719 8.076-7.458 13.555-8.116 3.317-0.459 6.264-2.141 9.517-2.778 4.652 0.407 8.542 3.259 12.665 5.16 3.783 1.724 7.556 4.398 8.955 8.451-0.106 2.862-3.095 3.896-5.203 5.118-0.87 6.278-0.774 12.609-1.028 18.918-0.011 4.91-3.402 8.796-5.935 12.723-1.685-0.136-3.359-0.387-5.044-0.366-2.299 0.878-2.649 4.45-0.795 5.892 3.201 2.684 7.037 4.972 11.318 5.317 4.949 0.522 9.92 0.074 14.869-0.146 0.498-2.611 0.72-5.37 2.13-7.688 6.359-2.935 13.555-3.666 19.903-6.665 1.844-1.065 3.052-2.873 4.462-4.408-3.678-0.491-9.379 0.888-10.884-3.604-1.293-4.157-3.773-7.719-7.111-10.561 0.752-2.476 1.96-5.066 1.06-7.688-1.972-5.713 0.71-11.626-0.265-17.455-0.71-2.214 1.621-3.562 3.402-4.209 5.754-1.933 11.785-3.208 17.878-3.28 4.886 0.272 10.28 2.047 12.887 6.424 2.173 3.896 4.44 8.117 3.593 12.723 0.339 7.438-4.366 14.792-1.685 22.114 4.08 5.327 9.93 9.192 15.939 12.19 3.188 1.65 6.973 1.87 10.035 3.771 2.034 2.079 2.66 5.203 4.938 7.072 3.105-0.689 6.232-1.525 9.125-2.863 2.672-1.17 3.519-4.178 4.833-6.497-5.671-0.491-13.321 2.748-17.358-2.653-0.414-2.1-0.34-4.252-0.383-6.373 2.204 0.282 4.408 0.616 6.623 0.867-0.23-7.5-5.16-14.583-2.925-22.145 2.522-6.529 8.573-11.595 15.366-13.423 4.58-0.491 9.604-1.232 13.873 0.93 3.297 2.758 6.053 6.236 7.918 10.091 1.758 4.878 1.42 10.175 2.469 15.209 1.855 0.564 3.71 1.097 5.564 1.64-0.488 2.622-0.839 5.338-2.057 7.75-1.357 3.771-6.18 2.444-9.167 3.854-2.925 1.64-6.899 5.255-3.806 8.597 5.32 4.711 12.549 6.382 19.31 8.064 1.452-3.291 2.058-7.03 4.218-9.976 4.907-3.677 11.223-5.254 15.728-9.506 2.405-2.121 2.184-5.484 2.354-8.367-4.366-0.334-8.954 0.502-13.142-1.034-1.399-2.486-0.837-5.452-0.053-8.033-1.973-2.538-3.953-5.139-5.332-8.043 0.955-1.995 2.438-3.698 3.297-5.735 0.699-6.309-1.939-12.755 0.128-18.949 1.27-2.321 4.13-3.314 6.6-3.9z";
    String svgPathTenda = "m61.781 14.688l-1.719 1.374 7.219 11.063-45.469 70.875h33.813v-1-0.219-22.406h26.125v22.406 0.219 1h33.81l-45.466-70.906 6.812-10.906-1.687-1.376-6.531 10.563-6.907-10.687z";

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
        defineAtributosSVGPATH(bluray, svgPathBluray, Color.BLUE, (float) 0.5);

        SVGPath chapel;
        chapel = new SVGPath();
        defineAtributosSVGPATH(chapel, svgPathChapel, Color.CHOCOLATE, (float) 0.5);

        SVGPath bolaFutebol;
        bolaFutebol = new SVGPath();
        defineAtributosSVGPATH(bolaFutebol, svgPathBolaFutebol, Color.BLACK, (float) 0.015);

        SVGPath tesoura;
        tesoura = new SVGPath();
        defineAtributosSVGPATH(tesoura, svgPathTesoura, Color.GREEN, (float) 0.4);

        SVGPath pessoas;
        pessoas = new SVGPath();
        defineAtributosSVGPATH(pessoas, svgPathPessoas, Color.RED, (float) 0.3);

        SVGPath tenda;
        tenda = new SVGPath();
        defineAtributosSVGPATH(tenda, svgPathTenda, Color.YELLOW, (float) 1.0);

        ///*
        //Um botao responsavel pelo texto na tela de aventura tem a imagem vetorial anexada a ele, assim se tornando o novo icone clicavel 
        Group graphic = new Group(bluray);
        botaoAventura1 = new Button();
        botaoAventura1.setGraphic(graphic);

        Group graphic2 = new Group(chapel);
        botaoAventura2 = new Button();
        botaoAventura2.setGraphic(graphic2);

        Group graphic3 = new Group(bolaFutebol);
        botaoComedia1 = new Button();
        botaoComedia1.setGraphic(graphic3);

        Group graphic4 = new Group(tesoura);
        botaoComedia2 = new Button();
        botaoComedia2.setGraphic(graphic4);

        Group graphic5 = new Group(pessoas);
        botaoSuspence1 = new Button();
        botaoSuspence1.setGraphic(graphic5);

        Group graphic6 = new Group(tenda);
        botaoSuspence2 = new Button();
        botaoSuspence2.setGraphic(graphic6);
        //*/

        //O texto que sera exibido ao clicar no botaoAventura1, assim como suas configuraçoes
        labelAventura1 = new Label("For the first time ever, own all 4 Indiana Jones movies individually on Blu-ray™ & Digital HD! \n"
                + "Also available as The Complete Adventures on Blu-ray™ & Digital HD.");
        Font font = Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 14);
        defineFonteCorDaLabel(font, Color.BROWN, labelAventura1);

        labelAventura2 = new Label("Henry Jones, Jr., ou simplesmente Indiana Jones, \né um personagem da série de filmes Indiana Jones, \ncriado por George Lucas e Steven Spielberg, \nGeorge lucas criou o personagem em homenagem aos heróis \nde séries e filmes de ação dos anos 1930. \nO personagem apareceu pela primeira vez em 1981 \nem Indiana Jones e Os Caçadores da Arca Perdida, \ndirigido por Steven Spielberg e vivido por Harrison Ford. \nO personagem também aparece em séries de televisão.");
        Font font2 = Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 14);
        defineFonteCorDaLabel(font2, Color.BROWN, labelAventura2);

        labelComedia1 = new Label("O Sport Club Corinthians Paulista (mais conhecido como Corinthians, \ne pelos apelidos de \"Timão\" e \"Coringão\") \né um clube multiesportivo brasileiro da cidade de São Paulo, \ncapital do estado homônimo. \nFoi fundado como uma equipe de futebol no dia 1 de setembro de 1910 \npor um grupo de operários do bairro Bom Retiro. \nSeu nome foi inspirado no Corinthian FC de Londres, \nque excursionava pelo Brasil, \nsendo chamado pela imprensa brasileira da época de Corinthian's team.");
        Font font3 = Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 14);
        defineFonteCorDaLabel(font3, Color.BROWN, labelComedia1);

        labelComedia2 = new Label("O barbeiro Manoel, apelidado de \"Seu Mané\", morador da Vila Maria Zélia, \nna cidade de São Paulo é um torcedor fanático do Corinthians Paulista, \nque faz de tudo pelo seu time de coração, enlouquecendo sua família. \nEntra em conflito com seu vizinho italiano e palmeirense, \nLeontino. Em uma cena, há uma guerra de hinos dos dois clubes. \nMané faz promessas malucas e orações a São Jorge, \npassa sofrimentos e profere insultos na arquibancada. \nEm seu salão, \ncorta o cabelo e faz a barba de graça de quem for corintiano \ne apresentar carteirinha do clube.");
        Font font4 = Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 14);
        defineFonteCorDaLabel(font4, Color.BROWN, labelComedia2);

        labelSuspence1 = new Label("O longa participou do Festival Internacional de Cinema Independente de Buenos Aires 2017, \nonde foi indicado ao prêmio de Melhor Filme na categoria internacional.");
        Font font5 = Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 14);
        defineFonteCorDaLabel(font5, Color.BROWN, labelSuspence1);

        labelSuspence2 = new Label("Ian e Samantha viajam para relaxar alguns dias num parque natural. \nO casal encontra um acampamento isolado com apenas um carro e uma barraca vazia. \nÀ medida que anoitece e ninguém retorna, \nos dois passam a se preocupar. \nE quando descobrem uma criança vagando pela floresta, \neles mergulham numa terrível cadeia de acontecimentos, \nque vai levá-los até o seu limite.");
        Font font6 = Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 14);
        defineFonteCorDaLabel(font6, Color.BROWN, labelSuspence2);

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

            removeBotoesLabelsSeExistem(botaoAventura1, botaoAventura2, labelAventura1, labelAventura2);

            removeBotoesLabelsSeExistem(botaoComedia1, botaoComedia2, labelComedia1, labelComedia2);

            removeBotoesLabelsSeExistem(botaoSuspence1, botaoSuspence2, labelSuspence1, labelSuspence2);

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

                adiciona2BotoesInterativosNoPainel(botaoAventura1, botaoAventura2, labelAventura1, labelAventura2, Color.BLUE, Color.CORNFLOWERBLUE, Color.CHOCOLATE, Color.BURLYWOOD, bluray, chapel);

                /*
                
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

                adiciona2BotoesInterativosNoPainel(botaoComedia1, botaoComedia2, labelComedia1, labelComedia2, Color.BLACK, Color.DARKGRAY, Color.GREEN, Color.LAWNGREEN, bolaFutebol, tesoura);

            }
            if (indice == 2) {

                adiciona2BotoesInterativosNoPainel(botaoSuspence1, botaoSuspence2, labelSuspence1, labelSuspence2, Color.RED, Color.PALEVIOLETRED, Color.YELLOW, Color.LIGHTYELLOW, pessoas, tenda);

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

    public void defineAtributosSVGPATH(SVGPath svgpath, String stringConteudoSVG, Color cor, float escalaXY) {
        svgpath.setContent(stringConteudoSVG);
        svgpath.setFill(cor);
        svgpath.setScaleX(escalaXY);
        svgpath.setScaleY(escalaXY);
        svgpath.setOpacity(1.0);
        svgpath.setStrokeWidth(2);
        svgpath.setStroke(Color.BLACK);
    }

    public void defineFonteCorDaLabel(Font fonte, Color cor, Label label) {
        label.setFont(fonte);
        label.setTextFill(cor);
    }

    public void removeBotoesLabelsSeExistem(Button botao1, Button botao2, Label label1, Label label2) {
        if (painel.getChildren().contains(botao1)) {
            painel.getChildren().remove(botao1);
        }
        if (painel.getChildren().contains(label1)) {
            painel.getChildren().remove(label1);
        }
        if (painel.getChildren().contains(botao2)) {
            painel.getChildren().remove(botao2);
        }
        if (painel.getChildren().contains(label2)) {
            painel.getChildren().remove(label2);
        }
    }

    public void adiciona2BotoesInterativosNoPainel(Button botao1, Button botao2, Label label1, Label label2, Color botao1cor1, Color botao1cor2, Color botao2cor1, Color botao2cor2, SVGPath iconeBotao1SVG, SVGPath iconeBotao2SVG) {
        ///*
        //Se indice igual a 0, aventura foi selecionado e o botão de aventura estara disponivel
        painel.getChildren().add(botao1);
        botao1.setTranslateX(650);
        botao1.setTranslateY(100);

        painel.getChildren().add(botao2);
        botao2.setTranslateX(650);
        botao2.setTranslateY(250);

        //Se o botao de aventura for precionado uma informação textual é exibida atravez de um label, caso o label ja esteja no painel ele é retirado
        botao1.setOnAction((ActionEvent e) -> {
            //System.out.println("botao funciona");
            if (painel.getChildren().contains(label2)) {
                painel.getChildren().remove(label2);
                iconeBotao2SVG.setFill(botao2cor2);
            }
            if (painel.getChildren().contains(label1)) {
                painel.getChildren().remove(label1);
                iconeBotao1SVG.setFill(botao1cor2);
            } else {
                painel.getChildren().add(label1);
                label1.setTranslateX(60);
                label1.setTranslateY(400);
                iconeBotao1SVG.setFill(botao1cor1);
            }
        });

        botao2.setOnAction((ActionEvent e) -> {
            //System.out.println("botao funciona");
            if (painel.getChildren().contains(label1)) {
                painel.getChildren().remove(label1);
                iconeBotao1SVG.setFill(botao1cor2);
            }
            if (painel.getChildren().contains(label2)) {
                painel.getChildren().remove(label2);
                iconeBotao2SVG.setFill(botao2cor2);
            } else {
                painel.getChildren().add(label2);
                label2.setTranslateX(60);
                label2.setTranslateY(400);
                iconeBotao2SVG.setFill(botao2cor1);
            }
        });
        //*/
    }
}
