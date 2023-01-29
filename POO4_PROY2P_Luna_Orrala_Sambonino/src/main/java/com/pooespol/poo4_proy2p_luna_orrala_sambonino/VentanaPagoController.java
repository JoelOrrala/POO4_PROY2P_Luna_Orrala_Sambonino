/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.pooespol.poo4_proy2p_luna_orrala_sambonino;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import com.pooespol.poo4_proy2p_modelo.*;
import java.text.DecimalFormat;
import java.util.Date;
import javafx.scene.control.Alert;

/**
 * FXML Controller class
 *
 * @author Giovanni
 */
public class VentanaPagoController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private VBox rootpago;

    @FXML
    private TextField txtdireccion;

    @FXML
    private RadioButton rbefectivo;

    @FXML
    private RadioButton rbtarjeta;

    @FXML
    private Label lblmensajepago;
    
    @FXML
    private Label lblmensajepago2;

    @FXML
    private Button btcontinuar;

    @FXML
    private Button btlimpiar;

    @FXML
    private VBox vbtarjeta;

    @FXML
    private ToggleGroup opciones;

    private TipoPago tipo;
    
    private Cliente clienteAct;
    private Pedido pedidoCli;
    private double totalPagar = 0;
    
    private TextField txt1;
    private TextField txt2;
    private TextField txt3;
    private TextField txt4;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        System.out.println(txtdireccion.getText());

        HBox hbox1 = new HBox();
        HBox hbox2 = new HBox();
        HBox hbox3 = new HBox();
        HBox hbox4 = new HBox();
        txt1 = new TextField();
        txt2 = new TextField();
        txt3 = new TextField();
        txt4 = new TextField();
        Label lbl1 = new Label("Titular: ");
        Label lbl2 = new Label("Numero : ");
        Label lbl3 = new Label("Caducidad: ");
        Label lbl4 = new Label("CVV: ");
        Label lbl5 = new Label();

        hbox1.getChildren().addAll(lbl1, txt1);
        hbox1.setSpacing(20);
        hbox1.setPadding(new Insets(5, 15, 10, 15));

        hbox2.getChildren().addAll(lbl2, txt2);
        hbox2.setSpacing(20);
        hbox2.setPadding(new Insets(5, 15, 10, 15));

        hbox3.getChildren().addAll(lbl3, txt3);
        hbox3.setSpacing(20);
        hbox3.setPadding(new Insets(5, 15, 10, 15));

        hbox4.getChildren().addAll(lbl4, txt4);
        hbox4.setSpacing(20);
        hbox4.setPadding(new Insets(5, 15, 10, 15));
        
        DecimalFormat df = new DecimalFormat("#.00");
        vbtarjeta.getChildren().addAll(hbox1, hbox2, hbox3, hbox4, lbl5);
        vbtarjeta.setVisible(false);
        opciones.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == rbtarjeta) {
                lblmensajepago.setText("");
                lblmensajepago.setText("");
                vbtarjeta.setVisible(true);
                tipo = TipoPago.C;
                totalPagar = pedidoCli.getTotal() + (pedidoCli.getTotal() * 0.05);
                lbl5.setText("Tendra que pagar " + df.format(totalPagar) + " dólares por el incremento del 5% por uso de la tarjeta");

            } else if (newValue == rbefectivo) {
                vbtarjeta.setVisible(false);
                lblmensajepago.setPadding(new Insets(5, 15, 10, 15));
                lblmensajepago.setText("Tendra que pagar un total de " + pedidoCli.getTotal() + " dólares.");
                lblmensajepago2.setText("Aségurese de tener el dinero completo por si el repartidor no tiene cambio.");
                tipo = TipoPago.E;
                totalPagar = pedidoCli.getTotal();
            } else {
                vbtarjeta.setVisible(false);
            }
        });


        btcontinuar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                if (txtdireccion.getText().equals("")) {
                    lblmensajepago.setText("No ha llenado todos los campos");
                } else if(txt1.getText().equals("") | txt2.getText().equals("") | txt3.getText().equals("") | txt4.getText().equals("")){
                    lblmensajepago.setText("Faltan datos de la tarjeta de crédito");
                }else {
                    Thread threadGuardar = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            pedidoCli.guardarObjetoPedido();
                            pedidoCli.guardarPedido();
                            Date fecha = new Date();
                            Pago p = new Pago(clienteAct, pedidoCli, totalPagar, fecha, tipo);
                            p.guardarPago();
                        }
                    });
                    threadGuardar.start();
                    
                    Stage stage = (Stage) rootpago.getScene().getWindow();
                    Platform.runLater(() -> stage.close());
                    Continuar();
                }
            }

        });

    }
    
    /**
     * recupera los datos del pedido
     * @param p datos pedido
     */

    public void recuperarDatosPedido(Pedido p) {
        this.clienteAct = p.getCliente();
        this.pedidoCli = p;
    }
    /**
     * continua a la despedida
     */

    public void Continuar() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("VentanaDespedida.fxml"));
            Pane root = loader.load();
            VentanaDespedidaController controladorDespedida = loader.getController();
            controladorDespedida.recuperarDato(pedidoCli);
            Scene scene = new Scene(root,690,470);
            Stage stage = new Stage();
            scene.getStylesheets().add(App.class.getResource("despedida.css").toExternalForm());
            stage.setScene(scene);
            stage.setTitle("The Good Burger Restaurant");
            stage.showAndWait();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    @FXML
    void limpiar(ActionEvent event) {
        if (txtdireccion != null) {
            txtdireccion.clear();
        }
        txt1.clear();
        txt2.clear();
        txt3.clear();
        txt4.clear();
        
        lblmensajepago.setText("");
        rbtarjeta.setSelected(false);
        rbefectivo.setSelected(false);
    }

}
