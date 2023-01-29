/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.pooespol.poo4_proy2p_luna_orrala_sambonino;

import com.pooespol.poo4_proy2p_modelo.Menu;
import com.pooespol.poo4_proy2p_modelo.PlatoEscogido;
import com.pooespol.poo4_proy2p_modelo.TipoMenu;
import java.net.URL;
import java.util.ArrayList;
import java.util.Observable;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
    private TableView<PlatoEscogido> tableVPedido;
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

    private ArrayList<Menu> listMenu;

    private ArrayList<PlatoEscogido> listPlatoEscogido;

    private ObservableList<PlatoEscogido> datosVentana;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        listMenu = Menu.leerMenus();
        encabezarGridPane();
        cbxTipo.getItems().setAll("Platos Fuertes", "Postres", "Bebidas", "Piqueos");
        datosVentana = FXCollections.observableArrayList();
        columnDescripcion.setCellValueFactory(new PropertyValueFactory("descripcion"));
        columnCantidad.setCellValueFactory(new PropertyValueFactory("cantidad"));
        columnValor.setCellValueFactory(new PropertyValueFactory("precio"));
        listPlatoEscogido = new ArrayList<>();

    }

    @FXML
    public void encabezarGridPane() {
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

    @FXML
    public void llenarGridPane(ActionEvent e) {
        String seleccion = (String) cbxTipo.getValue();
        TipoMenu nombre = Menu.obtenerTipo(seleccion);
        gridPaneOp.getChildren().clear();

        if (seleccion != "") {
            int n = 1;
            for (Menu m : listMenu) {
                if (m.getTipoMenu() == nombre) {
                    Label lDescripcion = new Label(m.getDescripcion());
                    Label lPrecio = new Label(String.valueOf(m.getPrecio()));

                    TextField tCantidad = new TextField();
                    Button btnAgregar = new Button();
                    btnAgregar.setText("Agregar");
                    btnAgregar.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent t) {
                            PlatoEscogido plato = new PlatoEscogido(m.getDescripcion(), m.getPrecio(), m.getTipoMenu(), Integer.parseInt(tCantidad.getText()));
                            listPlatoEscogido.add(plato);
                            datosVentana.add(plato);
                            tableVPedido.setItems(datosVentana);

                        }

                    });
                    gridPaneOp.add(lDescripcion, 0, n);
                    gridPaneOp.add(lPrecio, 1, n);

                    gridPaneOp.add(tCantidad, 2, n);
                    gridPaneOp.add(btnAgregar, 3, n);

                    n++;

                }

            }

        }

    }

}
