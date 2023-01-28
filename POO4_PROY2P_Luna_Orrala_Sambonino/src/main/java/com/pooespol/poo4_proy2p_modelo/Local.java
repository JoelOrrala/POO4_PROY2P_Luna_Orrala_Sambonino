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

/** Esta clase hace referencia a los locales que se encuentran distribuidos en la ciudad, a los cuales
 * el cliente puede ir
 *
 * @author joelorrala
 */
public class Local {

    private String nombre;
    private String direccion;
    private String horario;
    private double coordenadaX;
    private double coordenadaY;
    private static ArrayList<Local> listLocales;
    
    /**
     * Constructor de la clase Local
     * @param nombre del local
     * @param direccion del local
     * @param horario del local
     * @param coordenadaX del local dentro del mapa
     * @param coordenadaY del local dentro del mapa
     */
    public Local(String nombre, String direccion, String horario, double coordenadaX, double coordenadaY) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.horario = horario;
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
    }
    
    /**
     * 
     * @return nombre del local
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Permite cambiar el nombre del local
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * 
     * @return dirección del local
     */
    public String getDireccion() {
        return direccion;
    }
    
    /**
     * Permite cambiar la dirección del local
     * @param direccion 
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    /**
     * 
     * @return horario del local
     */
    public String getHorario() {
        return horario;
    }
    
    /**
     * Permite cambiar el horario del local
     * @param horario 
     */
    public void setHorario(String horario) {
        this.horario = horario;
    }
    
    /**
     * 
     * @return coordenada X del local dentro del mapa
     */
    public double getCoordenadaX() {
        return coordenadaX;
    }
    
    /**
     * Permite cambiar la coordenada X del local dentro del mapa
     * @param coordenadaX 
     */
    public void setCoordenadaX(double coordenadaX) {
        this.coordenadaX = coordenadaX;
    }
    
    /**
     * 
     * @return coordenada Y del local dentro del mapa
     */
    public double getCoordenadaY() {
        return coordenadaY;
    }
    
    /**
     * Permite cambiar la coordenada Y del local dentro del mapa
     * @param coordenadaY 
     */
    public void setCoordenadaY(double coordenadaY) {
        this.coordenadaY = coordenadaY;
    }
    
    /**
     * Leer el archivo de locales.txt, crea los respectivos objetos y los almacena en una lista para retornarlos
     * @return lista Locales
     */
    public static ArrayList<Local> leerLocales() {
        listLocales = new ArrayList<>();
        try ( BufferedReader br = new BufferedReader(new FileReader(App.pathFiles + "locales.txt", StandardCharsets.UTF_8))) {
            String linea = br.readLine();
            while (linea != null) {
                String[] lcl = linea.trim().strip().split(",");
                String name = lcl[0];
                String address = lcl[1];
                String shedule = lcl[2];
                double cX = Double.valueOf(lcl[3]);
                double cY = Double.valueOf(lcl[4]);
                Local l = new Local(name, address, shedule, cX, cY);
                listLocales.add(l);
                linea = br.readLine();
            }
        } catch (IOException ex) {
            System.out.println("No se pudo leer el archivo");
        }
        return listLocales;
    }
}
