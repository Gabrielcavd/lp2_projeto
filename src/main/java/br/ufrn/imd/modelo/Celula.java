package br.ufrn.imd.modelo;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Celula extends Rectangle {

    private int x;
    private int y;
    private boolean foiAtingido;
    private boolean temNavio;
    private Tabuleiro tabuleiro;

    public Celula(int x, int y, Tabuleiro tabuleiro){
        super(30,30);
        this.x = x;
        this.y = y;
        this.tabuleiro = tabuleiro;
        setFill(Color.LIGHTBLUE);
        setStroke(Color.BLACK);
    }

    public boolean foiAtingido(){
        return true;
    }
}
