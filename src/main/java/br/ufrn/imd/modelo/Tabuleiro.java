package br.ufrn.imd.modelo;

import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa um tabuleiro do jogo de batalha naval.
 * O tabuleiro contém células organizadas em linhas e colunas.
 */
public class Tabuleiro extends Parent {
    private int qtd_navios;
    private VBox linhas;
    private boolean inimigo;

    /**
     * Constrói um tabuleiro com a quantidade de navios e o evento de clique especificados.
     *
     * @param inimigo indica se o tabuleiro é do inimigo (true) ou do jogador (false).
     * @param handler o evento de clique a ser associado às células do tabuleiro.
     */
    public Tabuleiro(boolean inimigo, EventHandler<? super MouseEvent> handler) {
        this.inimigo = inimigo;
        this.linhas = new VBox();
        this.qtd_navios = 4;
        Label tituloTabuleiro = new Label();
        if(inimigo){
            tituloTabuleiro.setText("Tabuleiro Inimigo");
        } else {
            tituloTabuleiro.setText("Tabuleiro Player");
        }

        for(int y = 0; y < 10; y++){
            HBox linha = new HBox();
            for(int x = 0; x < 10; x++){
                Celula theCelula = new Celula(x, y, this);
                theCelula.setOnMouseClicked(handler);
                linha.getChildren().add(theCelula);
            }
            linhas.getChildren().add(linha);
        }
        HBox LinhaTexto = new HBox(tituloTabuleiro);
        linhas.getChildren().add(LinhaTexto);
        getChildren().add(linhas);
    }

    /**
     * Obtém a quantidade de navios restantes no tabuleiro.
     *
     * @return a quantidade de navios restantes.
     */
    public int getQtd_navios() {
        return qtd_navios;
    }

    /**
     * Define a quantidade de navios restantes no tabuleiro.
     *
     * @param qtd_navios a quantidade de navios restantes.
     */
    public void setQtd_navios(int qtd_navios) {
        this.qtd_navios = qtd_navios;
    }

    /**
     * Posiciona um navio no tabuleiro na posição especificada.
     *
     * @param navio o navio a ser posicionado.
     * @param x a coordenada x da posição.
     * @param y a coordenada y da posição.
     * @return true se o navio foi posicionado com sucesso, false caso contrário.
     */
    public boolean posicionar_navio(Navio navio, int x, int y) {
        if (cabeNavio(navio, x, y)) {
            int tamanho = navio.getTamanho();
            if (navio.isHorizontal()) {
                for (int i = x; i < x + tamanho; i++) {
                    Celula celula = getCell(i, y);
                    celula.setNavio(navio);
                    if (!inimigo) {
                        celula.setFill(Color.GRAY);
                        celula.setStroke(Color.WHITE);
                    }
                }
            } else {
                for (int i = y; i < y + tamanho; i++) {
                    Celula celula = getCell(x, i);
                    celula.setNavio(navio);
                    if (!inimigo) {
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

                Celula celula = getCell(i, y);
                if (celula.getNavio() != null) {
                    return false;
                }

                for (Celula vizinho : getVizinhos(i, y)) {
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

                Celula celula = getCell(x, i);
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
        return vizinhos.toArray(new Celula[0]);
    }

    private boolean pontoValido(Point2D ponto) {
        return pontoValido((int) ponto.getX(), (int) ponto.getY());
    }

    private boolean pontoValido(int x, int y) {
        return (x >= 0) && (x < 10) && (y >= 0) && (y < 10);
    }

    /**
     * Obtém a célula do tabuleiro nas coordenadas especificadas.
     *
     * @param x a coordenada x da célula.
     * @param y a coordenada y da célula.
     * @return a célula do tabuleiro nas coordenadas especificadas.
     */
    public Celula getCell(int x, int y) {
        return (Celula) ((HBox) linhas.getChildren().get(y)).getChildren().get(x);
    }
}
