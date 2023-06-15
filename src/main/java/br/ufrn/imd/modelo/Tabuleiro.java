package br.ufrn.imd.modelo;

import javafx.scene.Parent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Tabuleiro extends Parent {
    //atributos
    private int qtd_navios;
    private VBox linhas = new VBox();
    private int colunas = 10;

    public Tabuleiro() {
        this.qtd_navios = 5;
        for(int y = 0; y< 10; y++){
            HBox linha = new HBox();
            for(int x = 0; x<colunas; x++){
                Celula theCelula = new Celula(x, y, this);
                linha.getChildren().add(theCelula);
            }
            linhas.getChildren().add(linha);
        }
        getChildren().add(linhas);
    }

    public int getQtd_navios() {
        return qtd_navios;
    }

    public void setQtd_navios(int qtd_navios) {
        this.qtd_navios = qtd_navios;
    }

    void posicionar_navio() {

    }
    void atirar() {

    }
}
