/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pooespol.poo4_proy2p_modelo;

import java.util.Date;

/**
 *
 * @author joelorrala
 */
public class Pago {
    private String idPago;
    private Cliente cliente;
    private Pedido pedido;
    private double totalPagar;
    private Date fecha;
    private TipoPago tipo;
    
    public Pago(String idPago, Cliente cliente, Pedido pedido, double totalPagar, Date fecha, TipoPago tipo){
        this.idPago = idPago;
        this.cliente = cliente;
        this.pedido = pedido;
        this.totalPagar = totalPagar;
        this.fecha = fecha;
        this.tipo = tipo;
    }
    
    public String getIdPago(){
        return idPago;
    }
    
    public void setIdPago(String idPago){
        this.idPago = idPago;
    }
    
    public Cliente getCliente(){
        return cliente;
    }
    
    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }
    
    public Pedido getPedido(){
        return pedido;
    }
    
    public void setPedido(Pedido pedido){
        this.pedido = pedido;
    }
    
    public double getTotalPagar(){
        return totalPagar;
    }
    
    public void setTotalPagar(double totalPagar){
        this.totalPagar = totalPagar;
    }
    
    public Date getFecha(){
        return fecha;
    }
    
    public void setFecha(Date fecha){
        this.fecha = fecha;
    }
    
    public TipoPago getTipoPago(){
        return tipo;
    }
    
    public void setTipoPago(TipoPago tipo){
        this.tipo = tipo;
    }
    
}
