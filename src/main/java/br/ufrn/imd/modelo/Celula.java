package br.ufrn.imd.modelo;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Celula extends Rectangle {

    private int x;
    private int y;
    private boolean foiAtingido; //precisamos desse atributo? tem um método com o mesmo nome
    private boolean navio = false;
    private Tabuleiro tabuleiro;

    public Celula(int x, int y, Tabuleiro tabuleiro){
        super(30,30);
        this.x = x;
        this.y = y;
        this.tabuleiro = tabuleiro;
        setFill(Color.LIGHTBLUE);
        setStroke(Color.BLACK);
    }

    public int getThisX() {
        return x;
    }

    public int getThisY() {
        return y;
    }

    public boolean isNavio() {
        return navio;
    }

    public void setNavio(boolean navio) {
        this.navio = navio;
    }

    public boolean foiAtingido(){
        return true;
    }
}
