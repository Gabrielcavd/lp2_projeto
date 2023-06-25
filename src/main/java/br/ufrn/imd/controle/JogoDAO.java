package br.ufrn.imd.controle;

import br.ufrn.imd.modelo.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Random;

public class JogoDAO {

    private boolean isRodando;
    private boolean isTurnoInimigo;
    private int naviosParaColocar;
    private Tabuleiro tabuleiroPlayer;
    private Tabuleiro tabuleiroInimigo;
    private Random random;

    public JogoDAO(){
        this.isRodando = false;
        this.isTurnoInimigo = false;
        this.naviosParaColocar = 4;
        this.random = new Random();
    }
    public Parent criarTabuleiros(){
        BorderPane root = new BorderPane();
        root.setPrefSize(900, 800);

        tabuleiroInimigo = new Tabuleiro(true, event -> {
            if (!isRodando)
                return;

            Celula cell = (Celula) event.getSource();
            if (cell.isFoiAtingido())
                return;

            isTurnoInimigo = !cell.atirar();

            if (tabuleiroInimigo.getQtd_navios() == 0) {
                System.out.println("YOU WIN");
                System.exit(0);
            }

            if (isTurnoInimigo)
                movimentoInimigo();
        });

        tabuleiroPlayer = new Tabuleiro(false, event -> {
            if(isRodando)
                return;
            ArrayList<Navio> naviosParaPosicionar = new ArrayList<Navio>();
            naviosParaPosicionar.add(new Corveta());
            naviosParaPosicionar.add(new Submarino());
            naviosParaPosicionar.add(new Fragata());
            naviosParaPosicionar.add(new Destroyer());

            Celula cell = (Celula) event.getSource();

            if (naviosParaColocar > 0) {
                naviosParaPosicionar.get(naviosParaColocar - 1).setHorizontal(event.getButton() == MouseButton.PRIMARY);
                boolean isOk = tabuleiroPlayer.posicionar_navio(
                        naviosParaPosicionar.get(naviosParaColocar - 1), cell.getThisX(), cell.getThisY()
                );

                if (isOk) {
                    --naviosParaColocar;
                }
            }

            if(naviosParaColocar == 0){
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
        isRodando = true;
    }

    public void movimentoInimigo(){
        while(isTurnoInimigo){
            int x = random.nextInt(10);
            int y = random.nextInt(10);
            Celula cell = tabuleiroPlayer.getCell(x, y);

            if(cell.isFoiAtingido()){
                continue;
            }

            isTurnoInimigo = cell.atirar();

            if(tabuleiroPlayer.getQtd_navios() == 0){
                System.out.println("PERDEU!");
                System.exit(0);
            }
        }
    }
}
