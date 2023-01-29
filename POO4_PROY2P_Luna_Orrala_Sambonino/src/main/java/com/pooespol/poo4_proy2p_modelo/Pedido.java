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
 * Hace referncia al pedido que realiza el cliente
 * @author joelorrala
 */
public class Pedido implements Serializable {

    private String idPedido;
    private Cliente cliente;
    private ArrayList<PlatoEscogido> listaPlatos;
    private double subtotal;
    private double ivaPedido;
    private double total;

    private static final long serialVersionUID = 6394426406957881396L;
    
    /**
     * Constructor de la clase Pedido
     * @param cliente
     * @param listaPlatos
     * @param direccionEntrega
     * @param subtotal
     * @param ivaPedido
     * @param total 
     */
    public Pedido(Cliente cliente, ArrayList<PlatoEscogido> listaPlatos, double subtotal, double ivaPedido, double total) {
        this.idPedido = generarCodigoPedido();
        this.cliente = cliente;
        this.listaPlatos = listaPlatos;
        this.subtotal = subtotal;
        this.ivaPedido = ivaPedido;
        this.total = total;
    }
    
    /**
     * 
     * @return ID del pedido
     */
    public String getIdPedido() {
        return idPedido;
    }
    
    /**
     * Permite cambiar el ID del pedido
     * @param idPedido 
     */
    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }
    
    /**
     * 
     * @return cliente que hace el pedido
     */
    public Cliente getCliente() {
        return cliente;
    }
    
    /**
     * 
     * @return lista de platos escogidos dentro del pedido
     */
    public ArrayList<PlatoEscogido> getListaPlatos() {
        return listaPlatos;
    }
    
    /**
     * Permite cambiar la lista de platos escogidos dentro del pedido
     * @param listaPlatos 
     */
    public void setListaPlatos(ArrayList<PlatoEscogido> listaPlatos) {
        this.listaPlatos = listaPlatos;
    }
    
    /**
     * 
     * @return subtotal a pagar
     */
    public double getSubtotal() {
        return subtotal;
    }
    
    /**
     * Permite cambiar el subtotal a pagar
     * @param subtotal 
     */
    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
    
    /**
     * 
     * @return IVA del pedido
     */
    public double getIvaPedido() {
        return ivaPedido;
    }
    
    /**
     * Permite cambiar el IVA del pedido
     * @param ivaPedido 
     */
    public void setIvaPedido(double ivaPedido) {
        this.ivaPedido = ivaPedido;
    }
    
    /**
     * 
     * @return total a pagar
     */
    public double getTotal() {
        return total;
    }
    
    /**
     * Permite cambiar el total a pagar
     * @param total 
     */
    public void setTotal(double total) {
        this.total = total;
    }
    
    /**
     * Genera un código aleatorio para el pedido
     * @return 
     */
    private String generarCodigoPedido() {
        String codigo = "PD";

        for (int i = 1; i <= 4; i++) {
            int numero = (int) (Math.random() * 10);
            codigo += numero;
        }
        return codigo;
    }
    
    /**
     * Sobreescritura del método toString() para la clase Pedido
     * @return 
     */
    @Override
    public String toString() {
        return "Pedido{idPedido: " + idPedido + ", cliente: " + cliente.getNombre() + ", lista platos: " + listaPlatos
                + ", subtotal: " + subtotal + ", iva pedido: " + ivaPedido + " , total: " + total;
    }
    
    /**
     * Permite guardar el pedido del cliente dentro de un archivo txt
     */
    public void guardarPedido() {
        try ( BufferedWriter bw = new BufferedWriter(new FileWriter(App.pathFiles + "pedidos.txt", true))) {
            bw.write(idPedido + "," + cliente.getNombre() + "," + total + "\n");
        } catch (IOException ex) {
            System.out.println("No se pudo escribir en el archivo pedidos.txt");
        }
    }
    
    /**
     * Permite serializar el pedido del cliente
     */
    public void guardarObjetoPedido() {
        try ( ObjectOutputStream objPed = new ObjectOutputStream(new FileOutputStream(App.pathPed + "pedido" + idPedido + ".bin"))) {
            objPed.writeObject(this);
            System.out.println("Objeto guardado");
        } catch (IOException e) {
            System.out.println("No se ha podido guardar el objeto pedido");
        }
    }
}
