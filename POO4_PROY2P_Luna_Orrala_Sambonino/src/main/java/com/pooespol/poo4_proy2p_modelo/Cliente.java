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

/**
 *
 * @author joelorrala
 */
public class Cliente {

    private String nombre;
    private String usuario;
    private String contrasenia;

    public Cliente(String nombre, String usuario, String contrasenia) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

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

    public static boolean verificarCliente(ArrayList<Cliente> listaClientes, String usuario, String contrasenia) {
        boolean encontrado = false;
        for (Cliente c : listaClientes) {
            if (c.getUsuario().equals(usuario) && c.getContrasenia().equals(contrasenia)) {
                encontrado = true;
            }
        }
        return encontrado;
    }
}
