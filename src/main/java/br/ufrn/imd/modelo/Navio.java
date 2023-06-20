package br.ufrn.imd.modelo;

public abstract class Navio {
    private int tamanho;
    private int vida;
    private boolean horizontal = true;

    public Navio(int tamanho, int vida, boolean horizontal) {
        this.tamanho = tamanho;
        this.vida = vida;
        this.horizontal = horizontal;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public boolean isHorizontal() {
        return horizontal;
    }

    public void setHorizontal(boolean horizontal) {
        this.horizontal = horizontal;
    }

    public void atingido(){}

    public boolean vivo() {
        return vida > 0;
    }
}
