package br.ufrn.imd.modelo;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Celula extends Rectangle {

    private int x;
    private int y;
    private boolean foiAtingido;
    private Navio navio;
    private Tabuleiro tabuleiro;

    public Celula(int x, int y, Tabuleiro tabuleiro){
        super(35,35);
        navio = null;
        this.x = x;
        this.y = y;
        this.tabuleiro = tabuleiro;
        setFill(Color.LIGHTBLUE);
        setStroke(Color.BLACK);
    }

    public boolean foiAtingido(){

        foiAtingido = true;
        setFill(Color.BLACK);

        if (navio != null){
            navio.atingido();
            setFill(Color.RED);
            if(navio.vivo() == false){
                tabuleiro.setQtd_navios(tabuleiro.getQtd_navios()-1);
            }
            return true;
        }
       return false;
    }
}
