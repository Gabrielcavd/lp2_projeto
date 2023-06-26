package br.ufrn.imd.modelo;

/**
 * Representa uma corveta, que é um tipo de navio do jogo de batalha naval.
 * A corveta possui tamanho 2x2.
 */
public class Corveta extends Navio {

    /**
     * Construtor da classe Corveta.
     * Inicializa a corveta com tamanho 2x2.
     */
    public Corveta() {
        super(2, 2);
    }
}