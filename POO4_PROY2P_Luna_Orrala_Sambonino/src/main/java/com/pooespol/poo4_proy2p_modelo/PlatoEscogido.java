/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pooespol.poo4_proy2p_modelo;

/**
 *
 * @author joelorrala
 */
public class PlatoEscogido extends Menu {

    private int cantidad;

    public PlatoEscogido(String descripcion, double precio, TipoMenu tipo, int cantidad) {
        super(descripcion, precio, tipo);
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
