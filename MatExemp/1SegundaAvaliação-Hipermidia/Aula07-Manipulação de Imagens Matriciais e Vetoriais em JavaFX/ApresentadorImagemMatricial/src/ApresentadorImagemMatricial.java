
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.SepiaTone;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ApresentadorImagemMatricial extends Application {

    Image imagem;
    ImageView imagemOriginal,
              imagemLarguraAlterada,
              imagemAlturaAlterada,
              imagemRedimensionada,
              imagemRecorte;
    HBox painelHorizontal1, painelHorizontal2;
    VBox painelVertical;
    SepiaTone efeito = new SepiaTone();

    private void init(Stage primeiroPlano) {
        // Preparando a cena grafica
        Group grupoObjetos = new Group();
        primeiroPlano.setScene(new Scene(grupoObjetos, Color.BROWN));

        imagem = new Image("file:///c:/temp/midias/imagem.jpg");

        imagemOriginal = new ImageView(imagem);

        imagemLarguraAlterada = new ImageView(imagem);
        imagemLarguraAlterada.setFitWidth(200);
        imagemLarguraAlterada.setPreserveRatio(true);

        imagemAlturaAlterada = new ImageView(imagem);
        imagemAlturaAlterada.setFitHeight(200);
        imagemAlturaAlterada.setPreserveRatio(true);

        imagemRedimensionada = new ImageView(imagem);
        imagemRedimensionada.setFitWidth(40);
        imagemRedimensionada.setFitHeight(80);
        imagemRedimensionada.setPreserveRatio(false);
        imagemRedimensionada.setSmooth(true);

        imagemRecorte = new ImageView(imagem);
        Rectangle2D recorte = new Rectangle2D(0, 0, 150, 100);
        imagemRecorte.setViewport(recorte);

        painelHorizontal1 = new HBox();
        painelHorizontal2 = new HBox();

        painelHorizontal1.setSpacing(30);
        painelHorizontal1.getChildren().addAll(imagemOriginal,
                imagemLarguraAlterada);
        painelHorizontal2.setSpacing(30);
        painelHorizontal2.getChildren().addAll(imagemAlturaAlterada,
                imagemRedimensionada,
                imagemRecorte);

        painelVertical = new VBox(10);
        painelVertical.getChildren().addAll(painelHorizontal1,
                painelHorizontal2);
        grupoObjetos.getChildren().addAll(painelVertical);
    }

    // Iniciando a aplicacao atraves do metodo init
    @Override
    public void start(Stage primeiroPlano) throws Exception {
        init(primeiroPlano);
        primeiroPlano.show();
    }

    // Disparando uma thread para executar a aplicacao
    public static void main(String[] argumentos) {
        launch(argumentos);
    }
}
