package br.ufrn.imd;

import br.ufrn.imd.controle.JogoDAO;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Classe principal da aplicação que inicializa a interface gráfica do jogo de Batalha Naval.
 */
public class VisaoMain extends Application {

    JogoDAO controlador = new JogoDAO();

    /**
     * Método principal que inicia a aplicação.
     *
     * @param stage O palco da aplicação.
     * @throws Exception Exceção lançada em caso de erro na inicialização.
     */
    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(controlador.criarTabuleiros());
        stage.setTitle("Batalha Naval");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    /**
     * Método main que inicia a aplicação.
     *
     * @param args Argumentos de linha de comando.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
