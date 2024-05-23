package org.iesalandalus.programacion.javafx.contarvocales.controladores;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.iesalandalus.programacion.javafx.contarvocales.utilidades.Controlador;
import org.iesalandalus.programacion.javafx.contarvocales.utilidades.Controladores;
import org.iesalandalus.programacion.javafx.contarvocales.utilidades.Dialogos;

public class ContadorVocalesController extends Controlador {
    @FXML
    private Button btLimpiar;

    @FXML
    private MenuItem menuItemAcercaDe;

    @FXML
    private MenuItem menuItemSalir;

    @FXML
    private TextArea textArea;

    @FXML
    private TextField tfAes;

    @FXML
    private TextField tfEs;

    @FXML
    private TextField tfIes;

    @FXML
    private TextField tfOes;

    @FXML
    private TextField tfUes;


    @FXML
    void handleAcercaDe() {
        AcercaDe acercaDe = (AcercaDe) Controladores.get("/vistas/AcercaDe.fxml", "Acerca de", getEscenario());
        acercaDe.getEscenario().showAndWait();
    }

    @FXML
    private void actualizarContador() {
        String texto = textArea.getText().toLowerCase();
        long cuentaA = texto.chars().filter(ch -> ch == 'a').count();
        long cuentaE = texto.chars().filter(ch -> ch == 'e').count();
        long cuentaI = texto.chars().filter(ch -> ch == 'i').count();
        long cuentaO = texto.chars().filter(ch -> ch == 'o').count();
        long cuentaU = texto.chars().filter(ch -> ch == 'u').count();

        tfAes.setText(String.valueOf(cuentaA));
        tfEs.setText(String.valueOf(cuentaE));
        tfIes.setText(String.valueOf(cuentaI));
        tfOes.setText(String.valueOf(cuentaO));
        tfUes.setText(String.valueOf(cuentaU));

        btLimpiar.setDisable(texto.isEmpty());
    }

    @FXML
    void limpiarTexto() {
        textArea.clear();
        tfAes.setText("0");
        tfIes.setText("0");
        tfOes.setText("0");
        tfUes.setText("0");
        tfEs.setText("0");
        btLimpiar.setDisable(true);
    }

    @FXML
    void salir() {
        if(Dialogos.mostrarDialogoConfirmacion("Salir", "¿Estás seguro que quieres salir de la aplicación?", getEscenario())){
            getEscenario().close();
        }
    }

    public void inicalizar() {
        getEscenario().setOnCloseRequest(event -> {
            event.consume();
            salir();
        });
    }
    @FXML
    void initialize() {
        textArea.textProperty().addListener((observable, oldValue, newValue) -> actualizarContador());

    }
}
