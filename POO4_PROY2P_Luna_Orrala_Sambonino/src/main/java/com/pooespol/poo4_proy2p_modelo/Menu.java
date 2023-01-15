/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pooespol.poo4_proy2p_modelo;

/**
 *
 * @author joelorrala
 */
public class Menu {

    private String descripcion;
    private double precio;
    private TipoMenu tipo;

    public Menu(String descripcion, double precio, TipoMenu tipo) {
        this.descripcion = descripcion;
        this.precio = precio;
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public TipoMenu getTipoMenu() {
        return tipo;
    }

    public void setTipoMenu(TipoMenu tipo) {
        this.tipo = tipo;
    }
}
