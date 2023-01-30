/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.pooespol.poo4_proy2p_luna_orrala_sambonino;

import com.pooespol.poo4_proy2p_modelo.Cliente;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Mr Arana
 */
public class VentanaIngresoController implements Initializable {

    private Cliente clienteIng;
    private static ArrayList<Cliente> listClientes = Cliente.leerClientes();

    @FXML
    private PasswordField campoContrasenia;
    @FXML
    private TextField campoUsuario;
    @FXML
    private Button btnIngresar;
    @FXML
    private ImageView imgIzq;
    @FXML
    private ImageView imgDer;
    @FXML
    private Label lblmensaje;
    @FXML
    private VBox rootingreso;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try ( FileInputStream input = new FileInputStream(App.pathImg + "delivery_inicio.png");  FileInputStream input2 = new FileInputStream(App.pathImg + "hamburguesa.png");) {
            Image image = new Image(input);
            Image image2 = new Image(input2);
            imgIzq.setImage(image);
            imgDer.setImage(image2);

        } catch (IOException ex) {
            System.out.println("No se encuentran las imágenes");
        }

        btnIngresar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                if (Cliente.verificarCliente(listClientes, campoUsuario.getText(), campoContrasenia.getText()) == true) {
                    clienteIng = Cliente.retornarCliente(listClientes, campoUsuario.getText(), campoContrasenia.getText());
                    Stage stage = (Stage) rootingreso.getScene().getWindow();
                    Platform.runLater(() -> stage.close());
                    ingresar();
                } else {
                    lblmensaje.setText("Ingreso no válido");
                }

            }

        });

    }

    /**
     * ingresa al usuario
     */

    public void ingresar() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("VentanaUsuario.fxml"));
            Pane root = loader.load();
            VentanaUsuarioController controladorUsuario = loader.getController();
            controladorUsuario.recuperarCliente(clienteIng);
            Scene scene = new Scene(root);
            scene.getStylesheets().add(App.class.getResource("sistema.css").toExternalForm());
            Stage stage = new Stage();
//            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setTitle("The Good Burger Restaurant");
            stage.setResizable(false);
            stage.showAndWait();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }

    }

}
