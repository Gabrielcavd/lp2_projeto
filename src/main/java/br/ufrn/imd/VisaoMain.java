package br.ufrn.imd;

import br.ufrn.imd.controle.JogoDAO;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class VisaoMain extends Application {

    JogoDAO controlador = new JogoDAO();
    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(controlador.criarTabuleiros());
        stage.setTitle("Batalha Naval");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    public static void main(String[] args) {

        launch(args);

    }
}

