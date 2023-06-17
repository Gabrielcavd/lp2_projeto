package br.ufrn.imd;

import br.ufrn.imd.modelo.Tabuleiro;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

public class BatalhaNavalMain extends Application {

    public Parent criarTabuleiros(){
        BorderPane root = new BorderPane();
        root.setPrefSize(800, 800);
        Tabuleiro tabuleiroPlayer = new Tabuleiro();
        Tabuleiro tabuleroInimigo = new Tabuleiro();
        HBox hbox = new HBox(50, tabuleiroPlayer, tabuleroInimigo);
        hbox.setAlignment(Pos.CENTER);
        root.setCenter(hbox);
        return root;
    }

    @Override
    public void start(Stage stage) throws Exception{
        Scene scene = new Scene(criarTabuleiros());
        stage.setTitle("Batalha Naval");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    public static void main(String[] args) {

        launch(args);

    }
}
