/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.pooespol.poo4_proy2p_luna_orrala_sambonino;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Mr Arana
 */
public class VentanaUsuarioController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    public void encontrarLocalCercano(ActionEvent e) {
        ImageView imgV = null;
        try ( FileInputStream input = new FileInputStream(App.pathImg + "mapa2.png")) {
            Image imagen = new Image(input, 1100, 600, false, false);
            imgV = new ImageView(imagen);

        } catch (IOException ex) {
            System.out.println("No se encontro la imagen");
        }
        Pane rootLocalCercano = new Pane();
        rootLocalCercano.getChildren().addAll(imgV);
        Scene scene = new Scene(rootLocalCercano, 1100, 600);
        Stage s = new Stage();
        s.setScene(scene);
        s.show();

    }

    @FXML
    public void realizarPedido(ActionEvent e) {

    }

}
