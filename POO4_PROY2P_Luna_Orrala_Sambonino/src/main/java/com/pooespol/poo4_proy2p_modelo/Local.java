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
public class Local {

    private String nombre;
    private String direccion;
    private String horario;
    private double coordenadaX;
    private double coordenadaY;

    public Local(String nombre, String direccion, String horario, double coordenadaX, double coordenadaY) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.horario = horario;
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public double getCoordenadaX() {
        return coordenadaX;
    }

    public void setCoordenadaX(double coordenadaX) {
        this.coordenadaX = coordenadaX;
    }

    public double getCoordenadaY() {
        return coordenadaY;
    }

    public void setCoordenadaY(double coordenadaY) {
        this.coordenadaY = coordenadaY;
    }

    public static ArrayList<Local> leerLocales() {
        ArrayList<Local> listLocales = new ArrayList<>();
        try ( BufferedReader br = new BufferedReader(new FileReader(App.pathFiles + "locales.txt", StandardCharsets.UTF_8))) {
            String linea = "";
            while ((linea = br.readLine()) != null) {
                String[] lcl = linea.strip().split(",");
                String name = lcl[0];
                String address = lcl[1];
                String shedule = lcl[2];
                double x = Double.parseDouble(lcl[3]);
                double y = Double.parseDouble(lcl[4]);
                Local l = new Local(name, address, shedule, x, y);
                listLocales.add(l);
            }
        } catch (IOException ex) {
            System.out.println("No se pudo leer el archivo");
        }
        return listLocales;
    }
}
