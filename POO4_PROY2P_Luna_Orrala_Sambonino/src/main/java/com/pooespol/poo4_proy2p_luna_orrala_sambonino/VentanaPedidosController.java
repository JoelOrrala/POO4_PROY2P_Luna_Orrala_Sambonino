/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.pooespol.poo4_proy2p_luna_orrala_sambonino;

import com.pooespol.poo4_proy2p_modelo.Cliente;
import com.pooespol.poo4_proy2p_modelo.ComparadorDePrecios;
import com.pooespol.poo4_proy2p_modelo.Menu;
import com.pooespol.poo4_proy2p_modelo.Pedido;
import com.pooespol.poo4_proy2p_modelo.PlatoEscogido;
import com.pooespol.poo4_proy2p_modelo.TipoMenu;
import com.pooespol.poo4_proy2p_modelo.ValorInsuficienteException;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author L.Luna
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
    @FXML
    private Label lblSubtotal;
    @FXML
    private Label lblIVA;
    @FXML
    private Label lblTotal;

    private ArrayList<Menu> listMenu;

    private ArrayList<PlatoEscogido> listPlatoEscogido;

    private ObservableList<PlatoEscogido> datosVentana;
    
    private Cliente cliente;

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
        columnValor.setCellValueFactory(new PropertyValueFactory("totalPlato"));
        listPlatoEscogido = new ArrayList<>();
        cbxOrdenar.getItems().setAll("Precio", "Nombre");
        Collections.sort(listMenu, new ComparadorDePrecios());
        lblIVA.setText("0.00");
        lblTotal.setText("0.00");
        lblSubtotal.setText("0.00");

    }
    
    public void recuperarCliente(Cliente c) {
        this.cliente = c;
    }

    @FXML
    public void encabezarGridPane() {
        Label l1 = new Label("Descripción");
        l1.setStyle("-fx-font-size: 11px; -fx-font-family: Georgia; -fx-font-weight: bold");
        Label l2 = new Label("Precio");
        l2.setStyle("-fx-font-size: 11px; -fx-font-family: Georgia; -fx-font-weight: bold");
        Label l3 = new Label("Cantidad");
        l3.setStyle("-fx-font-size: 11px; -fx-font-family: Georgia; -fx-font-weight: bold");
        gridPaneOp.add(l1, 0, 0);
        gridPaneOp.add(l2, 1, 0);
        gridPaneOp.add(l3, 2, 0);
    }

    /**
     * Metodo Limpiar del evento del boton Limpiar para eliminar los residuos de
     * una compra anterior
     *
     * @param event Action Event
     */
    @FXML
    public void limpiar(ActionEvent event) {
        cbxOrdenar.setValue("");
        cbxTipo.setValue("");
        gridPaneOp.getChildren().clear();
        tableVPedido.getItems().clear();
        lblIVA.setText("0.00");
        lblTotal.setText("0.00");
        lblSubtotal.setText("0.00");
        listPlatoEscogido.clear();
        datosVentana.clear();
        encabezarGridPane();

    }

    /**
     * ComboBox para que el usuario escoga el ordenamiento de los elementos sea
     * por los precios de forma ascedente o por sus nombres de forma ascendente
     *
     * @param event
     */
    @FXML
    public void ordenarGridPane(ActionEvent event) {
        String selecOrden = (String) cbxOrdenar.getValue();
        if (selecOrden.equals("Precio")) {
            Collections.sort(listMenu, new ComparadorDePrecios());
            mostrarMenu();
        } else if (selecOrden.equals("Nombre")) {
            Collections.sort(listMenu);
            mostrarMenu();
        }
    }

    /**
     * Metodo mostrarMenu para cuando se seleccione al comboBox un tipo de plato
     * se muestre aquellos platos disponibles de ese tipo de plato seleccionado
     */
    @FXML
    public void mostrarMenu() {
        String seleccion = (String) cbxTipo.getValue();
        TipoMenu nombre = Menu.obtenerTipo(seleccion);
        gridPaneOp.getChildren().clear();
        encabezarGridPane();

        if (seleccion != null) {
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
                            try {
                                String cantidadTxt = tCantidad.getText();
                                if (cantidadTxt.equals("0")) {
                                    throw new ValorInsuficienteException("Ingrese una cantidad válida");
                                } else {
                                    int cantidadInt = Integer.parseInt(cantidadTxt);
                                    PlatoEscogido plato = new PlatoEscogido(m.getDescripcion(), m.getPrecio(), m.getTipoMenu(), cantidadInt);
                                    listPlatoEscogido.add(plato);
                                    datosVentana.add(plato);
                                    tableVPedido.setItems(datosVentana);
                                    mostrarDatosLabel(plato.getTotalPlato());
                                }
                            } catch (ValorInsuficienteException va) {
                                Alert alerta = new Alert(Alert.AlertType.ERROR);
                                alerta.setTitle("Error en Pedidos");
                                alerta.setHeaderText(va.getMessage());
                                alerta.showAndWait();
                            } catch(NumberFormatException numEx){
                                Alert alerta = new Alert(Alert.AlertType.ERROR);
                                alerta.setTitle("Error en Pedidos");
                                alerta.setHeaderText("Verifique el casillero de cantidad");
                                alerta.showAndWait();
                            }
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

    @FXML
    public void llenarGridPane(ActionEvent e) {
        mostrarMenu();
    }
    
    @FXML
    public void mostrarDatosLabel(double subtotal){
        DecimalFormat df = new DecimalFormat("#.00");
        double subAntes = Double.valueOf(lblSubtotal.getText());
        double subDesp = subAntes + subtotal;
        double iva = subDesp * 0.12;
        double total = subDesp + iva;
        lblSubtotal.setText(String.valueOf(df.format(subDesp)));
        lblIVA.setText(String.valueOf(df.format(iva)));
        lblTotal.setText(String.valueOf(df.format(total)));
    }

    @FXML
    public void continuar(ActionEvent e) {
        double subtotalFinal = Double.valueOf(lblSubtotal.getText());
        double ivaFinal = Double.valueOf(lblSubtotal.getText());
        double totalFinal = Double.valueOf(lblTotal.getText());
        if (subtotalFinal != 0.00) {
            try {

                FXMLLoader loader = new FXMLLoader(getClass().getResource("VentanaPago.fxml"));
                Pane rootVentanaPago = loader.load();
                VentanaPagoController controladorPago = loader.getController();

                Pedido pedidoEntregar = new Pedido(this.cliente, this.listPlatoEscogido, subtotalFinal, ivaFinal, totalFinal);

                controladorPago.recuperarDatosPedido(pedidoEntregar);

                Scene scene = new Scene(rootVentanaPago, 640, 700);
                scene.getStylesheets().add(App.class.getResource("pago.css").toExternalForm());
                Stage stage = new Stage();
//            stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(scene);
                stage.setTitle("The Good Burger Restaurant");
                stage.show();

            } catch (IOException ex) {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Error en Pedidos");
                alerta.setHeaderText("Error, no puede continuar");
                alerta.showAndWait();
            }
        } else {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error en Pedidos");
            alerta.setHeaderText("No ha hecho el pedido");
            alerta.showAndWait();
        }

    }

}
