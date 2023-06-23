package br.ufrn.imd;

import br.ufrn.imd.modelo.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class BatalhaNavalMain extends Application {

    private boolean running = false;
    private boolean enemyTurn = false;
    private int shipsToPlace = 4;
    private Tabuleiro tabuleiroPlayer;
    private Tabuleiro tabuleiroInimigo;
    private Random random = new Random();
    public Parent criarTabuleiros(){
        BorderPane root = new BorderPane();
        root.setPrefSize(800, 800);

        tabuleiroInimigo = new Tabuleiro(true, event -> {
            if (!running)
                return;

            Celula cell = (Celula) event.getSource();
            if (cell.foiAtingido())
                return;

            enemyTurn = !cell.atirar();

            if (tabuleiroInimigo.getQtd_navios() == 0) {
                System.out.println("YOU WIN");
                System.exit(0);
            }

            if (enemyTurn)
                movimentoInimigo();
        });

        tabuleiroPlayer = new Tabuleiro(false, event -> {
            ArrayList<Navio> naviosParaPosicionar = new ArrayList<Navio>();
            naviosParaPosicionar.add(new Corveta());
            naviosParaPosicionar.add(new Submarino());
            naviosParaPosicionar.add(new Fragata());
            naviosParaPosicionar.add(new Destroyer());

            Celula cell = (Celula) event.getSource();

            if (shipsToPlace > 0) {
                naviosParaPosicionar.get(shipsToPlace - 1).setHorizontal(event.getButton() == MouseButton.PRIMARY);
                boolean isOk = tabuleiroPlayer.posicionar_navio(
                        naviosParaPosicionar.get(shipsToPlace - 1), cell.getThisX(), cell.getThisY()
                );

                if (isOk) {
                    --shipsToPlace;
                }
            }

            if(shipsToPlace == 0){
                comecarJogo();
            }
        });


        HBox hbox = new HBox(50, tabuleiroPlayer, tabuleiroInimigo);
        hbox.setAlignment(Pos.CENTER);
        root.setCenter(hbox);
        return root;
    }

    public void comecarJogo(){
        int qntdNaviosParaPosicionar = 4;
        ArrayList<Navio> naviosParaPosicionar = new ArrayList<Navio>();
        naviosParaPosicionar.add(new Corveta());
        naviosParaPosicionar.add(new Submarino());
        naviosParaPosicionar.add(new Fragata());
        naviosParaPosicionar.add(new Destroyer());


        while (qntdNaviosParaPosicionar > 0){

            int x = random.nextInt(10);
            int y = random.nextInt(10);

            naviosParaPosicionar.get(qntdNaviosParaPosicionar - 1).setHorizontal(Math.random() < 0.5);
            boolean isOk = tabuleiroInimigo.posicionar_navio(
                    naviosParaPosicionar.get(qntdNaviosParaPosicionar - 1), x, y
            );
            if (isOk) {
                --qntdNaviosParaPosicionar;
            }
        }
    }

    public void movimentoInimigo(){
        while(enemyTurn){
            int x = random.nextInt(10);
            int y = random.nextInt(10);
            Celula cell = tabuleiroPlayer.getCell(x, y);

            if(cell.foiAtingido()){
                continue;
            }

            enemyTurn = cell.atirar();

            if(tabuleiroPlayer.getQtd_navios() == 0){
                System.out.println("PERDEU!");
                System.exit(0);
            }
        }
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
