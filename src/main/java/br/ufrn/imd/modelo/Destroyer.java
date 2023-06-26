package br.ufrn.imd.modelo;

/**
 * Representa um destroyer, que é um tipo de navio do jogo de batalha naval.
 * O destroyer possui tamanho 5x5.
 */
public class Destroyer extends Navio {

    /**
     * Construtor da classe Destroyer.
     * Inicializa o destroyer com tamanho 5x5.
     */
    public Destroyer() {
        super(5, 5);
    }
}
