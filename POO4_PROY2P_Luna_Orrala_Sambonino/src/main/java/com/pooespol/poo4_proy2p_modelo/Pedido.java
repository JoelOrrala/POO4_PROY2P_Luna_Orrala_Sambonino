/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pooespol.poo4_proy2p_modelo;

import java.util.ArrayList;

/**
 *
 * @author joelorrala
 */
public class Pedido {

    private String idPedido;
    private Cliente cliente;
    private ArrayList<PlatoEscogido> listaPlatos;

    public Pedido(String idPedido, Cliente cliente, ArrayList<PlatoEscogido> listaPlatos) {
        this.idPedido = idPedido;
        this.cliente = cliente;
        this.listaPlatos = listaPlatos;
    }

    public String getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<PlatoEscogido> getListaPlatos() {
        return listaPlatos;
    }

    public void setListaPlatos(ArrayList<PlatoEscogido> listaPlatos) {
        this.listaPlatos = listaPlatos;
    }
}
