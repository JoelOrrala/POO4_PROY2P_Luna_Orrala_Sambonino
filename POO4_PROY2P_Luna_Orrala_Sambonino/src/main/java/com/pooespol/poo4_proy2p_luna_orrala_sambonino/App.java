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
    
    public static String pathFiles = "src/main/resources/files/";
    public static String pathImg = "src/main/resources/images/";
    public static String pathPed = "src/main/resources/pedidos/";
    
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmLoader = new FXMLLoader(App.class.getResource("VentanaIngreso.fxml"));
        
        Parent root = fxmLoader.load();
        scene = new Scene(root, 640, 600);
        stage.setScene(scene);
        stage.setTitle("The Good Burger Restaurant");
        stage.show();
        
    }
    
    public static void main(String[] args) {
        launch();
    }
    
}
