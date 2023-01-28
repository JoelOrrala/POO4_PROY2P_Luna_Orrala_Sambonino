/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pooespol.poo4_proy2p_modelo;

import com.pooespol.poo4_proy2p_luna_orrala_sambonino.App;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/** La clase Cliente hace referencia al usuario que se encuentra utilizando la app
 *
 * @author joelorrala
 */
public class Cliente {

    private String nombre;
    private String usuario;
    private String contrasenia;
    
    /**
     * Constructor de la clase Cliente que recibe los datos nombre, usuario y contraseña
     * @param nombre nombre del cliente
     * @param usuario usuario del cliente
     * @param contrasenia contraseña del cliente
     */
    public Cliente(String nombre, String usuario, String contrasenia) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }
    
    /**
     * 
     * @return nombre del cliente
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Permite cambiar el nombre del cliente
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * 
     * @return usuario del cliente
     */
    public String getUsuario() {
        return usuario;
    }
    
    /**
     * Permite cambiar el usuario del cliente
     * @param usuario 
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    /**
     * 
     * @return contraseña del cliente
     */
    public String getContrasenia() {
        return contrasenia;
    }
    
    /**
     * Permite cambiar la contraseña del cliente
     * @param contrasenia
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
    /**
     * Leer el archivo de usuarios.txt, crea los respectivos objetos y los almacena en una lista para retornarlos
     * @return lista de objetos tipo Cliente
     */
    public static ArrayList<Cliente> leerClientes() {
        ArrayList<Cliente> listCli = new ArrayList<>();
        try ( BufferedReader br = new BufferedReader(new FileReader(App.pathFiles + "usuarios.txt", StandardCharsets.UTF_8))) {
            String linea = br.readLine();
            while ((linea = br.readLine()) != null) {
                String[] sep = linea.trim().strip().split(",");
                listCli.add(new Cliente(sep[0], sep[1], sep[2]));
            }
        } catch (IOException ex) {
            System.out.println("No se pudo leer el archivo");
        }
        return listCli;
    }
    
    /**
     * Verifica si el cliente se encuentra entre los usuarios registrados en una lista recibida como parámetro
     * @param listaClientes
     * @param usuario
     * @param contrasenia
     * @return booleano
     */
    public static boolean verificarCliente(ArrayList<Cliente> listaClientes, String usuario, String contrasenia) {
        boolean encontrado = false;
        for (Cliente c : listaClientes) {
            if (c.getUsuario().equals(usuario) && c.getContrasenia().equals(contrasenia)) {
                encontrado = true;
            }
        }
        return encontrado;
    }
    
    public static Cliente retornarCliente(ArrayList<Cliente> listaClientes, String usuario, String contrasenia) {
        Cliente cliente = null;
        for (Cliente c : listaClientes) {
            if (c.getUsuario().equals(usuario) && c.getContrasenia().equals(contrasenia)) {
                cliente = c;
            }
        }
        return cliente;
    }
    
    @Override
    public String toString() {
        return nombre;
    }
    
}
