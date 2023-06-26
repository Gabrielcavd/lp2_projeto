package br.ufrn.imd.modelo;

/**
 * Classe abstrata que representa um navio no jogo de batalha naval.
 * Um navio possui um tamanho, uma quantidade de vida e uma orientação horizontal ou vertical.
 */
public abstract class Navio {
    private int tamanho;
    private int vida;
    private boolean horizontal;

    /**
     * Construtor que cria um navio com o tamanho e a quantidade de vida especificados.
     * Por padrão, o navio é criado na orientação horizontal.
     *
     * @param tamanho o tamanho do navio.
     * @param vida a quantidade de vida do navio.
     */
    public Navio(int tamanho, int vida) {
        this.tamanho = tamanho;
        this.vida = vida;
        this.horizontal = true;
    }

    /**
     * Obtém o tamanho do navio.
     *
     * @return o tamanho do navio.
     */
    public int getTamanho() {
        return tamanho;
    }

    /**
     * Define o tamanho do navio.
     *
     * @param tamanho o tamanho do navio.
     */
    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    /**
     * Obtém a quantidade de vida do navio.
     *
     * @return a quantidade de vida do navio.
     */
    public int getVida() {
        return vida;
    }

    /**
     * Define a quantidade de vida do navio.
     *
     * @param vida a quantidade de vida do navio.
     */
    public void setVida(int vida) {
        this.vida = vida;
    }

    /**
     * Verifica se o navio está na orientação horizontal.
     *
     * @return true se o navio está na orientação horizontal, false se estiver na orientação vertical.
     */
    public boolean isHorizontal() {
        return horizontal;
    }

    /**
     * Define a orientação do navio.
     *
     * @param horizontal true para orientação horizontal, false para orientação vertical.
     */
    public void setHorizontal(boolean horizontal) {
        this.horizontal = horizontal;
    }

    /**
     * Reduz a quantidade de vida do navio quando é atingido.
     */
    public void atingido(){
        vida--;
    }

    /**
     * Verifica se o navio ainda está vivo.
     *
     * @return true se o navio ainda está vivo, false caso contrário.
     */
    public boolean vivo() {
        return vida > 0;
    }
}
