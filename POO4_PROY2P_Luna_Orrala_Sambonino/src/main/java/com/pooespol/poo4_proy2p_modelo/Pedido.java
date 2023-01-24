/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pooespol.poo4_proy2p_modelo;

import com.pooespol.poo4_proy2p_luna_orrala_sambonino.App;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author joelorrala
 */
public class Pedido implements Serializable {

    private String idPedido;
    private Cliente cliente;
    private ArrayList<PlatoEscogido> listaPlatos;
    private String direccionEntrega;
    private double subtotal;
    private double ivaPedido;
    private double total;

    private static final long serialVersionUID = 6394426406957881396L;

    public Pedido(Cliente cliente, ArrayList<PlatoEscogido> listaPlatos, String direccionEntrega, double subtotal, double ivaPedido, double total) {
        this.idPedido = generarCodigoPedido();
        this.cliente = cliente;
        this.listaPlatos = listaPlatos;
        this.direccionEntrega = direccionEntrega;
        this.subtotal = subtotal;
        this.ivaPedido = ivaPedido;
        this.total = total;
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

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getIvaPedido() {
        return ivaPedido;
    }

    public void setIvaPedido(double ivaPedido) {
        this.ivaPedido = ivaPedido;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    private String generarCodigoPedido() {
        String codigo = "PD";

        for (int i = 1; i <= 4; i++) {
            int numero = (int) (Math.random() * 10);
            codigo += numero;
        }
        return codigo;
    }

    @Override
    public String toString() {
        return "Pedido{idPedido: " + idPedido + ", cliente: " + cliente.getNombre() + ", lista platos: " + listaPlatos + ", dirección entrega: " + direccionEntrega
                + ", subtotal: " + subtotal + ", iva pedido: " + ivaPedido + " , total: " + total;
    }

    public void guardarPedido() {
        try ( BufferedWriter bw = new BufferedWriter(new FileWriter(App.pathFiles + "pedidos.txt", true))) {
            bw.write(idPedido + "," + cliente.getNombre() + "," + total + "\n");
        } catch (IOException ex) {
            System.out.println("No se pudo escribir en el archivo pedidos.txt");
        }
    }

    public void guardarObjetoPedido() {
        try ( ObjectOutputStream objPed = new ObjectOutputStream(new FileOutputStream(App.pathPed + "pedido" + idPedido + ".bin"))) {
            objPed.writeObject(this);
            System.out.println("Objeto guardado");
        } catch (IOException e) {
            System.out.println("No se ha podido guardar el objeto pedido");
        }
    }
}
