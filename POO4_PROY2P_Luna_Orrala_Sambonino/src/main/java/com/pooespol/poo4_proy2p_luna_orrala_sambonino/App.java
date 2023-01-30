package com.pooespol.poo4_proy2p_luna_orrala_sambonino;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    /**
     * ruta archivos
     */
    public static String pathFiles = "src/main/resources/files/";
    /**
     * ruta imagenes
     */
    public static String pathImg = "src/main/resources/images/";
    /**
     * ruta pedidos
     */
    public static String pathPed = "src/main/resources/pedidos/";
    /**
     * ruta estilos
     */
    public static String pathStyles = "src/main/resources/styles/";

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmLoader = new FXMLLoader(App.class.getResource("VentanaIngreso.fxml"));
        Parent root = fxmLoader.load();
        scene = new Scene(root, 690, 470);
        scene.getStylesheets().add(App.class.getResource("ingreso.css").toExternalForm());
        stage.setScene(scene);
        stage.setTitle("The Good Burger Restaurant");
        stage.show();
        stage.setResizable(false);

    }

    /**
     *
     * @param args main
     */
    public static void main(String[] args) {
        launch();
    }

}
