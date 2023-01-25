/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.pooespol.poo4_proy2p_luna_orrala_sambonino;

import com.pooespol.poo4_proy2p_modelo.Cliente;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Mr Arana
 */
public class VentanaIngresoController implements Initializable {

    private static ArrayList<Cliente> listClientes = Cliente.leerClientes();

    @FXML
    private PasswordField campoContraseña;
    @FXML
    private TextField campoUsuario;
    @FXML
    private Button btnIngresar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
//        boolean encontrado = Cliente.verificarCliente(listClientes, campoUsuario.getText(), campoContraseña.getText());
//        if (encontrado == true) {
//            btnIngresar.setOnAction(new EventHandler<ActionEvent>() {
//                @Override
//                public void handle(ActionEvent t) {
//                    ingresar();
//
//                }
//
//            });
//
//        }
        btnIngresar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                ingresar();
            }

        });

    }

    public void ingresar() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("VentanaUsuario.fxml"));
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
