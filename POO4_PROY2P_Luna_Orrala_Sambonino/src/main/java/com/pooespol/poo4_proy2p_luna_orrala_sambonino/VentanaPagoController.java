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
import java.util.Date;

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
    VBox rootpago;

    @FXML
    TextField txtdireccion;

    @FXML
    RadioButton rbefectivo;

    @FXML
    RadioButton rbtarjeta;

    @FXML
    Label lblmensajepago;

    @FXML
    Button btcontinuar;

    @FXML
    Button btlimpiar;

    @FXML
    VBox vbtarjeta;

    @FXML
    private ToggleGroup opciones;

    private TipoPago tipo;
    
    private Cliente clienteAct;
    private Pedido pedidoCli;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        System.out.println(txtdireccion.getText());
//        btlimpiar.setOnMouseClicked(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent t) {
//                txtdireccion.clear();
//                lblmensajepago.setText(" ");
//            }
//        });

        HBox hbox1 = new HBox();
        HBox hbox2 = new HBox();
        HBox hbox3 = new HBox();
        HBox hbox4 = new HBox();
        TextField txt1 = new TextField();
        TextField txt2 = new TextField();
        TextField txt3 = new TextField();
        TextField txt4 = new TextField();
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

        lbl5.setText("Tendra que pagar ---- dólares por el incremento del 5% por uso de la tarjeta");

        vbtarjeta.getChildren().addAll(hbox1, hbox2, hbox3, hbox4, lbl5);
        vbtarjeta.setVisible(false);
//        RadioButton elegido = (RadioButton) opciones.getSelectedToggle();
        opciones.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == rbtarjeta) {
                vbtarjeta.setVisible(true);
                tipo = TipoPago.C;
            } else if (newValue == rbefectivo) {
                vbtarjeta.setVisible(false);
                lblmensajepago.setPadding(new Insets(5, 15, 10, 15));
                lblmensajepago.setText("Tendra que pagar un total del ---- dólares. "
                        + "Aségurese de tener el dinero completo por si el repartidor no tiene cambio.");
                tipo = TipoPago.E;

            } else {
                vbtarjeta.setVisible(false);
            }
        });
//        if (rbtarjeta.isSelected()) {
//
//            rbtarjeta.setOnAction(e -> {
//                HBox hbox1 = new HBox();
//                HBox hbox2 = new HBox();
//                HBox hbox3 = new HBox();
//                HBox hbox4 = new HBox();
//                TextField txt1 = new TextField();
//                TextField txt2 = new TextField();
//                TextField txt3 = new TextField();
//                TextField txt4 = new TextField();
//                Label lbl1 = new Label("Titular: ");
//                Label lbl2 = new Label("Numero : ");
//                Label lbl3 = new Label("Caducidad: ");
//                Label lbl4 = new Label("CVV: ");
//
//                hbox1.getChildren().addAll(lbl1, txt1);
//                hbox1.setSpacing(20);
//
//                hbox2.getChildren().addAll(lbl2, txt2);
//                hbox2.setSpacing(20);
//
//                hbox3.getChildren().addAll(lbl3, txt3);
//                hbox3.setSpacing(20);
//
//                hbox4.getChildren().addAll(lbl4, txt4);
//                hbox4.setSpacing(20);
//
//                vbtarjeta.getChildren().addAll(hbox1, hbox2, hbox3, hbox4);
//
//            });
//
//        }
//        if (rbefectivo.isSelected()) {
//            lblmensajepago.setText("Tendra que pagar un total del ---- dólares.\n"
//                    + "Aségurese de tener el dinero completo por si el repartidor no tiene cambio.");
//        }
//        System.out.println(elegido.getText());

        btcontinuar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                if (txtdireccion.getText().equals("")) {
                    lblmensajepago.setText("No ha llenado todos los campos");
                } else {
                    Stage stage = (Stage) rootpago.getScene().getWindow();
                    Platform.runLater(() -> stage.close());
                    Continuar();
//                    Date fecha = new Date();
//                    Pago p = new Pago(cliente, pedido , total_pagar ,fecha,tipo);
//                    p.guardarPago();

                }

            }

        });

    }
    
    public void recuperarDatosPedido(Pedido p) {
        this.clienteAct = p.getCliente();
        this.pedidoCli = p;
    }

    public void Continuar() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("VentanaDespedida.fxml"));
            Pane root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            scene.getStylesheets().add(App.class.getResource("ingreso.css").toExternalForm());
            stage.setScene(scene);
            stage.setTitle("The Good Burger Restaurant");
            stage.showAndWait();

        } catch (IOException ex) {
            System.out.println("Error al momento de continuar");
        }

    }

    @FXML
    void limpiar(ActionEvent event) {
        if (txtdireccion != null) {
            txtdireccion.clear();
        }
        lblmensajepago.setText("");
        rbtarjeta.setSelected(false);
        rbefectivo.setSelected(false);
    }

}
