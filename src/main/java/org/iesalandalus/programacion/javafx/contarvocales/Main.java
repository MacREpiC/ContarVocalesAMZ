package org.iesalandalus.programacion.javafx.contarvocales;

import javafx.application.Application;
import javafx.stage.Stage;
import org.iesalandalus.programacion.javafx.contarvocales.controladores.ContadorVocalesController;
import org.iesalandalus.programacion.javafx.contarvocales.utilidades.Controlador;
import org.iesalandalus.programacion.javafx.contarvocales.utilidades.Controladores;


public class Main extends Application {

	@Override
	public void start(Stage escenarioPrincipal) {
		ContadorVocalesController ventanaPrincipal = (ContadorVocalesController) Controladores.get("/vistas/VentanaPrincipal.fxml", "Contar vocales", null);
		ventanaPrincipal.inicalizar();
		ventanaPrincipal.getEscenario().show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
