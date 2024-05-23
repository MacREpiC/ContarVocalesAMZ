package org.iesalandalus.programacion.javafx.contarvocales.utilidades;

import javafx.application.Application;
import javafx.stage.Stage;

public class LanzadorVentanaPrincipal extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Controlador ventanaPrincipal = Controladores.get("/vistas/VentanaPrincipal.fxml", "Contador Vocales", null);
        //ventanaPrincipal.addHojaEstilos("/estilos/aplicacion.css");
        //ventanaPrincipal.addIcono("/imagenes/iconoSaludar.png");
        //VistaGrafica.getInstancia().setVentanaPrincipal(ventanaPrincipal);
        ventanaPrincipal.getEscenario().show();
    }

    public static void comenzar(){launch(LanzadorVentanaPrincipal.class);}
}