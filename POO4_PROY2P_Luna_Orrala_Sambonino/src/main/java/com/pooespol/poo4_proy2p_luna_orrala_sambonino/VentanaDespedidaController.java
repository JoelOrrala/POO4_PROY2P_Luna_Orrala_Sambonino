/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.pooespol.poo4_proy2p_luna_orrala_sambonino;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import com.pooespol.poo4_proy2p_modelo.Pago;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Giovanni
 */
public class VentanaDespedidaController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML 
    Label lblMensajeDespedida;
    
    @FXML 
    ImageView imgdespedida;
    
    @FXML
    Label lblCerrarventana;
    
    @FXML
    VBox _rootdespedida;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
        lblMensajeDespedida.setText("Su pedido N° ha sido pagado con exito y ahora empezaremos a prepararlo.\n" 
                    +"En aproximadamente 30 minutos llegara a su destino.\n"
                    +"Gracias por preferirnos.");
        try ( FileInputStream input = new FileInputStream(new File(App.pathImg+"delivery_final.png"))) {
            Image img2 = new Image(input);
            imgdespedida.setImage(img2);
        } catch (FileNotFoundException fnf) {
            System.out.println("No se encontro el archivo");
        } catch (IOException ioe) {
            System.out.println("Io Exception");
        }
        crearThreadNuevaVentana(lblCerrarventana);
        
        
        
    }
    public void crearThreadNuevaVentana(Label labelCont) {
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 5; i > -1; i--) {
                    String mensaje = "Cerrando en "+ i + ".....";
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            labelCont.setText(mensaje);
                        }
                    });
                    try {
                        Thread.sleep(1000);
                        
                    } catch (InterruptedException ex) {
                    }
                }
                Stage stage = (Stage)_rootdespedida.getScene().getWindow();
                Platform.runLater(() -> stage.close());
            }
        });
        t2.start();
        
    }

}
