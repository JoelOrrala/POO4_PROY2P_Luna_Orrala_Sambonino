/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.pooespol.poo4_proy2p_luna_orrala_sambonino;

import com.pooespol.poo4_proy2p_modelo.Cliente;
import com.pooespol.poo4_proy2p_modelo.Local;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class VentanaUsuarioController siendo la ventana para escoger
 * opciones entre encontrar el sucursal mas cercano o hacer un nuevo pedido
 *
 * @author L.Luna
 */
public class VentanaUsuarioController implements Initializable {

    @FXML 
    private Label lblBienvenida;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        lblBienvenida.setText("Bienvend@ ");
    }

    /**
     * Metodo del evento del boton ENCUENTRA EL LOCAL MAS CERCANO que muestra
     * una nueva ventana con los puntos de todas las sucursales existentes donde
     * cada punto muestra informacion relevante del local
     *
     * @param e ActionEvent
     */
    @FXML
    public void encontrarLocalCercano(ActionEvent e) {
        ImageView imgVMapa = null;
        try ( FileInputStream input = new FileInputStream(App.pathImg + "mapa2.png")) {
            Image imagen = new Image(input, 1100, 600, false, false);
            imgVMapa = new ImageView(imagen);

        } catch (IOException ex) {
            System.out.println("No se encontro la imagen");
        }
        Pane rootLocalCercano = new Pane();
        rootLocalCercano.getChildren().add(imgVMapa);

        ArrayList<Local> listLocales = Local.leerLocales();
        for (Local l : listLocales) {
            ImageView imgVIcono = null;
            try ( FileInputStream entrada = new FileInputStream(App.pathImg + "iconolocal.png")) {
                Image image = new Image(entrada, 100, 50, false, false);
                imgVIcono = new ImageView(image);

            } catch (IOException ex) {
                System.out.println("No se encontro la imagen");
            }
//            imgVIcono.setOnMouseClicked(new EventHandler<MouseEvent>() {
//                @Override
//                public void handle(MouseEvent t) {
//
//                    Alert info = new Alert(Alert.AlertType.INFORMATION);
//                    info.setTitle("Mostrando informacion de la sucursal");
//                    info.setHeaderText(l.getNombre() + "\n"
//                            + l.getDireccion() + "\n"
//                            + l.getHorario() + "\n"
//                    );
//                    Optional<ButtonType> opcion = info.showAndWait();
//                    if (opcion.get() == ButtonType.OK) {
//                    }
//                    int aleatorio = (int) (Math.random() * 10);
//                    Thread hiloInfo = new Thread(new Runnable() {
//                        int aleat = aleatorio;
//
//                        @Override
//                        public void run() {
//
//                            for (int i = 0; i < aleat; i++) {
//                                Platform.runLater(new Runnable() {
//                                    @Override
//                                    public void run() {
//
//                                    }
//
//                                });
//
//                            }
//                        }
//                    });
//                    hiloInfo.setDaemon(true);
//                    try {
//                        hiloInfo.sleep(aleatorio * 1000);
//                    } catch (InterruptedException ex) {
//                    }
//                }
//            });

            imgVIcono.setLayoutX(l.getCoordenadaX());
            imgVIcono.setLayoutY(l.getCoordenadaY());
            rootLocalCercano.getChildren().add(imgVIcono);

        }
        Scene scene = new Scene(rootLocalCercano, 1100, 600);
        Stage s = new Stage();
        s.setScene(scene);
        s.show();

    }
    
    /**
     * Metodo del evento del boton HAZ TU PEDIDO donde se podra realizar el
     * pedido del cliente
     *
     * @param e ActionEvent
     */
    
    @FXML
    public void realizarPedido(ActionEvent e) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("VentanaPedidos.fxml"));
            Pane root = loader.load();
//            VentanaIngresoController controladorIngreso = loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
//            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setTitle("The Good Burger Restaurant");
            stage.show();

        } catch (IOException ex) {
            System.out.println("Error");
        }
    }

}
