package br.ufrn.imd.modelo;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Representa uma célula em um tabuleiro do jogo de batalha naval.
 * Uma célula pode conter um navio e pode ser atingida durante o jogo.
 */
public class Celula extends Rectangle {

    private int x;
    private int y;
    private boolean foiAtingido;
    private Navio navio;
    private Tabuleiro tabuleiro;

    /**
     * Cria uma nova célula com as coordenadas especificadas e associada a um tabuleiro.
     *
     * @param x a coordenada X da célula.
     * @param y a coordenada Y da célula.
     * @param tabuleiro o tabuleiro ao qual a célula pertence.
     */
    public Celula(int x, int y, Tabuleiro tabuleiro){
        super(38,38);
        this.foiAtingido = false;
        this.navio = null;
        this.x = x;
        this.y = y;
        this.tabuleiro = tabuleiro;
        setFill(Color.LIGHTBLUE);
        setStroke(Color.BLACK);
    }

    /**
     * Obtém a coordenada X da célula.
     *
     * @return a coordenada X da célula.
     */
    public int getThisX() {
        return x;
    }

    /**
     * Obtém a coordenada Y da célula.
     *
     * @return a coordenada Y da célula.
     */
    public int getThisY() {
        return y;
    }

    /**
     * Define o navio associado a esta célula.
     *
     * @param navio o navio a ser associado à célula.
     */
    public void setNavio(Navio navio) {
        this.navio = navio;
    }

    /**
     * Obtém o navio associado a esta célula.
     *
     * @return o navio associado à célula, ou null se não houver navio.
     */
    public Navio getNavio() {
        return navio;
    }

    /**
     * Verifica se a célula foi atingida.
     *
     * @return true se a célula foi atingida, false caso contrário.
     */
    public boolean isFoiAtingido() {
        return foiAtingido;
    }

    /**
     * Define se a célula foi atingida.
     *
     * @param foiAtingido true se a célula foi atingida, false caso contrário.
     */
    public void setFoiAtingido(boolean foiAtingido) {
        this.foiAtingido = foiAtingido;
    }

    /**
     * Efetua um tiro nesta célula.
     * Marca a célula como atingida e altera sua cor de preenchimento para preto.
     * Se houver um navio nesta célula, o navio é marcado como atingido,
     * a cor da célula é alterada para vermelho e, se o navio for destruído,
     * a quantidade de navios no tabuleiro é decrementada.
     *
     * @return true se um navio foi atingido, false caso contrário.
     */
    public boolean atirar() {
        foiAtingido = true;
        setFill(Color.BLACK);

        if (navio != null) {
            navio.atingido();
            setFill(Color.RED);
            if (!navio.vivo()) {
                tabuleiro.setQtd_navios(tabuleiro.getQtd_navios() - 1);
            }
            return true;
        }

        return false;
    }
}