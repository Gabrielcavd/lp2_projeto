package br.ufrn.imd.modelo;

import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class Tabuleiro extends Parent {
    //atributos
    private int qtd_navios;
    private VBox linhas = new VBox();
    private int colunas = 10;
    private boolean inimigo;

    public Tabuleiro(boolean inimigo, EventHandler<? super MouseEvent> handler) {
        this.inimigo = inimigo;
        this.qtd_navios = 4;
        for(int y = 0; y< 10; y++){
            HBox linha = new HBox();
            for(int x = 0; x<colunas; x++){
                Celula theCelula = new Celula(x, y, this);
                theCelula.setOnMouseClicked(handler);
                linha.getChildren().add(theCelula);
            }
            linhas.getChildren().add(linha);
        }
        getChildren().add(linhas);
    }

    public int getQtd_navios() {
        return qtd_navios;
    }

    public void setQtd_navios(int qtd_navios) {
        this.qtd_navios = qtd_navios;
    }

    public boolean posicionar_navio(Navio navio, int x, int y) {
        if(cabeNavio(navio, x, y)) {
            int tamanho = navio.getTamanho();
            if(navio.isHorizontal()) {
                for (int i = x; i < x + tamanho; i++) {
                    Celula celula = getCell(i, y);
                    celula.setNavio(navio);
                    if (!inimigo) {
                        celula.setFill(Color.GRAY);
                        celula.setStroke(Color.WHITE);
                        System.out.println(i + y);
                    }
                }
            }
            else {
                for (int i = y; i < (y + tamanho); i++) {
                    Celula celula = getCell(x, i);
                    celula.setNavio(navio);
                    if (!inimigo) {
                        System.out.println("testeV");
                        celula.setFill(Color.GRAY);
                        celula.setStroke(Color.WHITE);
                    }
                }
            }
            return true;
        }
        return false;
    }

    private boolean cabeNavio(Navio navio, int x, int y) {
        int tamanho = navio.getTamanho();
        if(navio.isHorizontal()) {
            for (int i = x; i < (x + tamanho); i++) {
                if(!pontoValido(i, y)) {
                    return false;
                }

                Celula celula = new Celula(i, y, this);
                if (celula.getNavio() != null) {
                    return false;
                }

                for (Celula vizinho :
                        getVizinhos(i, y)) {
                    if (!pontoValido(i, y)) {
                        return false;
                    }

                    if (vizinho.getNavio() != null) {
                        return false;
                    }
                }
            }
        } else {
            for (int i = y; i < (y + tamanho); i++) {
                if(!pontoValido(x, i)) {
                    return false;
                }

                Celula celula = new Celula(x, i, this);
                if (celula.getNavio() != null) {
                    return false;
                }

                for (Celula vizinho : getVizinhos(x, i)) {
                    if (!pontoValido(x, i)) {
                        return false;
                    }

                    if (vizinho.getNavio() != null) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private Celula[] getVizinhos(int x, int y) {
        Point2D[] pontos =  new Point2D[] {
                new Point2D(x - 1, y),
                new Point2D(x + 1, y),
                new Point2D(x, y - 1),
                new Point2D(x, y + 1)
        };

        List<Celula> vizinhos = new ArrayList<Celula>();

        for (Point2D p : pontos) {
            if (pontoValido(p)) {
                vizinhos.add(new Celula((int) p.getX(), (int) p.getY(), this));
            }
        }

        //Foi necessário realizar a conversão abaixo. Não entendi muito bem o motivo.
        //Conversão realizada:
        //return vizinhos;
        //Para a linha abaixo
        return vizinhos.toArray(new Celula[0]);
    }

    private boolean pontoValido(Point2D ponto) {
        return pontoValido((int) ponto.getX(), (int) ponto.getY());
    }

    private boolean pontoValido(int x, int y) {
        return (x >= 0) && (x < 10) && (y >= 0) && (y < 10);
    }

    public Celula getCell(int x, int y) {
        return (Celula) ((HBox) linhas.getChildren().get(y)).getChildren().get(x);
    }


    void atirar() {

    }
}
