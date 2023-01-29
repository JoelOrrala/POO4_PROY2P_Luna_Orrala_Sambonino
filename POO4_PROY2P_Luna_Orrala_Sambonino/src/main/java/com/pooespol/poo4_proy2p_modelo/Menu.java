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
 * Clase menú hace referencia al menú de platillos que se ofrece en el restaurante
 * @author joelorrala
 */
public class Menu implements Comparable<Menu>{

    private String descripcion;
    private double precio;
    private TipoMenu tipo;
    
    /**
     * Constructor de la clase Menú
     * @param descripcion
     * @param precio
     * @param tipo 
     */
    public Menu(String descripcion, double precio, TipoMenu tipo) {
        this.descripcion = descripcion;
        this.precio = precio;
        this.tipo = tipo;
    }

    /**
     * 
     * @return descripción del plato
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Permite cambiar la descripción del plato
     * @param descripcion 
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    /**
     * 
     * @return precio del plato
     */
    public double getPrecio() {
        return precio;
    }
    
    /**
     * Permite cambiar el precio del plato
     * @param precio 
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    /**
     * 
     * @return tipo de menú del plato
     */
    public TipoMenu getTipoMenu() {
        return tipo;
    }
    
    /**
     * Permite cambiar el tipo de menú del plato
     * @param tipo 
     */
    public void setTipoMenu(TipoMenu tipo) {
        this.tipo = tipo;
    }
    
    /**
     * Leer el archivo de menu.txt, crea los respectivos objetos y los almacena en una lista para retornarlos
     * @return 
     */
    public static ArrayList<Menu> leerMenus() {
        ArrayList<Menu> listMenu = new ArrayList<>();
        try ( BufferedReader br = new BufferedReader(new FileReader(App.pathFiles + "menu.txt", StandardCharsets.UTF_8))) {
            String linea = br.readLine();
            while ((linea = br.readLine()) != null) {
                String[] sep = linea.trim().strip().split(",");
                listMenu.add(new Menu(sep[0], Double.valueOf(sep[1]), TipoMenu.valueOf(sep[2])));
            }
        } catch (IOException ex) {
            System.out.println("No se pudo leer el archivo menu.txt");
        }
        return listMenu;
    }
    
    public static TipoMenu obtenerTipo(String s) {

        TipoMenu resultado = null;
        if (s != null) {
            if (s.equals("Platos Fuertes")) {
                resultado = TipoMenu.F;
            } else if (s.equals("Postres")) {
                resultado = TipoMenu.P;
            } else if (s.equals("Bebidas")) {
                resultado = TipoMenu.B;
            } else if (s.equals("Piqueos")) {
                resultado = TipoMenu.Q;
            }
        }
        return resultado;

    }

    @Override
    public int compareTo(Menu m2) {
        return this.descripcion.compareTo(m2.getDescripcion());
    }
    
}
