package br.ufrn.imd.modelo;

public abstract class Navio {
    private int tamanho;
    private int vida;

    public Navio(int tamanho, int vida) {
        this.tamanho = tamanho;
        this.vida = vida;
    }

    public void atingido(){
        vida--;
    }

    public boolean vivo() {
        return vida > 0;
    }
}
