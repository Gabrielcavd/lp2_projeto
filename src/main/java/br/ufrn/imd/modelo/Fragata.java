package br.ufrn.imd.modelo;

/**
 * Representa uma fragata, que é um tipo de navio do jogo de batalha naval.
 * A fragata possui tamanho 4x4.
 */
public class Fragata extends Navio {

    /**
     * Construtor da classe Fragata.
     * Inicializa a fragata com tamanho 4x4.
     */
    public Fragata() {
        super(4, 4);
    }
}
