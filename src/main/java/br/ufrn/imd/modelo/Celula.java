package br.ufrn.imd.modelo;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Celula extends Rectangle {

    private int x;
    private int y;
    private boolean foiAtingido; //precisamos desse atributo? tem um método com o mesmo nome
    private Navio navio = null;
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

    public void setNavio(Navio navio) {
        this.navio = navio;
    }

    public Navio getNavio() {
        return navio;
    }

    public boolean foiAtingido(){
        return true;
    }

    public boolean atirar() {
        foiAtingido = true;
        setFill(Color.BLACK);

        if (navio != null) {
            navio.atingido();
            setFill(Color.RED);
            if (!navio.vivo()) {
                tabuleiro.setQtd_navios(tabuleiro.getQtd_navios()-1);
            }
            return true;
        }

        return false;
    }
}
