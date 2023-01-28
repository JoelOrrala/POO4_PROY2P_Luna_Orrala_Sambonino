/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pooespol.poo4_proy2p_modelo;

import com.pooespol.poo4_proy2p_luna_orrala_sambonino.App;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

/**
 * Hace referencia al pago que hace el cliente
 * @author joelorrala
 */
public class Pago {

    private String idPago;
    private Cliente cliente;
    private Pedido pedido;
    private double totalPagar;
    private Date fecha;
    private TipoPago tipo;
    
    /**
     * Constructor de la clase Pago
     * @param cliente
     * @param pedido
     * @param totalPagar
     * @param fecha
     * @param tipo 
     */
    public Pago(Cliente cliente, Pedido pedido, double totalPagar, Date fecha, TipoPago tipo) {
        this.idPago = generarCodigoPago();
        this.cliente = cliente;
        this.pedido = pedido;
        this.totalPagar = totalPagar;
        this.fecha = fecha;
        this.tipo = tipo;
    }
    
    /**
     * 
     * @return ID del pago
     */
    public String getIdPago() {
        return idPago;
    }
    
    /**
     * Permite cambiar el ID del pago
     * @param idPago 
     */
    public void setIdPago(String idPago) {
        this.idPago = idPago;
    }
    
    /**
     * 
     * @return cliente
     */
    public Cliente getCliente() {
        return cliente;
    }
    
    /**
     * 
     * @return pedido
     */
    public Pedido getPedido() {
        return pedido;
    }
    
    /**
     * Permite cambiar el pedido
     * @param pedido 
     */
    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    
    /**
     * 
     * @return total a pagar
     */
    public double getTotalPagar() {
        return totalPagar;
    }
    
    /**
     * Permite cambiar el total a pagar
     * @param totalPagar 
     */
    public void setTotalPagar(double totalPagar) {
        this.totalPagar = totalPagar;
    }
    
    /**
     * 
     * @return fecha
     */
    public Date getFecha() {
        return fecha;
    }
    
    /**
     * Permite cambiar la fecha del pago
     * @param fecha 
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    /**
     * 
     * @return tipo de pago que se realiza
     */
    public TipoPago getTipoPago() {
        return tipo;
    }

    /**
     * Permite cambiar el tipo de pago que se realiza
     * @param tipo 
     */
    public void setTipoPago(TipoPago tipo) {
        this.tipo = tipo;
    }
    
    /**
     * Genera un código aleatorio para un pago
     * @return código Pago
     */
    private String generarCodigoPago() {
        String codigo = "PG";

        for (int i = 1; i <= 4; i++) {
            int numero = (int) (Math.random() * 10);
            codigo += numero;
        }
        return codigo;
    }
    
    /**
     * Permite guardar los datos del objeto pago dentro de un archivo txt
     */
    public void guardarPago() {
        try ( BufferedWriter bw = new BufferedWriter(new FileWriter(App.pathFiles + "pagos.txt", true))) {
            bw.write(idPago + "," + pedido.getIdPedido() + "," + cliente.getNombre() + "," + totalPagar + "," + fecha + "," + tipo + "\n");
        } catch (IOException ex) {
            System.out.println("No se pudo escribir en el archivo pagos.txt");
        }
    }
}
