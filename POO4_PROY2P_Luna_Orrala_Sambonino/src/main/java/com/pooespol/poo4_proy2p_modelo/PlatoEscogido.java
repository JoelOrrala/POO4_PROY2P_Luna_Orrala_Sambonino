/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pooespol.poo4_proy2p_modelo;

import java.io.Serializable;

/**
 * Hace referencia al plato seleccionado por el cliente y adicionalmente se especifica la cantidad
 * @author joelorrala
 */
public class PlatoEscogido extends Menu implements Serializable{

    private int cantidad;
    private double totalPlato;
    
    /**
     * Constructor de clase PlatoEscogido
     * @param descripcion
     * @param precio
     * @param tipo
     * @param cantidad 
     */
    public PlatoEscogido(String descripcion, double precio, TipoMenu tipo, int cantidad) {
        super(descripcion, precio, tipo);
        this.cantidad = cantidad;
        this.totalPlato = precio * cantidad;
    }
    
    /**
     * 
     * @return cantidad de platos del mismo tipo solicitados
     */
    public int getCantidad() {
        return cantidad;
    }
    
    /**
     * Permite cambiar la cantidad de platos del mismo tipo solicitados
     * @param cantidad 
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getTotalPlato() {
        return totalPlato;
    }

    public void setTotalPlato(double totalPlato) {
        this.totalPlato = totalPlato;
    }
    
    
}
