/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.pooespol.poo4_proy2p_luna_orrala_sambonino;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Mr Arana
 */
public class VentanaPedidosController implements Initializable {
    
    @FXML
    private VBox rootVPedidos;
    @FXML
    private ComboBox cbxTipo;
    @FXML
    private ComboBox cbxOrdenar;
    @FXML
    private GridPane gridPaneOp;
    @FXML
    private TableView tableVPedido;
    @FXML
    private TableColumn columnDescripcion;
    @FXML
    private TableColumn columnCantidad;
    @FXML
    private TableColumn columnValor;
    @FXML
    private Button btnContinuar;
    @FXML
    private Button btnLimpiar;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        encabezarGridPane();
        cbxTipo.getItems().setAll("Platos Fuertes","Postres","Bebidas","Piqueos");
    }
    
    @FXML
    public void encabezarGridPane(){
        Label l1 = new Label("Descripción");
        l1.setStyle("-fx-font-size: 11px; -fx-font-family: Georgia; -fx-font-weight: bold");
        Label l2 = new Label("    Precio");
        l2.setStyle("-fx-font-size: 11px; -fx-font-family: Georgia; -fx-font-weight: bold");
        Label l3 = new Label("Cantidad");
        l3.setStyle("-fx-font-size: 11px; -fx-font-family: Georgia; -fx-font-weight: bold");
        gridPaneOp.add(l1, 0, 0);
        gridPaneOp.add(l2, 1, 0);
        gridPaneOp.add(l3, 2, 0);
    }
    
    @FXML
    public void limpiar(ActionEvent event) {

    }

}
