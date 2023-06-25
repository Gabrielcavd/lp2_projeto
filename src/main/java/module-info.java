module br.ufrn.imd {
    requires javafx.controls;
    requires javafx.fxml;


    opens br.ufrn.imd to javafx.fxml;
    exports br.ufrn.imd;
    exports br.ufrn.imd.controle;
    opens br.ufrn.imd.controle to javafx.fxml;
}